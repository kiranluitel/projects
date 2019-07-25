package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import object.Book;
import object.BookCopy;
import object.Checkout;
import object.Fine;
import object.Member;

public class CheckoutDatabase {
	private String queryInsert = "insert into checkout VALUES (0,?,DATE_ADD(CURDATE(), INTERVAL ? DAY),CURDATE(),null,?);";
	private String queryInsertCon = "INSERT INTO checkout_bookcopy_connection VALUES(0,?,?);";
	private String query = "select * from checkout c inner join checkout_bookcopy_connection cbc on cbc.idCheckout = c.idCheckout inner join bookcopy bc on bc.idBookCopy = cbc.idBookCopy inner join book b on b.idBook = bc.idBook LEFT JOIN  Fine f on c.idFine = f.idFine inner join Checkout_record cr on cr.idCheckoutRecord = c.idCheckoutRecord inner join Member m on m.idMember = cr.idMember  where b.isbn = ? and M.idMember = ? ;";
	private String updateBookCopy = "Update bookcopy set availabilty = 0 where idBookCopy = ?";
	private static final Logger LOG = Logger.getLogger(CheckoutDatabase.class.getName());

	public int insertCheckout(Book b, BookCopy bookcopy, Member member) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			// indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, b.getTitle());
			stat.setInt(2, bookcopy.getNumberOfDays());
			stat.setInt(3, member.getCheckoutRecord().getId());
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

			stat = conn.prepareStatement(queryInsertCon);
			stat.setInt(1, bookcopy.getID());
			stat.setInt(2, key);
			stat.executeUpdate();
			
			updateBookCopy(bookcopy);

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
	
	private void updateBookCopy(BookCopy bc) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			// indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(updateBookCopy);
			stat.setInt(1, bc.getID());
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

	public Checkout getCheckoutByIsbnAndMember(String isbn,int idMember) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setString(1, isbn);
			stat.setInt(2, idMember);
			ResultSet rs = stat.executeQuery();
			if(!rs.next()) return null;
			rs.beforeFirst();
			return populateCheckoutList(rs).get(0);
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
	
	private List<Checkout> populateCheckoutList(ResultSet rs) throws SQLException {
		List<Checkout> list = new ArrayList<>();
		String checkoutDate = null;
		int id = 0;
		String bookName = null;
		int bookDate = 0;
		double fineValue = 0;
		String returnedDate = null;
		while(rs.next()) {
			checkoutDate = rs.getString("checkoutDate");
			id = rs.getInt("idCheckout");
			bookName = rs.getString("title");
			bookDate = rs.getInt("bookDate");
			fineValue = rs.getDouble("fineValue");
			returnedDate = rs.getString("returnedDate");
			Checkout c = new Checkout(LocalDate.parse(checkoutDate), null,null,bookName,id);
			if(returnedDate != null) {
				c.setFine(new Fine(LocalDate.parse(returnedDate),fineValue));
			}
			c.setDueDate(LocalDate.now().plusDays(bookDate));
			list.add(c);
		}
		return list;
	}
}
