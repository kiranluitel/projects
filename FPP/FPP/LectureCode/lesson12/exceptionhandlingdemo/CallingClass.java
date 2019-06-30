package lesson12.exceptionhandlingdemo;

import java.io.IOException;
import java.util.logging.Logger;

public class CallingClass {
	private static final Logger LOG 
	  = Logger.getLogger(
		   CallingClass.class.getPackage().toString());
	MyClass m = new MyClass();
	
	public void callingMethod() {
		try {
			m.myMethod();
			
		} catch(IOException e) {
			LOG.warning("IO");
			displayMessage("Cannot read file.");
		}
	}
	private void displayMessage(String s) {
		//code not shown
	}
}




