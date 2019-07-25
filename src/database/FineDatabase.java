package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Logger;

import object.BookCopy;
import object.Checkout;

public class FineDatabase {
	private String queryInsert = "insert into fine values(0,CURDATE(),?);";
	private String queryUpdateCheckout = "Update checkout set idFine = ? where idCheckout = ?";
	private static final Logger LOG = Logger.getLogger(FineDatabase.class.getName());

	public void createFine(Checkout ch) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			// indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			if (ch.getDueDate().compareTo(LocalDate.now()) < 0)
				stat.setDouble(1, 100);
			else
				stat.setDouble(1, 0);
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
			
			stat = conn.prepareStatement(queryUpdateCheckout);
			stat.setInt(1, key);
			stat.setInt(2, ch.getId());
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
