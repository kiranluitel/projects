package object;

import java.time.LocalDate;
import java.util.List;

public class Checkout {
	public Checkout(LocalDate checkoutDate, List<BookCopy> checkoutBooks, Fine fine) {
		super();
		this.dueDate = dueDate;
		this.checkoutDate = checkoutDate;
		this.checkoutBooks = checkoutBooks;
		bookName = checkoutBooks.get(0).getBook().getTitle();
		this.fine = fine;
	}
	public Checkout(LocalDate checkoutDate, List<BookCopy> checkoutBooks, Fine fine, String bookName) {
		super();
		this.dueDate = dueDate;
		this.checkoutDate = checkoutDate;
		this.checkoutBooks = checkoutBooks;
		this.bookName = bookName;
		this.fine = fine;
	}
	public Checkout(LocalDate checkoutDate, List<BookCopy> checkoutBooks, Fine fine, String bookName,int id) {
		super();
		this.dueDate = dueDate;
		this.checkoutDate = checkoutDate;
		this.checkoutBooks = checkoutBooks;
		this.bookName = bookName;
		this.fine = fine;
		this.id = id;
	}
	private LocalDate dueDate;
	private LocalDate checkoutDate;
	private List<BookCopy> checkoutBooks;
	public String bookName;
	private Fine fine;
	private int id;
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public List<BookCopy> getCheckoutBooks() {
		return checkoutBooks;
	}
	public void setCheckoutBooks(List<BookCopy> checkoutBooks) {
		this.checkoutBooks = checkoutBooks;
	}
	public Fine getFine() {
		return fine;
	}
	public void setFine(Fine fine) {
		this.fine = fine;
	}
	public int getId() {
		
		return id;
	}
	
	
	
}
