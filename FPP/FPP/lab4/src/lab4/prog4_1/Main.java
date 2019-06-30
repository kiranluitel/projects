package lab4.prog4_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Professor professor1= new Professor("Shiva",5000);
		Professor professor2= new Professor("Raja",5000);
		Professor professor3= new Professor("Kiran",50000);
		Secretary mumSecretary2 = new Secretary("Sec2",2000);
		Secretary mumSecretary1 = new Secretary("Sec1",2000);
		
		DeptEmployee[] deptEmployee = new DeptEmployee[5];
		
		deptEmployee[0] = professor1;
		deptEmployee[1] = professor2;
		deptEmployee[2] = professor3;
		deptEmployee[3] = mumSecretary1;
		deptEmployee[4] = mumSecretary2;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to see the total salary of employee of MUM? (y/n)");
		String check = scan.next();

		if (check.equalsIgnoreCase("y")) {
			double totalSalary=0;
			for (DeptEmployee i : deptEmployee) {
				totalSalary+=i.computeSalary();
			}
			System.out.println("The Total Salary of MUM is : "+totalSalary);
		}
		else System.out.println("Good Bye! Have a Good Day.");
	}

}
