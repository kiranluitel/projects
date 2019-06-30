package lab4.lab4_6.case3;

import java.util.GregorianCalendar;



public class PersonWithJob {
	private Person person;
	
	private double salary;
	
	PersonWithJob(String name, GregorianCalendar dob, double salary) {
		person = new Person(name,dob);
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof PersonWithJob)) return false;
		PersonWithJob p1 = (PersonWithJob) ob ;
		return (p1.person.equals(person)
				&& Math.abs(p1.getSalary()-this.getSalary())<0.001);
	}
}
