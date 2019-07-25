package object;

import java.time.LocalDate;

public class Fine {
	private LocalDate returnedDate;
	private double fineValue;
	public Fine(LocalDate returnedDate, double fineValue) {
		super();
		this.returnedDate = returnedDate;
		this.fineValue = fineValue;
	}
	public LocalDate getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}
	public double getFineValue() {
		return fineValue;
	}
	public void setFineValue(double fineValue) {
		this.fineValue = fineValue;
	}
	
}
