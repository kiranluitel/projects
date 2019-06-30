package Lab2.prog2_6;

public class Prog6 {
	public static String[] removeDups(String[] array) {
		String [] a = new String[array.length];
		boolean check;
		int k=0;
		for (int i=0;i<array.length;i++) {
			check=true;
			for (int j=0;j<i;j++) {
				if (array[i].equals(array[j])) {
					check=false;
				}
			}
			if (check==true) {
				a[k]=array[i];
				k++;
			}
		}
		String[] retString= new String[k];
		for (int i=0;i<k;i++) retString[i]=array[i];
		return retString;
	}

}
