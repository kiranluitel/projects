package object;

public class User extends Person{
	private int id;
	public User(Address address, String firstName, String lastName, String IDperson, String phoneNumber) {
		super(address, firstName, lastName, IDperson, phoneNumber);
		password = "00";
		// TODO Auto-generated constructor stub
	}
	public User(Address address, String firstName, String lastName, String IDperson, String phoneNumber, int idUser) {
		super(address, firstName, lastName, IDperson, phoneNumber);
		this.id = idUser;
		// TODO Auto-generated constructor stub
	}
	public User(Address address, String firstName, String lastName, String IDperson, String phoneNumber, String password,int idUser) {
		super(address, firstName, lastName, IDperson, phoneNumber);
		this.password = password;
		this.id = idUser;
		// TODO Auto-generated constructor stub
	}
	public User(Address address, String firstName, String lastName, String IDperson, String phoneNumber, String password) {
		super(address, firstName, lastName, IDperson, phoneNumber);
		this.password = password;
		// TODO Auto-generated constructor stub
	}
	public String menuUrl() {
		return null;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserID(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
}
