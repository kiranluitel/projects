package prog11_1;

import java.util.HashMap;
import java.util.Iterator;

public class Employee {
	private String firstName;
	private String lastName;
	private double average=0;
	private int count=0;
	private HashMap<String,Double> salaryRecord = new HashMap<>(5);
	
	public void addEntry(String date, double salary) {
		//implement
		salaryRecord.put(date, salary);
		
	}
	public void printPaymentAmount(String date) {
		//implement
		if(salaryRecord.get(date)==null) {
			System.out.println(this.getFirstName()+" "+this.getLastName()+" was not paid on "+date);
			return;
		}
		System.out.println(this.getFirstName()+" "+this.getLastName()+" was paid "+salaryRecord.get(date)+" on "+date);
	}
	public void printAveragePaycheck() {
		//implement
	
			
		salaryRecord.forEach(
				(date,salary)->{
					average +=salary;
					count++;
				}
				);
		double c = (double) count;
		average = average/count;
		System.out.println("Average paycheck for "+this.getFirstName()+" "+this.getLastName()+" was "+average);
	}
	
	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setFirstName("Jim");
		e.setLastName("Jones");
		for(int i = 1; i <= 12; ++i) {
			e.addEntry(i+"/15/2011", 3070+5*i);
		}
		e.printPaymentAmount("3/15/2011");
		e.printPaymentAmount("5/15/2010");
		e.printAveragePaycheck();
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
