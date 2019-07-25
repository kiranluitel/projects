package object;

public class Member extends Person{
	private int idMember;
	public Member(Address address, String firstName, String lastName, String ID, String phoneNumber) {
		super(address, firstName, lastName, ID, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public Member(Address address, String firstName, String lastName, String ID, String phoneNumber,int idMember) {
		super(address, firstName, lastName, ID, phoneNumber);
		this.idMember = idMember;
		// TODO Auto-generated constructor stub
	}
	
	private CheckoutRecord checkoutRecord;

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}

	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int id) {
		this.idMember = id;
	}
}
