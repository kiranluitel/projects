package object;

public class Person {
	private Address address;
	private String firstName;
	private String lastName;
	private String ID;
	private String phoneNumber;
	public Person(Address address, String firstName, String lastName, String ID, String phoneNumber) {
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getID() {
		return ID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
