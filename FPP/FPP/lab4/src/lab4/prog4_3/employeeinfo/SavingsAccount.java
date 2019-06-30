package lab4.prog4_3.employeeinfo;

import java.time.LocalDate;

public class SavingsAccount extends Account {
	private final double INTEREST_RATE=0.25;
	
	public SavingsAccount (Employee emp, double startAmount) {
		super(emp,startAmount);
		}
	@Override
	public double getBalance() {
		double interest= INTEREST_RATE/100.0*super.getBalance();
		return super.getBalance()+interest;
		
	}
	@Override
	public AccountType getAcctType() {
		return AccountType.SAVINGS;
	}
}