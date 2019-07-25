package collections;

import java.util.ArrayList;
import java.util.List;

import object.Address;
import object.Administrator;

public class AdministratorCollection {

	public static List<Administrator> defaultList(){
		List<Administrator> administrator = new ArrayList<>();
		administrator.add(new Administrator(new Address("1000N 4th St","Iowa","52557","Fairfield"),
				"Kiran", "Luitel","123","45678904"));
		administrator.add(new Administrator(new Address("1000N 5th St","Chicago","52554","Illinois"),
				"Caio", "Schwarcz hoffmann","111","049347249"));
		administrator.add(new Administrator(new Address("1000N 6th St","New York","52234","Brooklyn"),
				"Shiva", "Bhaggan","222","7869186297"));
		return administrator;
	}
}
