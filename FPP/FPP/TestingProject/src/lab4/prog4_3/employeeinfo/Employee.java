package lab4.prog4_3.employeeinfo;

import java.time.LocalDate;
import java.util.ArrayList;



public class Employee {

	private ArrayList<Account> accounts = new ArrayList<Account>();
	private String name;
	private LocalDate hireDate;
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
		hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	}

	public String getName() {
		return this.name.toUpperCase();
	}
	public void createNewChecking(double startAmount) {
		// implement
		CheckingAccount checkAcct= new CheckingAccount(this,startAmount);
		accounts.add(checkAcct);
	}

	public void createNewSavings(double startAmount) {
		// implement
		SavingsAccount acct= new SavingsAccount(this,startAmount);
		accounts.add(acct);
		
	}
	

	public void createNewRetirement(double startAmount) {
		// implement
		
	RetirementAccount retireAcct= new RetirementAccount(this,startAmount);
	accounts.add(retireAcct);
	}

	public String getFormattedAcctInfo() {
		// implement
		int lenAccList= accounts.size();
		String output="";
		for (int i=0;i<lenAccList;i++) {
			output+=accounts.get(i).toString();
		}
		return output;
	

	}
	public void deposit(int acctIndex, double amt){
		// implement
		accounts.get(acctIndex).makeDeposit(amt);
	}
	public void withdraw(int acctIndex, double amt){
		// implement
		Account selectedAcct = accounts.get(acctIndex);
	
			selectedAcct.makeWithdrawal(amt);
			
		
			
	}

}
