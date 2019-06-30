package lab4.lab4_6.case2;

import java.util.GregorianCalendar;

public final class PersonWithJob extends Person {
	private double salary;
	PersonWithJob(String name, GregorianCalendar dob, double salary) {
		super(name, dob);
		this.salary = salary;
	}
	
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		PersonWithJob p = (PersonWithJob) ob ;
		return (p.getName().equals(this.getName()) && p.getDateOfBirth().equals(this.getDateOfBirth())
				&& Math.abs(p.getSalary()-this.getSalary())<0.001);
	}
	
	public double getSalary() {
		return salary;
	}
}
