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
import object.Author;
import object.Librarian;
import object.User;

public class AuthorDatabase {
	private String queryInsert = "INSERT INTO Author Values(0,?,?,?);";
	private String query = "SELECT * FROM Author au, address a , Person p WHERE p.idPerson = ? AND p.idPerson = au.idPerson AND a.idAddress = p.idAddress";
	private String queryUpdate = "Update author set shortBio = ?, credentials = ? where idAuthor = ?;";
	private static final Logger LOG = Logger.getLogger(AddressDatabase.class.getName());
	
	public int insertAuthor(Author author) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1,author.getShortBio());
			stat.setString(2,author.getCredentials());
			stat.setString(3,author.getID());
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
	
	public Author getAuthorByID(String id) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();
			if(!rs.next()) return null;
			rs.beforeFirst();
			return populateAuthorList(rs).get(0);
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
	public static List<Author> populateAuthorList(ResultSet rs) throws SQLException {
		List<Author> list = new ArrayList<>();
		String id = null;
		String street = null;
		String city = null;
		String state = null;
		String zip = null;
		String firstName = null;
		String lastName = null;
		String phoneNumber = null;
		String shortBio = null;
		String credentials = null;
		while(rs.next()) {
			id = rs.getString("idPerson").trim();
			street = rs.getString("street").trim();
			city = rs.getString("city").trim();
			state = rs.getString("state").trim();
			zip = rs.getString("zip").trim();
			firstName = rs.getString("firstName").trim();
			lastName = rs.getString("lastName").trim();
			phoneNumber = rs.getString("phoneNumber").trim();
			shortBio = rs.getString("shortBio").trim();
			credentials = rs.getString("credentials").trim();
			list.add(new Author(new Address(street,state,zip,city), firstName, lastName, id, phoneNumber,shortBio, credentials));
		}
		return list;
	}
	
	public void updateAuthor(Author author) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryUpdate);
			stat.setString(1, author.getShortBio());
			stat.setString(2, author.getCredentials());
			stat.setInt(3, author.getIdAuthor());
			stat.executeUpdate();
			//after write is performed successfully, read primary key from result set
			int key = -1;
			ResultSet rs = stat.executeQuery();
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
