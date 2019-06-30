package lesson12.checkedexceptions.problem;

import java.util.Date;

class Employee implements Cloneable {
	Date hireDate = new Date();
	@Override
	public Object clone(){
		try {
		
		
		Employee copy = (Employee) super.clone();
		copy.hireDate = (Date) hireDate.clone();
		return copy;
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		return null;

	}

}
