package exer5_3;



public class Account {
	AccountType CHECKING= AccountType.CHECKING;
	AccountType SAVINGS= AccountType.SAVINGS;
	AccountType RETIREMENT= AccountType.RETIREMENT;
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountType acctType;
	private Employee employee;

	public double getBalance() {
		return balance;
	}

	public AccountType getAcctType() {
		return acctType;
	}

	Account(Employee emp, AccountType acctType, double balance) {
		employee = emp;
		this.acctType = acctType;
		this.balance = balance;
	}

	Account(Employee emp, AccountType acctType) {
		this(emp, acctType, DEFAULT_BALANCE);
	}

	public String toString() {
		return String.format( "%nAccount type : " + acctType + "%nCurrent balance = " + balance);
	}

	public void makeDeposit(double deposit) {
		// implement
		balance+=deposit;
	}

	public boolean makeWithdrawal(double amount) {
		if (amount <=balance) {
			balance-=amount;
			return true;
		}
		return false;
	}
}
