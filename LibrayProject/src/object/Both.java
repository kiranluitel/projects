package object;

import helper.Util;

public class Both extends User{

	public Both(Address address, String firstName, String lastName, String ID, String phoneNumber) {
		super(address, firstName, lastName, ID, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public String menuUrl() {
		return Util.AdministratorBothView;
	}
}
