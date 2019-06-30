package lesson3.callbyvalueorreference.demo;

public class CallByValueObjects {
	public static void main(String[] args) {
		CallByValueObjects c = new CallByValueObjects();
		Employee a = new Employee("Alice","Thompson", 60000, 1995, 2, 10);
		Employee b = new Employee("Bob","Rogers", 70000, 1997, 10, 1);
		c.swap(a, b);
		//To which Employee does the reference a point?
		System.out.println(a.getName());
	}
	public void swap(Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
	}

}
