package lab4.prog4_3.employeeinfo;


public class AccountList {
	private int size;
	
	private int initialSize = 5;
	private Account[] accArray = new Account[initialSize];
	private int incrementSizeMultiplier = 1;
	private Account[] temp1;

	public AccountList() {

		size = 0;
	}

	public void add(Account s) {
		size++;
		if (size > accArray.length) {
			resize();
		}
		accArray[size - 1] = s;

	}

	// - adds s to the end of the underlying array
	public Account get(int i) {
		if (i>=size|| i<0) return null;
		return accArray[i];
		
	}

	// - retrieves the String at the ith position in the underlying array
	public boolean find(Account s) {
		for (int i=0;i<size;i++) {
			if (accArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	// - returns true if String s is found in the array, false otherwise
	public boolean remove(Account s) {
		size--;
		boolean check=false;
		for (int i=0;i<size+1;i++) {
			if (accArray[i].equals(s)) check= true;
		}
		temp1= new Account[accArray.length];
		int k=0;
		for (int i=0;i<size+1;i++) {
			if (!accArray[i].equals(s)) {
				temp1[k]=accArray[i];
				k++;
			}
		}
		accArray= temp1.clone();
		return check;
	}

	// - removes first occurrence of String s if it is found in the underlying array
//			if found, returns true; if not found returns false
	/*public String toString() {
		String retString = "";
		for (int i = 0; i < size; i++) {
			if (size > 1) {
				if (i ==0) {

					retString += "[" + accArray[i];
				} else if (i == size - 1) {
					retString += ", " + accArray[i] + "]";
				} else
					retString += ", " + accArray[i];
			}
			else retString+="["+accArray[i]+"]";
		}
		return retString;
	
	}*/

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
		temp1 = new Account[incrementSizeMultiplier * initialSize];
		System.arraycopy(accArray, 0, temp1, 0, accArray.length);
		//for (int i = 0; i < strArray.length; i++) {
		//	temp1[i] = strArray[i];
		//}
		accArray = temp1.clone();

	}
}
