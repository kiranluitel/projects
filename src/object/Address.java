package object;

public class Address {
	private String street;
	private String state;
	private String zip;
	private String city;
	private int ID;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(String street, String state, String zip, String city) {
		super();
		this.street = street;
		this.state = state;
		this.zip = zip;
		this.city = city;
	}
	public Address(String street, String state, String zip, String city, int id) {
		super();
		this.street = street;
		this.state = state;
		this.zip = zip;
		this.city = city;
		this.ID = id;
	}
	public void setID(int insertAddress) {
		// TODO Auto-generated method stub
		ID = insertAddress;
	};
	public int getID() {
		return ID;
	}
}
