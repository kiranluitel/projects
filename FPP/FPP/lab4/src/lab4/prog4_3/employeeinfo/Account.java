package lab4.prog4_3.employeeinfo;



public class Account {
	
	private final static double DEFAULT_BALANCE = 0.0;
	protected double balance;
	
	protected Employee employee;

	public double getBalance() {
		return balance;
	}

	public AccountType getAcctType() {
		return AccountType.CHECKING;
	}
		
	

	Account(Employee emp, double balance) {
		employee = emp;
		
		this.balance = balance;
	}

	Account(Employee emp) {
		this(emp, DEFAULT_BALANCE);
	}

	public String toString() {
		return String.format( "%nAccount type : "+this.getAcctType()+ "%nCurrent balance = " + balance);
	}

	public void makeDeposit(double deposit) {
		// implement
		balance+=deposit;
		System.out.println("$"+deposit+" has been deposited in the \n"
				+ ""+this.getAcctType().toString().toLowerCase()+" account of "
						+ ""+employee.getName()+".");
		
		
	}

	public boolean makeWithdrawal(double amount) {
		if (amount <=balance) {
			balance-=amount;
			System.out.println("$"+amount+" is successfully withdrawn "+"from the \n"
					+ ""+this.getAcctType().toString().toLowerCase()+" account of "
					+ ""+employee.getName()+".");
			return true;
		}
		else {
			System.out.println("Insufficient Funds");
		    return false;
		}
	}
}
