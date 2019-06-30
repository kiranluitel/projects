package lesson2.userinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UserInput {
	public static void main(String[] args) {
		userInput1();
		try {
			userInput2();
		} catch(IOException e) {
			//handle
		}
		userInput3();
	}
	
	static void userInput1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type your name: ");
		System.out.println("you wrote: "+sc.next());
		System.out.print("Type your age: ");
		System.out.println("your age: "+sc.nextInt());
		sc.close();

	}
	
	static void userInput2() throws IOException {
		BufferedReader in = null;
		String input = null;
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Type your name: ");
		input = in.readLine();
		System.out.println("Your wrote: " + input);
		in.close();

	}
	
	static void userInput3() {
		String input = JOptionPane.showInputDialog("Type your name");
		System.out.println("In dialog you wrote: " + input);
	}
}
