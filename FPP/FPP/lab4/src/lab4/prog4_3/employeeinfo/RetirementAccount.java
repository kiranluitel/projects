package lab4.prog4_3.employeeinfo;

public class RetirementAccount extends Account {
	public RetirementAccount(Employee emp, double startAmount) {
		super(emp,startAmount);
	}
	
	@Override
	public boolean makeWithdrawal(double amount) {
		if (amount <=super.getBalance()) {
			double baseBalance = super.getBalance();
			baseBalance-=amount;
			System.out.println("$"+amount+" is successfully withdrawn "+"from the \n"
					+ ""+this.getAcctType().toString().toLowerCase()+" account of "
					+ ""+employee.getName()+".");
			System.out.println("2% has been deducted as penalty for withdrawing "
					+ "from Retirement Account.");
			return true;
		}
		else {
			System.out.println("Insufficient Funds");
		    return false;
		}
	}
	@Override
	public AccountType getAcctType() {
		return AccountType.RETIREMENT;
	}
}
