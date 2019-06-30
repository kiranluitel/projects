package prog11_2;

import java.util.Arrays;
import java.util.List;

public class Schur {
	int sum =0;

	
	boolean checkForSum(List<Integer> list, Integer z) {
		
		list.forEach(e->sum += e);
		if(list.size()==2)
		return sum==z;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(2,3);
		Schur schur = new Schur();
		System.out.println("Does the sum of each elements in the list is 5 ? " +schur.checkForSum(list,5));
	}

}
