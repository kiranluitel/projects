package sortroutines;

import java.util.Arrays;

import runtime.Sorter;

public class BSTSort extends Sorter {
	private MyBST a = new MyBST();
	@Override
	public int[] sort(int[] arr) {
		a.insertAll(arr);
		return a.readIntoArray();
	}
	public static void main(String[] args) {
		BSTSort bs = new BSTSort();
		System.out.println(Arrays.toString(bs.sort(new int[] {5,2,9,6,3,1,-9,0,-11})));
	}
}
