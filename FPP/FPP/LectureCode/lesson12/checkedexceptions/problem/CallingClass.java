package lesson12.checkedexceptions.problem;

public class CallingClass {
	void callingMethod() {
		
			Employee e = new Employee();
			e.clone();
		
			
		
		 // compiler error – must enclose in try/catch
		// or declare that the method throws CloneNotSupportedException
	}
	public static void main(String[] args) {
		(new CallingClass()).callingMethod();
	}
}
