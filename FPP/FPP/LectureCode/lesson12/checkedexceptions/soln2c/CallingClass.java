package lesson12.checkedexceptions.soln2c;

public class CallingClass {
	void callingMethod() throws ApplicationSpecificException {
		Employee e = new Employee();
		e.makeCopy(); 
	}
}
