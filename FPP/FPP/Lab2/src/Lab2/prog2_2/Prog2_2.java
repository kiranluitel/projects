package Lab2.prog2_2;

public class Prog2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int randomFirst=RandomNumbers.getRandomInt(1,9);
		System.out.println("π^x: "+Math.pow(Math.PI, randomFirst));
		int randomSecond=RandomNumbers.getRandomInt(3,14);
		System.out.println("y^π: "+Math.pow( randomSecond, Math.PI));
	}

}
