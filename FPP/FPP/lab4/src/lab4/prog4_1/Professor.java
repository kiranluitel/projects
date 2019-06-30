package lab4.prog4_1;


public class Professor extends DeptEmployee {
	private int noOfPublications;

	public Professor(String name, double salary, int noOfPublications) {
		super(name, salary);
		setNoOfPublications(noOfPublications);
	}

	public Professor(String name, double salary ) {
		super(name, salary);
		setNoOfPublications(10);
	}
	public int getNoOfPublications() {
		return noOfPublications;
	}

	public void setNoOfPublications(int noOfPublications) {
		this.noOfPublications = noOfPublications;
	}
	
}
