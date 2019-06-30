package lesson8.singlylinked;

public class SinglyLinkedListWithHeader {
	Node header = null; //contains no data, cannot be removed
	
	public SinglyLinkedListWithHeader() {
		//header should never be null
		header = new Node();
	}
	boolean search(String s) {
		if(s == null) return false;
		//start node for searches is header.node
		Node next = header.node;
		while(next != null) {
			String t = next.data;
			if(s.equals(t)) {
				return true;
			}
			next = next.node;
		}
		return false;
	}
	
	void printNodes() {
		Node next = header.node;
		if(next == null) System.out.println("");
		else {
			String s= next.toString();
			System.out.println(s);
		}
	}
	
	void addFirst(String s) {
		Node newNode = new Node();
		newNode.data = s;
		
		//link from newNode to current header.node
		newNode.node = header.node;
		
		//link from header to newNode
		header.node = newNode;		
	}
	
	void addLast(String s) {
		Node newNode = new Node();
		newNode.data = s;
		Node last = header;
		while(last.node != null) {
			last = last.node;
		}
		//now last is the last non-null node
		last.node = newNode;		
	}
	void insert(String s, int pos) {
		int size = size();
		if(pos < 0 || pos > size) {
			throw new IllegalArgumentException(
				"Illegal position for new node");
		}
		if(pos == size) addLast(s); //same as add(s);
		else if(pos == 0) addFirst(s);
		else {
			Node n = new Node();
			n.data = s;
			if(header.node == null) header.node = n;
			else {
				Node temp = header.node;
				int count = 1; 
				while(count < pos) {
					temp = temp.node;
					count++;
				} 
				//insert n between temp and temp.node
				Node last = temp.node;
				temp.node = n;
				n.node = last;  //placing n into position pos
			}
		}
	}
	
	/** size = the number of non-null nodes */
	int size() {
		if(header.node == null) return 0;
		Node temp = header.node;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.node;
		}
		return count;	
	}
	
	void remove(String s) {
		if(s == null) return;
		Node next = header.node;
		Node previous = header;
		//if next == null, s cannot be removed
		while(next != null) {
			if(s.equals(next.data)) {
				previous.node = next.node;
				return;
			}
			previous = next;
			next = next.node;		
		}
	}
	
	/** Implement as inner class */
	private class Node {
		String data;
		Node node;
		
		@Override
		public String toString() {
		    if(data == null) return "";
			StringBuilder sb = new StringBuilder(data + " ");
			sb = toString(sb, node);
			return sb.toString();
		}
		private StringBuilder toString(StringBuilder sb, Node n) {
			if(n == null) return sb;
			sb.append(n.data + " ");
			return toString(sb, n.node);
		}
	}
	
	public static void main(String[] args) {
		String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
		SinglyLinkedListWithHeader sll = new SinglyLinkedListWithHeader();
		//populate
		for(int i = stringData.length -1; i >= 0; i--) {
			sll.addFirst(stringData[i]);
		}
		boolean foundCharles = sll.search("Charles");
		System.out.println("Found Charles? " + foundCharles);
		
		sll.printNodes();
		sll.addFirst("Frank");
		sll.remove("David");
		sll.printNodes();
		sll.addLast("Francesca");
		sll.printNodes();
		System.out.println(sll.size());
		sll.insert("Becky", 0);
		sll.printNodes();
		sll.insert("Bobby", sll.size());
		sll.printNodes();
		sll.insert("Bubba", sll.size()-1);
		sll.printNodes();
	}
}


