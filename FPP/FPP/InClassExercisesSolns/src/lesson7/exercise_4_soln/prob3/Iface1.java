package lesson7.exercise_4_soln.prob3;

public interface Iface1 {
	default int myMethod(int x) {
		return 2 * x;
	}
}
