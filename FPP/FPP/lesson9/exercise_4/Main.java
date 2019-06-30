package lesson8.exercise_4;

import java.util.*;

@SuppressWarnings("rawtypes")
public class Main {
	public static void main(String[] args) {
		var list1 = ArrayList<String>(){"A", "B", "C"};
		var list2 = ArrayList<String>(){"W", "X", "Y"};
		var listOfLists = ArrayList<ArrayList<String>>(){list1, list2};
		System.out.println(Arrays.toString(listOfLists));
	}
}
    //////Output
    //[[A, B, C], [W, X, Y]]



