package lab3.prog3_1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee kiran= new Employee("Kiran", "Luitel", 100000,2019,01,01);
		Account kiran1= new Account(kiran,AccountType.CHECKING,300);
		Account kiran2= new Account(kiran,AccountType.RETIREMENT,300);
		Account kiran3= new Account(kiran,AccountType.SAVINGS,300);
		String output= String.format("Account Holder Name: %s %nAccount Information: %s %nAccount Information: %s %nAccount Information: %s ",kiran.getName(),kiran1.toString(),kiran2.toString(),kiran3.toString());
		System.out.println(output);
	}

}
