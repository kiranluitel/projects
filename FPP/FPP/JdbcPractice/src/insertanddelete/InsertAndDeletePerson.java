package insertanddelete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import read.ConnectManager;

public class InsertAndDeletePerson {
	private static String insert = "INSERT INTO PERSON (firstname, lastname, ssn) "
			+ "VALUES (?, ?, ?)";
	private static String delete = "DELETE FROM PERSON WHERE ssn = ?";
	private static final Logger LOG = Logger.getLogger(InsertAndDeletePerson.class.getName());
	
	public static void insertNewPerson(String fName, String lName, String ssn) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(insert);
			stat.setString(1, fName);
			stat.setString(2, lName);
			stat.setString(3, ssn);
			stat.executeUpdate();
			stat.close();
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
	
	public static void deletePerson(String ssn) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(delete);
			stat.setString(1, ssn);
			stat.executeUpdate();
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
	
	
	
	public static void insertPersonPlusPrimaryKey(String fName, String lName, String ssn) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, fName);
			stat.setString(2, lName);
			stat.setString(3, ssn);
			stat.executeUpdate();
			//after write is performed successfully, read primary key from result set
			int key = -1;
			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getInt(1);
				LOG.info("Generated key for auto_increment id column after insert: "
						+ key);
			} else {
				LOG.info("No generated key for " + stat.toString());
			}
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
	
	
}
