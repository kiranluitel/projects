package lesson8.demo;
import java.util.*;
public class DemoLinkedList {
	
		Node header;
		DemoLinkedList(){
			header = new Node(null,null, null);
		}
		//adds to the front of the list
		public void addFirst(String item){
			Node n = new Node(header.next,header,item);
			if(header.next != null){
				header.next.previous = n;
			}		
			header.next = n;
			
		}
		public String toString() {
			StringBuffer sb = new StringBuffer();
			Node next = header.next;
			while(next != null) {
				sb.append(next.toString() + ", ");
				next = next.next;
			}
			String result = sb.toString();
			if(result.charAt(result.length()-1) == ',') {
				return result.substring(0,result.length()-1);
			}
			return result;
			
			
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
			
			public String toString() {
				return value == null ? "null" : value;
			}
		}
	
		public static void main(String[] args){
			DemoLinkedList list = new DemoLinkedList();
			list.addFirst("Bob");
			list.addFirst("Harry");
			list.addFirst("Steve");
			System.out.println(list);
			LinkedList l = new LinkedList();
			
			
		}
}
