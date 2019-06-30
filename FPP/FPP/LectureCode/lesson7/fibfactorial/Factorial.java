package lesson7.fibfactorial;

/** Recursive Factorial */
public class Factorial {

	public static void main(String[] args) {
		Factorial f = new Factorial();
		f.factorial(12);
	}
	
	public int factorial(int n) {
		System.out.printf("Entering factorial with n = %d%n", n);
		if(n == 0 || n == 1) {
			return 1;
		}
		int retVal = n * factorial(n-1);
		System.out.printf("Returning val %d of factorial(%d)%n", retVal, n);
		return retVal;
	}
}
