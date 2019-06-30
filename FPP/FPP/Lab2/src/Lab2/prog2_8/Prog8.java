package Lab2.prog2_8;

public class Prog8 {
	public static int min(int[] a) {
		int min=a[0];
		for (int i=0;i<a.length;i++) {
			if (a[i]<min) {
				min=a[i];
			}
		}
		return min;	
	}
}
