package prog7_2;

public class MinSort {
	String sort(String s) {
		int len = s.length();
		StringBuilder retString = new StringBuilder();;
		Character min = s.charAt(0);
		int minPos;
		for(int i=0;i<len;i++) {
			if (min.compareTo(s.charAt(i)) > 0) min=s.charAt(i);
		}
		minPos = s.indexOf(min);
		if (s.length()==1) return s;
		else  {
			retString.append(s.charAt(minPos)+sort(s.substring(0,minPos)+s.substring(minPos+1,s.length())));
			return retString.toString();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinSort ms = new MinSort();
		String result = ms.sort("zwxuabfkafutbbbb");
		System.out.println(result);

	}
}
