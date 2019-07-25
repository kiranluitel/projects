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
import object.Administrator;
import object.Librarian;

public class LibrarianDatabase {
	private String queryInsert = "Insert into Librarian Values(0,?);\r\n";
	private String query = "SELECT * FROM librarian l, address a , Person p, User u WHERE p.idPerson = ? AND p.idPerson = u.idPerson AND a.idAddress = p.idAddress AND u.idUser = l.idUser;";
	private String size = "SELECT COUNT(*) as count FROM administrator;";
	private static final Logger LOG = Logger.getLogger(PersonDatabase.class.getName());
	
	
	public int insertLibrarian(Librarian librarian) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			stat.setInt(1, librarian.getId());
			
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
	public Librarian getLibrarianByID(String id) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();
			if(!rs.next()) return null;
			rs.beforeFirst();
			return populateLibrarianList(rs).get(0);
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
	private List<Librarian> populateLibrarianList(ResultSet rs) throws SQLException {
		List<Librarian> list = new ArrayList<>();
		String id = null;
		String street = null;
		String city = null;
		String state = null;
		String zip = null;
		String firstName = null;
		String lastName = null;
		String phoneNumber = null;
		int idUser = 0;
		while(rs.next()) {
			id = rs.getString("idPerson").trim();
			street = rs.getString("street").trim();
			city = rs.getString("city").trim();
			state = rs.getString("state").trim();
			zip = rs.getString("zip").trim();
			firstName = rs.getString("firstName").trim();
			lastName = rs.getString("lastName").trim();
			phoneNumber = rs.getString("phoneNumber").trim();
			idUser = rs.getInt("idUser");
			list.add(new Librarian(new Address(street,state,zip,city), firstName, lastName, id, phoneNumber, idUser));
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