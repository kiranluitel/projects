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

import object.Author;
import object.Book;
import object.BookCopy;

public class BookCopyDatabase {
	private String queryInsert = "call bookCopyLoop(?,?,?);";
	private String query = "SELECT * FROM bookcopy bc, book b where b.idBook = ? AND bc.availabilty = 1;";
	private static final Logger LOG = Logger.getLogger(BookCopyDatabase.class.getName());

	public void insertBookCopy(BookCopy bookCopy, int numberOfCopies) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			// indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert);
			stat.setInt(1, bookCopy.getBook().getId());
			stat.setInt(2, numberOfCopies);
			stat.setInt(3, bookCopy.getNumberOfDays());
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

	public BookCopy getByBook(Book b) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setInt(1, b.getId());
			ResultSet rs = stat.executeQuery();
			if(!rs.next()) return null;
			return populateBookCopyList(rs).get(0);
		} catch(SQLException e) {
			//log exception
			LOG.warning("SQLException thrown:\n" + e.getMessage());
			throw e;
		} finally {
			//close connection
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					LOG.warning("SQLException thrown when trying to close Connection:\n" + e.getMessage());
				}
			}
		}
	}
	
	private List<BookCopy> populateBookCopyList(ResultSet rs) throws SQLException {
		List<BookCopy> list = new ArrayList<>();
		int bookDate = 0;
		int id = 0;
		while(rs.next()) {
			bookDate = rs.getInt("bookDate");
			id = rs.getInt("idBookCopy");
			list.add(new BookCopy(id,null,bookDate));
		}
		return list;
	}
}
