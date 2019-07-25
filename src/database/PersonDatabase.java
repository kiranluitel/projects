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



public class PersonDatabase {

	private String queryInsert = "INSERT INTO Person Values (0,?, ?, ?,?);";
	private String queryUpdate = "UPDATE person SET firstName = ?, lastName = ?, phoneNumber = ? where idPerson = ?;";
	private static final Logger LOG = Logger.getLogger(PersonDatabase.class.getName());
	
	
	private List<Person> populatePersonList(ResultSet rs) throws SQLException {
		List<Person> list = new ArrayList<>();
		String id = null;
		String firstName = null;
		String lastName = null;
		String phone = null;
		String street = null;
		String city = null;
		String state = null;
		String zip = null;
		
		while(rs.next()) {
			id = rs.getString("p.id").trim();
			firstName = rs.getString("p.firstname").trim();
			lastName = rs.getString("p.lastname").trim();
			phone = rs.getString("p.phoneNumber").trim();
			street = rs.getString("a.street").trim();
			city = rs.getString("a.city").trim();
			state = rs.getString("a.state").trim();			
			zip = rs.getString("a.zip").trim();

			Address addr = new Address(street,state,zip,city);
			list.add(new Person(addr,firstName, lastName, id, phone));
		}
		return list;
	}
	
	public int insertPerson(Person person) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, person.getFirstName());
			stat.setString(2, person.getLastName());
			stat.setInt(3, person.getAddress().getID());
			stat.setString(4, person.getPhoneNumber());
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
	
	public void updatePerson(Person person) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryUpdate);
			stat.setString(1, person.getFirstName());
			stat.setString(2, person.getLastName());
			stat.setString(3, person.getPhoneNumber());
			stat.setString(4, person.getID());
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