package Lab2.prog2_4;

public class ProductID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String myString= Data.records;
		String[] sp= myString.split(":");
		for  (int i=0;i<sp.length;i++) {
			System.out.println(sp[i].substring(0,sp[i].indexOf(",")));
		}
	}

}
