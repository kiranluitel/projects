package lab4.prog4_1;

import java.time.LocalDate;

public class DeptEmployee {
	protected String name;
	protected LocalDate hireDate;
	protected double salary;
	
	public DeptEmployee(String name, double salary) {
		this.name=name;
		this.salary=salary;
	}
	
	public void setSalary(double salary) {
		this.salary=salary;
	}
	public double computeSalary() {
		return salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
}
