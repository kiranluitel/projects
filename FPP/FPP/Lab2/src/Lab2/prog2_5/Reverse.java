package Lab2.prog2_5;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter your string: ");
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		sc.close();
		System.out.println(a);
		String revString= "";
		for (int i=a.length()-1;i>=0;--i) {
			revString+=a.charAt(i);
		}
		System.out.println("The reversed String is: "+revString);
	}

}
