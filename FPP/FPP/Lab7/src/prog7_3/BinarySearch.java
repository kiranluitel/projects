package prog7_3;

public class BinarySearch {
	
	public boolean search(String s, char c) {
		int m = s.length()/2;
		Character ch = s.charAt(m);
		
		if (m == 0 || m == 1) return ch==c;
		if( ch == c) {
			return true;
		}
		
		
		else if (ch.compareTo(c) > 0) {
			return search(s.substring(0,m),c);
		}
		else {
			return search(s.substring(m+1,s.length()),c);
		}
	}
//	test
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		BinarySearch bs = new BinarySearch();
		boolean expResult = true;
		System.out.println("substring: "+"abc".substring(2,3));
		System.out.println("CompareTo test: "+"c".compareTo("d"));
		System.out.println("Integer division test: "+3/2);
		boolean result = bs.search("abc", 'b');
		System.out.println(result);
	}

}
