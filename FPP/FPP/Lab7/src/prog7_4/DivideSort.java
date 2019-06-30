package prog7_4;

public class DivideSort {
	String divideSort(String s) {
		int mid = s.length()/2;
		int len = s.length();
		Merge m = new Merge();
		
		if (len == 0 || len == 1) {
			return s;
		}
		String firstHalf = divideSort(s.substring(0,mid));
		String secondHalf = divideSort(s.substring(mid,len));
		 return m.merge(firstHalf,secondHalf);
	}
	public static void main(String[] args) {
		DivideSort d = new DivideSort();
		System.out.println(d.divideSort("kiranluitel"));
	}
}
