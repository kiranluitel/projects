package lesson4.equals.asymmetry;

class PersonWithJob extends Person {
	private int salary;

	public PersonWithJob(String n, int s) {
		super(n);
		salary = s;
	}

	@Override
	public boolean equals(Object withJob) {
		if (withJob == null) {
			return false;
		}
		if (!(withJob instanceof PersonWithJob)) {
			return false;
		}
		PersonWithJob p = (PersonWithJob) withJob;
		boolean isEqual = getName().equals(p.getName()) 
				&& this.salary == p.salary;
		return isEqual;
	}

}
