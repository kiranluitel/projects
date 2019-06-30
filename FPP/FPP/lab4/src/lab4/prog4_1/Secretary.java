package lab4.prog4_1;

public class Secretary extends DeptEmployee {
	private double overtimeHours;
	
	public Secretary (String name, double salary) {
		super(name,salary);
		setOvertimeHours(200.0);
		
	}
	
	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours=overtimeHours;
	}
	public double getOvertimeHours() {
		return overtimeHours;
	}
	
	@Override
	public double computeSalary() {
		this.salary+=12*overtimeHours;
		return this.salary;
	}

}
