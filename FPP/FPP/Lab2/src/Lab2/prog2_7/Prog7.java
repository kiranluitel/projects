package Lab2.prog2_7;

import Lab2.prog2_2.RandomNumbers;

public class Prog7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		randomSet();
	}
	public static void randomSet() {
		String output = "", output2="";
		output = String.format("%16d %12d %12d %12d %n %n", RandomNumbers.getRandomInt(1,99), RandomNumbers.getRandomInt(1,99),RandomNumbers.getRandomInt(1,99),RandomNumbers.getRandomInt(1,99));
		output += String.format("%13s %2d %9s %2d %9s %2d %9s %2d %n","+", RandomNumbers.getRandomInt(1,99), "+", RandomNumbers.getRandomInt(1,99), "+", RandomNumbers.getRandomInt(1,99), "+", RandomNumbers.getRandomInt(1,99));
		output += String.format("%16s %12s %12s %12s %n %n %n %n","____", "____", "____", "____");
		
		output2 = String.format("%16d %12d %12d %12d %n %n", RandomNumbers.getRandomInt(1,99), RandomNumbers.getRandomInt(1,99),RandomNumbers.getRandomInt(1,99),RandomNumbers.getRandomInt(1,99));
		output2 += String.format("%13s %2d %9s %2d %9s %2d %9s %2d %n","+", RandomNumbers.getRandomInt(1,99), "+", RandomNumbers.getRandomInt(1,99), "+", RandomNumbers.getRandomInt(1,99), "+", RandomNumbers.getRandomInt(1,99));
		output2 += String.format("%16s %12s %12s %12s %n %n","____", "____", "____", "____");
		System.out.println(output+output2);
	}
}
