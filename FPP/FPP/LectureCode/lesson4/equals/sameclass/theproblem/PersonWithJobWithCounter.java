package lesson4.equals.sameclass.theproblem;

class PersonWithJobWithCounter extends PersonWithJob {
	static private int counter;

	PersonWithJobWithCounter(String n, double s) {
		super(n, s);
		counter++;
	}
}
