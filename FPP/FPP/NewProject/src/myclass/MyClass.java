package myclass;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyClass {
		StringBuilder sb = new StringBuilder();
		public  String mergeSort(String a, String b) {
			
			if(a.length()==0 ) return (this.sb.append(b).toString());
			if(b.length()== 0) return sb.append(b).toString();
			if(a.charAt(0) >= b.charAt(0)) {
				sb.append(b.charAt(0));
				return mergeSort(a,b.substring(1));
			}
			else {
				sb.append(a.charAt(0));
				return mergeSort(a.substring(1),b);
			}
			
			
		}

		public static void main(String[] args) {
//			MyClass myClass = new MyClass();
//				System.out.println(myClass.mergeSort("abcde","abfghijkl"));
			

}

	
}
