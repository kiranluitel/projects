package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import object.Address;

public class AddressDatabase {
	private String queryInsert = "INSERT INTO Address VALUES (0,?,?,?,?)";
	private String queryUpdate = "UPDATE Address set street = ?, state = ?, zip = ?, city =? where idAddress = ?;";
	private static final Logger LOG = Logger.getLogger(AddressDatabase.class.getName());
	
	private List<Address> populateAddressList(ResultSet rs) throws SQLException {
		List<Address> list = new ArrayList<>();
		String street = null;
		String city = null;
		String state = null;
		String zip = null;
		while(rs.next()) {
			street = rs.getString("street").trim();
			city = rs.getString("city").trim();
			state = rs.getString("state").trim();
			zip = rs.getString("zip").trim();
			list.add(new Address(street, state, zip, city));
		}
		return list;
	}
	
	public int insertAddress(Address address) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, address.getStreet());
			stat.setString(2, address.getState());
			stat.setString(3, address.getZip());
			stat.setString(4, address.getCity());
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
			return key;
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
	
	public void updateAddress(Address address) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryUpdate);
			stat.setString(1, address.getStreet());
			stat.setString(2, address.getState());
			stat.setString(3, address.getZip());
			stat.setString(4, address.getCity());
			stat.setInt(5, address.getID());
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
	
	
}