package collections;

import java.util.ArrayList;
import java.util.List;

import object.Address;
import object.Librarian;

public class LibrarianCollection {

	public static List<Librarian> defaultList(){
		List<Librarian> librarians = new ArrayList<>();
		librarians.add(new Librarian(new Address("1000N 4th St","Iowa","52557","Fairfield"),
				"Kiran", "Luitel","123","45678904"));
		librarians.add(new Librarian(new Address("1000N 5th St","Chicago","52554","Illinois"),
				"Caio", "Schwarcz hoffmann","456","049347249"));
		librarians.add(new Librarian(new Address("1000N 6th St","New York","52234","Brooklyn"),
				"Shiva", "Bhaggan","789","7869186297"));
		return librarians;
	}
}
