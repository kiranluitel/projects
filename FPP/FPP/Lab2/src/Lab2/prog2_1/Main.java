package Lab2.prog2_1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer tom= new Customer("Tom","Smith","111-222-3333");
		Customer pat= new Customer("Patrick","Pollard","555-666-7777");
		Address a1= new Address("Park Street","Beaumont","Texas","77705");
		Address a2= new Address("Chicago Street","Chicago City","Chicago","11111");
		tom.setBillingAddress(a1);
		tom.setShippingAddress(a1);
		pat.setBillingAddress(a2);
		pat.setShippingAddress(a2);
		
		Customer[] addr= {tom,pat};
		for (int i=0;i<addr.length;++i) {
			if (addr[i].getBillingAddress().getState().equals("Chicago")) {
				System.out.println("Customer " +(i+1)+"  has Chicago as billing address who is :" +addr[i].toString());	

			}
		}
	}
	
}
