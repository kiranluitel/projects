package prog10_2;

public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator ) {
		if (denominator <= 0) throw new IllegalStateException("Illegal denominator"); 
			
		
		
		this.numerator= numerator;
		this.denominator = denominator;
	}
	public Rational add(Rational rat) {
	//multiplies rat by this Rational
	int a = numerator * rat.denominator+rat.numerator*denominator;
	int b = denominator*rat.denominator;
	return reduceToSimpleForm(a,b);
	
	}
	
	public Rational multiply(Rational rat) {
		int a =numerator*rat.numerator;
		int b=denominator*rat.denominator;
		return reduceToSimpleForm(a,b);
	}
	//returns –1 if this rational is less than rat
	//returns 0 if this rational equals (see equals
	// method discussion below) rat
	//returns 1 if this rational is greater than rat
	public int compareTo(Rational rat) {
		
		
		
		
		int comp1 =numerator * rat.denominator;
		int comp2 =rat.numerator *denominator;
		
		if (comp1 == comp2) return 0;
		else if (comp1 > comp2) return 1;
		else return -1;
		
	}
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if (getClass() != o.getClass()) return false;
		Rational r = (Rational) o;
		if (numerator*r.denominator == r.numerator*denominator) return true;
		return false;
	}
	@Override
	public String toString() {
		return numerator+"/"+denominator;
	}
	
	private Rational reduceToSimpleForm(int numerator, int denominator) {
		while ((numerator %2==0 && denominator%2==0)
				||(numerator %3==0 && denominator%3==0)
				||(numerator %5==0 && denominator%5==0)
				||(numerator %7==0 && denominator%7==0)
				||(numerator %11==0 && denominator%11==0)) {
			if (numerator %2==0 && denominator%2==0) {
				numerator /=2;
				denominator /=2;
			}
			if (numerator %3==0 && denominator%3==0) {
				numerator /=3;
				denominator /=3;
			}
			if (numerator %5==0 && denominator%5==0) {
				numerator /=5;
				denominator /=5;
			}
			if (numerator %7==0 && denominator%7==0) {
				numerator /=7;
				denominator /=7;
			}
			if (numerator %11==0 && denominator%11==0) {
				numerator /=11;
				denominator /=11;
			}
		}
		return new Rational(numerator,denominator);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(2/3 * -17/5) + 1/3,
		//2/3 * (-17/5 + 1/3),
		Rational a = new Rational(2,3);
		Rational b = new Rational(-17,5);
		Rational c = new Rational(1,3);
		Rational firstOutput = (a.multiply(b)).add(c);
		Rational secondOutput = a.multiply(b.add(c));
		System.out.println("(2/3 * -17/5) + 1/3 is : "+firstOutput);
		System.out.println("2/3 * (-17/5 + 1/3) is : "+secondOutput);
		int compare = firstOutput.compareTo(secondOutput);
		if (compare == 0) {
			System.out.println("(2/3 * -17/5) + 1/3 is equals to 2/3 * (-17/5 + 1/3)");
		}
		if (compare == -1) {
			System.out.println("(2/3 * -17/5) + 1/3 is less than 2/3 * (-17/5 + 1/3)");
		}
		if (compare == 1) {
			System.out.println("(2/3 * -17/5) + 1/3 is greater than 2/3 * (-17/5 + 1/3)");
		}
	}

}
