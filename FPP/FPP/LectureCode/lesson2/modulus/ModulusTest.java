package lesson2.modulus;

public class ModulusTest {

	public static void main(String[] args) {
		///////////////old way
		System.out.println("5 mod 4 = "+ (5%4));
		
		//gives negative answer (which is crazy)
		System.out.println("-5 mod 4 = " + (-5%4) + ", which is negative!"); 
		
		//////////////java 8 way
		System.out.println("5 mod 4 = " + Math.floorMod(5,4));
		
		//gives correct answer
		System.out.println("-5 mod 4 = " + Math.floorMod(-5,4) + ", which is >= 0, as it should be");

	}

}
