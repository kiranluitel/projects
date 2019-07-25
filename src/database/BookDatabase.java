package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import object.Address;
import object.Author;
import object.Book;
import object.BookCopy;
import object.Member;

public class BookDatabase {
	private String queryInsert = "INSERT INTO Book Values(0,?, ?, ?);";
	private String queryInsertAuthorCon = "INSERT INTO author_book_connection Values (0,?, ?);";
	private String queryBookCopy = "INSERT INTO bookcopy VALUES (0,1, ?,?);";
	private String query = "SELECT * FROM BOOK WHERE isbn = ?;";
	private String queryAuthors = "\r\n" + 
			"SELECT * FROM BOOK b inner join author_book_connection bac on bac.idBook = b.idBook inner join author a on a.idAuthor = bac.idAuthor inner join person p on p.idPerson = a.idPerson inner join Address ad on ad.idAddress = p.idAddress where isbn = ?";
	private String size = "SELECT COUNT(*) as count FROM administrator;";
	private String queryUpdate = "update book set isbn = ?, title = ?, shortDescription = ? where idBook = ?;";
	private static final Logger LOG = Logger.getLogger(AddressDatabase.class.getName());

	public int insertBook(Book book) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();

			// indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, book.getISBN());
			stat.setString(2, book.getTitle());
			stat.setString(3, book.getShortDescription());
			stat.executeUpdate();
			// after write is performed successfully, read primary key from result set
			int key = -1;
			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getInt(1);
				LOG.info("Generated key for auto_increment id column after insert: " + key);
			} else {
				LOG.info("No generated key for " + stat.toString());
			}
			for (Author au : book.getAuthors()) {
				AuthorDatabase adb = new AuthorDatabase();
				int id = adb.insertAuthor(au);
				stat = conn.prepareStatement(queryInsertAuthorCon);
				stat.setInt(1, key);
				stat.setInt(2, id);
				stat.executeUpdate();
			}
			if (book.getCopies().size() == 0) {
				stat = conn.prepareStatement(queryBookCopy);
				stat.setInt(1, 7);
				stat.setInt(2, key);
				stat.executeUpdate();
			} else {
				for (BookCopy bc : book.getCopies()) {
					stat = conn.prepareStatement(queryBookCopy);
					stat.setInt(1, bc.getNumberOfDays());
					stat.setInt(2, key);
					stat.executeUpdate();
				}
			}
			return key;
		} catch (SQLException e) {
			// log exception
			LOG.warning("SQLException thrown:\n" + e.getMessage());
			throw e;
		} finally {
			// close connection
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					LOG.warning("SQLException thrown when trying to close Connection:\n" + e.getMessage());
				}
			}
		}
	}

	public Book getByIsbn(Book book) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setString(1, book.getISBN());
			ResultSet rs = stat.executeQuery();
			if (!rs.next())
				return null;
			rs.beforeFirst();
			Book b = populateBookList(rs).get(0);
			stat = conn.prepareStatement(queryAuthors);
			stat.setString(1, book.getISBN());
			rs = stat.executeQuery();
			List<Author> authors = AuthorDatabase.populateAuthorList(rs);
			b.setAuthors(authors);
			return b;
		} catch (SQLException e) {
			// log exception
			LOG.warning("SQLException thrown:\n" + e.getMessage());
			throw e;
		} finally {
			// close connection
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					LOG.warning("SQLException thrown when trying to close Connection:\n" + e.getMessage());
				}
			}
		}
	}

	private List<Book> populateBookList(ResultSet rs) throws SQLException {
		List<Book> list = new ArrayList<>();
		String isbn = null;
		String title = null;
		String shortDescription = null;
		int id = 0;
		while (rs.next()) {
			isbn = rs.getString("isbn").trim();
			title = rs.getString("title").trim();
			shortDescription = rs.getString("shortDescription").trim();
			id = rs.getInt("idBook");
			list.add(new Book(isbn, new LinkedList<Author>(), title, shortDescription, id));
		}
		return list;
	}

	public int size() throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(size);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				long s = rs.getLong("count");
				return (int) s;
			} else
				return 0;
		} catch (SQLException e) {
			// log exception
			LOG.warning("SQLException thrown:\n" + e.getMessage());
			throw e;
		} finally {
			// close connection
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					LOG.warning("SQLException thrown when trying to close Connection:\n" + e.getMessage());
				}
			}
		}
	}

	public void updateBook(Book book) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			// indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryUpdate);
			stat.setString(1, book.getISBN());
			stat.setString(2, book.getTitle());
			stat.setString(3, book.getShortDescription());
			stat.setInt(4, book.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			// log exception
			LOG.warning("SQLException thrown:\n" + e.getMessage());
			throw e;
		} finally {
			// close connection
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					LOG.warning("SQLException thrown when trying to close Connection:\n" + e.getMessage());
				}
			}
		}
	}
}
