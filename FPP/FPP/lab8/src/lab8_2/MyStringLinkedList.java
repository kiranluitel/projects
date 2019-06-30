package lab8_2;

import java.util.AbstractList;

public class MyStringLinkedList extends AbstractList<String>{
	Node header;
	MyStringLinkedList(){
		header = new Node(null,null, null);
	}
	public void addFirst(String item){
		Node n = new Node(header.next,header,item);
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;
		
	}
	public void insert(String data, int pos) {
		Node n = new Node(null,null,data);
		Node temp = header;
		int count =0;
		while (count < pos) {
			temp =temp.next;
			count++;
		}
		n.next = temp.next;
		n.previous = temp;
		temp.next = n;
	}
	
	
	public boolean remove(String s) {
		Node temp = header;
		boolean ret = false;
		while(temp.next.value.equals(s) !=true ||temp.next !=null) {
			temp = temp.next;
			if(temp.next.value.equals(s)) ret = true;
		}
		Node toBeRemovedNode = temp.next;
		temp.next = toBeRemovedNode.next;
		toBeRemovedNode.next.previous =temp;
		return ret;
	}
//	public void sort() {
//		//implement
//		int len = size();
//		for(int i=0;i<len;i++) {
//			int nextMinPos=minpos(i,len-1);
//			swap(i,nextMinPos);
//		}
//		
//	}
	public void sort() {
		if(header==null || size()<=1) return;
		Node current = header;
		Node min;
		int len = size();
		for( int i=0;i<len;i++) {
			current =current.next;
			min = minNode(current);
			swap(current, min);
		}
	}
	public void swap(Node n1, Node n2) {
		String temp = n1.value;
		n1.value = n2.value;
		n2.value = temp;
	}
	public Node minNode(Node n) {
		Node temp = n;
		Node min=temp;
		while(temp.next!=null) {
			if(temp.next.value.compareTo(min.value)<0) {
				min = temp.next;
			}
			temp=temp.next;
		}
		return min;
	}
	public int size() {
		Node current = header;
		int count =0;
		while(current.next !=null) {
			count++;
			current = current.next;
		}
		return count;
	}
//	
//	void swap(int i, int j) {
//		Node current = header;
//		Node swapA = new Node(null,null,null);
//		for (int k=0;k<j+1;k++) {
//			current=current.next;
//			if(k==i) {
//				swapA=current;
//			}
//		}
//		String temp = current.value;
//		current.value =swapA.value;
//		swapA.value=temp;
//		
//	}
//
//	// Returns pos of min value from
//	// positions i to j
//	int minpos(int i, int j) {
//		Node current=header;
//		if(header.next==null) return -1;
//		String min=header.next.value; int minpos=i;
//		for (int k=0;k<j+1;k++) {
//			current=current.next;
//			if(k==i) {
//				min=current.value;
//			}
//			if (k>i) {
//				if(min.compareTo(current.value)>0) {
//					min =current.value;
//					minpos=k;
//				}
//			}
//		}
//		return minpos;
//	}
	
	public boolean recurSearch(String data) {
		return recurSearch(data,header);
	}
	private boolean recurSearch(String data, Node current) {
		if (current.next==null) return false;
		
		if (current.next.value.equals(data)) return true;
		else return recurSearch(data,current.next);
		
	}
	
	void printNodes() {
		Node next = header.next;
		if(next == null) System.out.println("");
		else {
			String s= next.toString();
			System.out.println(s);
		}
	}
	class Node {
		String value;
		Node next;
		Node previous;
		Node(Node next, Node previous, String value){
			this.next = next;
			this.previous = previous;
			this.value = value;
		}
		@Override
		public String toString() {
		    if(value == null) return "";
			StringBuilder sb = new StringBuilder(value + " ");
			sb = toString(sb, next);
			return sb.toString();
		}
		private StringBuilder toString(StringBuilder sb, Node n) {
			if(n == null) return sb;
			sb.append(n.value + " ");
			return toString(sb, n.next);
		}
		
		
	}
	public static void main(String[] args) {
		MyStringLinkedList list = new MyStringLinkedList();
		list.addFirst("A");
		list.addFirst("B");
		list.printNodes();
	}
	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		Node current= header;
		for (int i=0;i<=index;i++) {
			current= current.next;
		}
		return current.value;
	}
	
}


