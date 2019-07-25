package database;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import collections.AdministratorCollection;
import collections.AuthorCollection;
import collections.BookCollection;
import collections.LibrarianCollection;
import collections.MemberCollection;
import object.*;

public class db {
	private static db instance;
	private AddressDatabase adb;
	private PersonDatabase pdb;
	private UserDatabase udb;
	private LibrarianDatabase ldb;
	private AdministratorDatabase addb;
	private MemberDatabase mdb;
	private AuthorDatabase audb;
	private BookDatabase bdb;
	private BookCopyDatabase bcdb;
	private CheckoutDatabase cdb;
	private CheckoutRecordDatabase crdb;
	private FineDatabase fdb;

	public static db getInstance() {
		if (instance == null)
			instance = new db();
		return instance;
	}

	private db() {
		adb = new AddressDatabase();
		pdb = new PersonDatabase();
		udb = new UserDatabase();
		ldb = new LibrarianDatabase();
		addb = new AdministratorDatabase();
		mdb = new MemberDatabase();
		audb = new AuthorDatabase();
		bdb = new BookDatabase();
		bcdb = new BookCopyDatabase();
		cdb = new CheckoutDatabase();
		crdb = new CheckoutRecordDatabase();
		fdb = new FineDatabase();
	}

	public User getUserByIDAndPass(String id, String password) throws Exception {
		User u = udb.getUserByIDAndPass(id, password);
		if (u == null) {
			throw new Exception("User not found.");
		}
		u = ldb.getLibrarianByID(id);
		if (u == null)
			u = addb.getAdministratorByID(id);
		else {
			User u2 = addb.getAdministratorByID(id);
			if (u2 != null)
				u = new Both(u.getAddress(), u.getFirstName(), u.getLastName(), u.getPhoneNumber(), u.getPassword());
		}
		return u;
	}

	public Member getMemberByID(String id) throws Exception {
		return mdb.getMemberByID(id);
	}

	public CheckoutRecord getRecord(Member member) throws Exception {
		Member m = searchMember(member);
		member.setIdMember(m.getIdMember());
		return crdb.getCheckoutRecordByMemberID(member);
	}

	public void createNewCheckout(Book b, Member member) throws Exception {
		BookCopy bc = bcdb.getByBook(b);
		cdb.insertCheckout(b, bc, member);
	}

	public Member addMember(Member member) throws Exception {
		member.getAddress().setID(adb.insertAddress(member.getAddress()));
		member.setID("" + pdb.insertPerson(member));
		member.setIdMember(mdb.insertMember(member));
		return member;
	}

	public Book addBook(Book book) throws Exception {
		for (Author au : book.getAuthors()) {
			au.setIdAuthor(addAuthor(au).getIdAuthor());
		}
		bdb.insertBook(book);
		return book;
	}

	public void addCopies(BookCopy bookCopy, int numberOfCopies) throws Exception {
		bcdb.insertBookCopy(bookCopy, numberOfCopies);
	}

	private Member searchMember(Member member) throws SQLException {

		return mdb.getMemberByID(member.getID());
	}

	private Administrator searchAdministrator(Administrator administrator) throws SQLException {
		return addb.getAdministratorByID(administrator.getID());

	}

	public Book getBookByIsbn(String text) throws SQLException {
		return searchBook(text);
	}

	private Book searchBook(String text) throws SQLException {
		return bdb.getByIsbn(new Book(text, null, null, null));
	}

	public int getNumberBooks() throws SQLException {
		return bdb.size();
	}

	public int getNumberAdministrator() throws SQLException {
		return addb.size();
	}

	public int getNumberLibrarians() throws SQLException {
		return ldb.size();
	}

	public int getNumberMembers() throws SQLException {
		return mdb.size();
	}

	public void updateMember(Member member) throws Exception {
		Member a = mdb.getMemberByID(member.getID());
		if (a == null)
			throw new Exception("Administrator not Found");
		member.getAddress().setID(a.getAddress().getID());
		adb.updateAddress(member.getAddress());
		pdb.updatePerson(member);
	}

	public Librarian addLibrarian(Librarian librarian) throws Exception {

		librarian.getAddress().setID(adb.insertAddress(librarian.getAddress()));
		librarian.setID("" + pdb.insertPerson(librarian));
		librarian.setUserID(udb.insertUser(librarian));
		ldb.insertLibrarian(librarian);
		return librarian;
	}

	private Librarian searchLibrarian(Librarian librarian) throws SQLException {
		return ldb.getLibrarianByID(librarian.getID());
	}

	public Librarian getLibrarianByID(String text) throws SQLException {
		return searchLibrarian(new Librarian(null, null, null, text, null));
	}

	public void updateLibrarian(Librarian librarian) throws Exception {
		Librarian a = ldb.getLibrarianByID(librarian.getID());
		if (a == null)
			throw new Exception("Administrator not Found");
		librarian.getAddress().setID(a.getAddress().getID());
		adb.updateAddress(librarian.getAddress());
		pdb.updatePerson(librarian);
	}

	public Administrator addAdministrator(Administrator administrator) throws Exception {
		administrator.getAddress().setID(adb.insertAddress(administrator.getAddress()));
		administrator.setID("" + pdb.insertPerson(administrator));
		administrator.setUserID(udb.insertUser(administrator));
		addb.insertAdministrator(administrator);
		return administrator;
	}

	public Administrator getAdministratorByID(String text) throws SQLException {
		return searchAdministrator(new Administrator(null, null, null, text, null));
	}

	public void updateAdministrator(Administrator administrator) throws Exception {
		Administrator a = addb.getAdministratorByID(administrator.getID());
		if (a == null)
			throw new Exception("Administrator not Found");
		administrator.getAddress().setID(a.getAddress().getID());
		administrator.setUserID(a.getId());
		if (administrator.getPassword().equals(""))
			administrator.setPassword(a.getPassword());
		adb.updateAddress(administrator.getAddress());
		pdb.updatePerson(administrator);
		udb.updateUser(administrator);
	}

	public void updateBook(Book book) throws Exception {
		Book b = bdb.getByIsbn(book);
		if (b == null)
			throw new Exception("Book not found.");
		bdb.updateBook(book);
	}

	public void updateAuthor(Author author) throws Exception {
		Author a = audb.getAuthorByID(author.getID());
		if (a == null)
			throw new Exception("Administrator not Found");
		author.getAddress().setID(a.getAddress().getID());
		adb.updateAddress(author.getAddress());
		pdb.updatePerson(author);
	}

	private Author searchAuthor(Author author) throws SQLException {
		return audb.getAuthorByID(author.getID());
	}

	public Author getAuthorByID(String text) throws SQLException {
		return searchAuthor(new Author(null, null, null, text, null, null, null));
	}

	public Author addAuthor(Author author) throws Exception {
		author.getAddress().setID(adb.insertAddress(author.getAddress()));
		author.setID("" + pdb.insertPerson(author));
		audb.insertAuthor(author);
		return author;
	}

	public Checkout getCheckoutByIsbn(String isbn, int idMember) throws Exception {
		Checkout ch = cdb.getCheckoutByIsbnAndMember(isbn, idMember);
		if(ch == null)
			throw new Exception("That book is not checked out for this member.");
		if (ch.getFine() != null)
			throw new Exception("Book already returned.");
		fdb.createFine(ch);
		return ch;
	}
}
