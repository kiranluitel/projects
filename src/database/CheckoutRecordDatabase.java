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

import object.BookCopy;
import object.Checkout;
import object.CheckoutRecord;
import object.Member;


public class CheckoutRecordDatabase {
	private String queryInsert = "INSERT INTO Author Values(0,?,?,?);";
	private String query = "SELECT * FROM checkout_record cr, checkout c, bookcopy bc, checkout_bookcopy_connection cbc where idMember = ? and c.idCheckoutRecord = cr.idCheckoutRecord and bc.idBookCopy = cbc.idBookCopy and cbc.idCheckout = c.idCheckout;";
	private String queryUpdate = "Update author set shortBio = ?, credentials = ? where idAuthor = ?;";
	private String queryBookCopies = "SELECT * FROM bookcopy bc, checkout_bookcopy_connection bcc where bcc.idBookCopy = bc.idBookCopy AND bcc.idCheckout = ?;";
	private static final Logger LOG = Logger.getLogger(CheckoutRecordDatabase.class.getName());
	
	
	
	public CheckoutRecord getCheckoutRecordByMemberID(Member member) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setInt(1,member.getIdMember());
			ResultSet rs = stat.executeQuery();
			if(!rs.next()) return null;
			rs.beforeFirst();
			CheckoutRecord cr = new CheckoutRecord();
			cr.setCheckouts(populateCheckoutList(rs));
			return cr;
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
		LocalDate checkoutDate = null;
		String bookName = null;
		int bookDate = 0;
		int id = 0;
		while(rs.next()) {
			checkoutDate = LocalDate.parse(rs.getString("checkoutDate").trim());
			bookName = rs.getString("bookName").trim();
			id = rs.getInt("idCheckout");
			bookDate = rs.getInt("bookDate");
			Checkout c = new Checkout( checkoutDate, getBookCopies(id), null,bookName);
			c.setDueDate(LocalDate.now().plusDays(bookDate));
			list.add(c);
		}
		return list;
	}
	private List<BookCopy> getBookCopies(int id) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(queryBookCopies);
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();
			if(!rs.next()) return null;
			rs.beforeFirst();
			return populateBookCopiesList(rs);
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
	private List<BookCopy> populateBookCopiesList(ResultSet rs) throws SQLException {
		List<BookCopy> list = new ArrayList<>();
		int checkoutDate = 0;
		int id = 0;
		while(rs.next()) {
			checkoutDate = rs.getInt("bookDate");
			id = rs.getInt("idBookCopy");
			list.add(new BookCopy( id,null,checkoutDate));
		}
		return list;
	}
	
	
	
}
