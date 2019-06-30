package lab9.prog9_1;

public class MyStringStack {
	private MyStringLinkedList list;
	public MyStringStack() {
		list = new MyStringLinkedList();
	}
	
	public String pop() {
		//implement
		String s = peek();
		list.remove(0);
		return s;
	
	}
	public String peek() {
		//implement
		return list.get(0);
	}
	
	public void push(String s) {
		//implement
		list.add(s);
	}
}
