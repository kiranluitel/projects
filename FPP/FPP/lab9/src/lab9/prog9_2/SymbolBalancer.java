package lab9.prog9_2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import lab9.prog9_1.MyStringStack;

public class SymbolBalancer {
	String ODD_DELIMITER = ""+(char)0;
	String filename;
	String text;
	char[] left;
	char[] right;
	String delimiters;
	public SymbolBalancer(String filename) {
		this.filename = filename;
		readFile();
	}
	public void setText(String text) {
		this.text = text;
		delimiters ="";
		for (int i =0; i<text.length();i++) {
			if(text.charAt(i) == '['
					||text.charAt(i) == ']'
							||text.charAt(i) == '{'
									||text.charAt(i) == '}'
											||text.charAt(i) == '('
											||text.charAt(i) == ')') {
				delimiters += text.charAt(i);
				
			}
		}
		
	}
	
	boolean symbolsBalanced(String delimiters){
		//implement
		char c ;
		System.out.println("The Delimiters are: "+delimiters);
		Stack<Character> myStack = new Stack<>();
		for (int i = 0; i< delimiters.length();i++) {
			if (delimiters.charAt(i)=='['
					||delimiters.charAt(i)=='('
				||delimiters.charAt(i)=='{') {
				//System.out.println("Push: "+ delimiters.charAt(i));
				myStack.push(delimiters.charAt(i));
			}
			if (delimiters.charAt(i)==']') {
				c = myStack.pop();
			//	System.out.println("poped: '"+c+"' our array contains: '"+delimiters.charAt(i)+"'");
				if (c != '[') return false;
			}
					if(delimiters.charAt(i)=='}' ) {
						c = myStack.pop();
			//			System.out.println("poped: '"+c+"' our array contains: '"+delimiters.charAt(i)+"'");
						if (c != '{') return false;
					}
					if(delimiters.charAt(i)==')' ){
						c = myStack.pop();
			//			System.out.println("poped: '"+c+"' our array contains: '"+delimiters.charAt(i)+"'");
						if (c != '(') return false;
					}
				 
				
			
		}
		
		return myStack.empty();
	}
	
	public static void main(String[] args) {
		SymbolBalancer sb = new SymbolBalancer("lab9/prog9_2/Employee.java");
		sb.setText(sb.text);
		System.out.println("Delimiters balanced? "+sb.symbolsBalanced( sb.delimiters));
	}
	void readFile() {
		String prefix = System.getProperty("user.dir") + "/src/";
		try {
			Scanner sc = new Scanner(new File(prefix + filename));
			sc.useDelimiter(ODD_DELIMITER);
			text = sc.next();
			System.out.println(text);
			sc.close();
		}
		catch(FileNotFoundException ex) {
			System.err.println("File Not Found Exception " + ex.getMessage());
		}
	}
	
}



