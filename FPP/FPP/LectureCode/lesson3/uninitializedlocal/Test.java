package lesson3.uninitializedlocal;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		t.myMethod();
	}
	
	public void myMethod() {
		int x;
		//System.out.println(x);
	}

}
