package lesson12.checkedexceptions.soln2b;

public class CallingClass {
	void callingMethod() throws CloneNotSupportedException {
		Employee e = new Employee();
		e.makeCopy(); 
	}
}
