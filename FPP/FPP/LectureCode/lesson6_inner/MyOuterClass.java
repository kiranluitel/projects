package lesson6_inner;

import java.util.Arrays;

class MyOuterClass {
	MyInnerClass inner;
	private String param;

	MyOuterClass(String param) {
		inner = new MyInnerClass("innerStr");
		this.param = param; // the outer class version of this
	}

	void outerMethod() {
		System.out.println(inner.innerParam);
		inner.innerMethod();
		//String t = inner.this.innerParam; //compiler error
		inner.innerMethod();
	}

	class MyInnerClass {
		private String innerParam;

		MyInnerClass(String innerParam) {
			// the inner class version of 'this'
			this.innerParam = innerParam;
		}

		void innerMethod() {
			// accessing enclosing class’s version of this
			System.out.println(MyOuterClass.this.param);

			// same as the following
			System.out.println(param);
		}
	}

	public static void main(String[] args) {
		//(new MyOuterClass("outerStr")).outerMethod();
		String str = "IJKaBLKeIJKLk";
		System.out.println(Arrays.asList(str.split("a|e|k")));
	}
}
