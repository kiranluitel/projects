package lesson9.exercise_1_soln;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class Ex9_1 {
	public static void main(String[] args) {
		//the odd numbers
		Stream odds = Stream.iterate(1, n -> n + 2);
		//odds.collect(Collectors.toList());
		
		
		
		
		
		
		List<Integer> list = Stream.iterate(1, n -> n + 2)
				             .limit(8).skip(4)
				             .collect(Collectors.toList());
		
		System.out.println(list);
		
	}
}
