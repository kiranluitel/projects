package lab8_1;

public class Main {

	
		public static void main(String[] args){
			String[] s = {"big", "small", "tall", "short", "round", "square",
			 "enormous", "tiny","gargantuan", "lilliputian",
			 "numberless", "none", "vast", "miniscule"};
			MyStringList myStringList = new MyStringList(s);
			myStringList.sort();
			System.out.println("Sorted Array is: \n"+myStringList.toString());
			System.out.println("Searching string \"number\" in myList: ");
			if(myStringList.search("number")) {
				System.out.println("Found");
				
			}
			else System.out.println("Not Found");
			System.out.println("Searching string \"tiny\" in myList: ");
			if(myStringList.search("tiny")) {
				System.out.println("Found");
				
			}
			else System.out.println("Not Found");
		}
}
