package lab8_2;

import java.util.Collection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStringLinkedList myList = new MyStringLinkedList();
		String[] s={"big", "small", "tall", "short", "round", "square",
		 "enormous", "tiny","gargantuan", "lilliputian",
		 "numberless", "none", "vast", "miniscule"};
		for(int i=s.length-1;i>=0;i--) {
			myList.addFirst(s[i]);
		}
		myList.sort();
		System.out.print("Sorted List is: ");
		myList.printNodes();
		
		System.out.println("\nSearching string \"number\" in myList: ");
		if(myList.recurSearch("number")) {
			System.out.println("Found");
			
		}
		else System.out.println("Not Found");
		System.out.println("Searching string \"tiny\" in myList: ");
		if(myList.recurSearch("tiny")) {
			System.out.println("recurse is "+myList.recurSearch("tiny")+" hence Found");
			
		}
		else System.out.println("recurse is "+myList.recurSearch("tiny")+" hence not Found");
		
			
	}

}
