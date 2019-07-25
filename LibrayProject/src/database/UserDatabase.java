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
import object.Person;
import object.User;

public class UserDatabase {
	private String queryInsert = "INSERT INTO User Values(0,?,?);";
	private String query = "SELECT * FROM USER u, address a , Person p WHERE idPerson = ? AND p.idPerson = u.idPerson AND a.idAddress = p.idAddress;";
	private String queryPass = "SELECT * FROM USER u, address a , Person p WHERE p.idPerson = ? AND p.idPerson = u.idPerson AND a.idAddress = p.idAddress AND u.password = ?;";
	private String queryUpdate = "Update user set password = ? where idUser = ?;";
	private static final Logger LOG = Logger.getLogger(PersonDatabase.class.getName());
	
	
	
	public int insertUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, user.getPassword());
			stat.setString(2, user.getID());
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



	public User getUserByIDAndPass(String id, String password) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(queryPass);
			stat.setString(1, id);
			stat.setString(2, password);
			ResultSet rs = stat.executeQuery();
			if(!rs.next()) return null;
			rs.beforeFirst();
			return populateUserList(rs).get(0);
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
	public User getUserByID(String id) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();
			if(!rs.next()) return null;
			rs.beforeFirst();
			return populateUserList(rs).get(0);
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
	private List<User> populateUserList(ResultSet rs) throws SQLException {
		List<User> list = new ArrayList<>();
		String id = null;
		String street = null;
		String city = null;
		String state = null;
		String zip = null;
		String firstName = null;
		String lastName = null;
		String phoneNumber = null;
		while(rs.next()) {
			id = rs.getString("idPerson").trim();
			street = rs.getString("street").trim();
			city = rs.getString("city").trim();
			state = rs.getString("state").trim();
			zip = rs.getString("zip").trim();
			firstName = rs.getString("firstName").trim();
			lastName = rs.getString("lastName").trim();
			phoneNumber = rs.getString("phoneNumber").trim();
			list.add(new User(new Address(street,state,zip,city), firstName, lastName, id, phoneNumber));
		}
		return list;
	}

	public void updateUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryUpdate);
			stat.setString(1, user.getPassword());
			stat.setInt(2, user.getId());
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