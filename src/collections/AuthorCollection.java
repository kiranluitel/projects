package collections;

import java.util.LinkedList;
import java.util.List;

import object.Address;
import object.Author;

public class AuthorCollection {
	public static List<Author> defaultList(){
		List<Author> authors = new LinkedList<Author>();
		authors.add(new Author(new Address("2000", "California","720019","Los Angeles"),
				"Carlos","Hoffmann","132","630562","Credentials","Short bio"));
		return authors;
	}
}
