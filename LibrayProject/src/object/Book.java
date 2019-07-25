package object;

import java.util.LinkedList;
import java.util.List;

public class Book {
	public Book(String iSBN, List<Author> authors, String title, String shortDescription) {
		super();
		ISBN = iSBN;
		this.authors = authors;
		this.title = title;
		this.shortDescription = shortDescription;
		copies = new LinkedList<BookCopy>();
	}
	public Book(String iSBN, List<Author> authors, String title, String shortDescription,int id) {
		super();
		ISBN = iSBN;
		this.authors = authors;
		this.title = title;
		this.shortDescription = shortDescription;
		copies = new LinkedList<BookCopy>();
		this.id = id;
		
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public List<BookCopy> getCopies() {
		return copies;
	}
	public void setCopies(List<BookCopy> copies) {
		this.copies = copies;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	private String ISBN;
	private List<BookCopy> copies;
	private List<Author> authors;
	private String title;
	private String shortDescription;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void addCopy(BookCopy bookCopy) {
		copies.add(bookCopy);
		
	}
}
