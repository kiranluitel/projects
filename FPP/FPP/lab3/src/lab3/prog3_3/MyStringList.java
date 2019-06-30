package lab3.prog3_3;

public class MyStringList {
	private int size;
	private String[] strArray = new String[2];
	private int initialSize = 2;
	private int incrementSizeMultiplier = 1;
	private String[] temp1;

	public MyStringList() {

		size = 0;
	}

	public void add(String s) {
		size++;
		if (size > strArray.length) {
			resize();
		}
		strArray[size - 1] = s;

	}

	// - adds s to the end of the underlying array
	public String get(int i) {
		if (i>=size|| i<0) return null;
		return strArray[i];
		
	}

	// - retrieves the String at the ith position in the underlying array
	public boolean find(String s) {
		for (int i=0;i<size;i++) {
			if (strArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	// - returns true if String s is found in the array, false otherwise
	public boolean remove(String s) {
		size--;
		boolean check=false;
		for (int i=0;i<size+1;i++) {
			if (strArray[i].equals(s)) check= true;
		}
		temp1= new String[strArray.length];
		int k=0;
		for (int i=0;i<size+1;i++) {
			if (!strArray[i].equals(s)) {
				temp1[k]=strArray[i];
				k++;
			}
		}
		strArray= temp1.clone();
		return check;
	}

	// - removes first occurrence of String s if it is found in the underlying array
//			if found, returns true; if not found returns false
	public String toString() {
		String retString = "";
		for (int i = 0; i < size; i++) {
			if (size > 1) {
				if (i ==0) {

					retString += "[" + strArray[i];
				} else if (i == size - 1) {
					retString += ", " + strArray[i] + "]";
				} else
					retString += ", " + strArray[i];
			}
			else retString+="["+strArray[i]+"]";
		}
		return retString;
	}

//			- returns a String representation of the underlying array
//			here is a typical output:
//			[Bob, Steve, Susan, Mark, Dave]
	public int size() {
		return this.size;
	}

////			- returns the next open position in the underlying array – this is precisely the
	// number of Strings that have been added minus the number of String that have
	// been removed.
	private void resize() {
		System.out.println("Resizing...");
		incrementSizeMultiplier++;
		temp1 = new String[incrementSizeMultiplier * initialSize];
		System.arraycopy(strArray, 0, temp1, 0, strArray.length);
		//for (int i = 0; i < strArray.length; i++) {
		//	temp1[i] = strArray[i];
		//}
		strArray = temp1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStringList l = new MyStringList();
		l.add("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Steve");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Susan");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Dave");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
	}

}
