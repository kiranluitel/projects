package lab3.employeeinfo;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import lab3.prog3_1.AccountType;

public class Employee {

	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
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
		checkingAcct= new Account(this,AccountType.CHECKING,startAmount);
	}

	public void createNewSavings(double startAmount) {
		// implement
		savingsAcct= new Account(this,AccountType.SAVINGS,startAmount);
		
	}
	

	public void createNewRetirement(double startAmount) {
		// implement
		
	retirementAcct= new Account(this,AccountType.RETIREMENT,startAmount);
	}

	public String getFormattedAcctInfo() {
		// implement
	String output="";	
		if (checkingAcct!=null) {
		output+=this.checkingAcct.toString()	;
		}
		
		if (savingsAcct!=null) {
		output+=this.savingsAcct.toString()	;
		}
		
		if (retirementAcct!=null) {
		output+=this.retirementAcct.toString()	;
		}
		return output;

	}
	public void deposit(AccountType acctType, double amt){
		// implement
		if (acctType==AccountType.CHECKING) {
			this.checkingAcct.makeDeposit(amt);
		}
		
		if (acctType==AccountType.SAVINGS) {
			this.savingsAcct.makeDeposit(amt);
		}
		
		if (acctType==AccountType.RETIREMENT) {
			this.retirementAcct.makeDeposit(amt);
		}
	}
	public boolean withdraw(AccountType acctType, double amt){
		// implement
		
		if (acctType==AccountType.CHECKING) {
			this.checkingAcct.makeWithdrawal(amt);
			return true;
		}
		
		else if (acctType==AccountType.SAVINGS) {
			this.savingsAcct.makeWithdrawal(amt);
			return true;
			
		}
		
		else if (acctType==AccountType.RETIREMENT) {
			this.retirementAcct.makeWithdrawal(amt);
			return true;
		}
		else	return false;
	}

}
