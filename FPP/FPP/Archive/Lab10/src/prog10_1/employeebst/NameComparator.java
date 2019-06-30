package prog10_1.employeebst;
import java.util.Comparator;
public class NameComparator implements Comparator<Employee> {
	//compareTo in this case is not consistent with equals
	public int compare(Employee e1, Employee e2) {
		if(e1.getName().compareTo(e2.getName()) !=0) {
			return (e1.getName().compareTo(e2.getName()));
		}
		else if (e1.getHireDate().compareTo(e2.getHireDate()) !=0) {
			return e1.getHireDate().compareTo(e2.getHireDate());
		}
		else return Double.compare(e1.getSalary(), e2.getSalary());
	}

}
