package Lab2.prog2_3;

public class Prog3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float a= (float) 1.27;
		float b= (float) 3.881;
		float c= (float) 9.6;
		float sum= a+b+c;
		int sumByCasting= (int) sum;
		int sumByRound= (int) Math.round(sum);
		System.out.println("SumByCasting = "+sumByCasting);
		System.out.println("SumByRounding = "+sumByRound);
	}

}
