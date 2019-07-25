package collections;

import java.util.LinkedList;
import java.util.List;

import object.Address;
import object.Author;
import object.Book;
import object.BookCopy;

public class BookCollection {
	public static List<Book> defaultList(){
		List<Book> list = new LinkedList<Book>();
		List<Author> authors = AuthorCollection.defaultList();
		list.add(new Book("231908-43289", authors, "Chemistry","Chemistry book"));
		list.get(0).addCopy(new BookCopy(0, list.get(0)));
		list.add(new Book("238914-43928", authors, "Physics", "Physics book"));
		return list;
	}
}
