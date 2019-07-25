package object;

import helper.Util;

public class Librarian extends User {

	public Librarian(Address address, String firstName, String lastName, String ID, String phoneNumber) {
		super(address, firstName, lastName, ID, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public Librarian(Address address, String firstName, String lastName, String ID, String phoneNumber,String pass) {
		super(address, firstName, lastName, ID, phoneNumber,pass);
		// TODO Auto-generated constructor stub
	}
	public Librarian(Address address, String firstName, String lastName, String ID, String phoneNumber,String pass, int idUser) {
		super(address, firstName, lastName, ID, phoneNumber,pass, idUser);
		// TODO Auto-generated constructor stub
	}
	public Librarian(Address address, String firstName, String lastName, String ID, String phoneNumber, int idUser) {
		super(address, firstName, lastName, ID, phoneNumber, idUser);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String menuUrl() {
		return Util.MemberSearchView;
		}

}
