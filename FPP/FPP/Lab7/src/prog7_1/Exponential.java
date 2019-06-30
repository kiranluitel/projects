package prog7_1;

public class Exponential {
	double power(double x, int n) {
		if (n==1) return x;
		else return x*power(x,n-1);
	}
	public static void main(String[] args) {
		Exponential exp = new Exponential();
		System.out.println("The value of power(2,10) is : "+exp.power(2,10));
	}

}
