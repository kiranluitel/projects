package object;

public class BookCopy {
	public BookCopy(int iD, Book book) {
		ID = iD;
		this.book = book;
		this.availability = true;
	}
	public BookCopy(int iD, Book book, int numberOfDays) {
		ID = iD;
		this.book = book;
		this.availability = true;
		this.numberOfDays = numberOfDays;
	}
	private int numberOfDays;
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	private int ID;
	private Book book;
	private boolean availability;
}
