package exer5_3;



public class Main {
	Employee[] emps = new Employee[3];	 
	public String getMyData() {

	
		emps[0] = new Employee("Jim Daley", 2000, 9, 4);
		emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
		emps[2] = new Employee("Susan Randolph", 1997, 2, 13);

		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);
		
		
		return getFormattedAccountInfo(emps);
	}
	String getFormattedAccountInfo(Employee[] arr) {
		String result = "";

		for (int i = 0; i < emps.length; i++) {
			result+=String.format("%n%nACCOUNT INFO FOR %s%n%n",arr[i].getName());
			result += emps[i].getFormattedAcctInfo();

		}
		return result;
	}

}
