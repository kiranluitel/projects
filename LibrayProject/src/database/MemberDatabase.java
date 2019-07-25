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
import object.CheckoutRecord;
import object.Librarian;
import object.Member;
import object.User;

public class MemberDatabase {
	private String queryInsert = "INSERT INTO Member Values(0,?);\r\n";
			
	private String queryInsertCheckoutRecord = "INSERT INTO Checkout_Record Values(0,?);";
	private String query = "SELECT * FROM Member m, address a , Person p, Checkout_Record rc WHERE p.idPerson = ? AND p.idPerson = m.idPerson AND a.idAddress = p.idAddress and rc.idMember = m.idMember;";
	private String size = "SELECT COUNT(*) as count FROM administrator;";
	private static final Logger LOG = Logger.getLogger(PersonDatabase.class.getName());
	
	
	public int insertMember(Member member) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			//indicate intention to read auto-generated id column here
			PreparedStatement stat = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, member.getID());
			
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
			stat = conn.prepareStatement(queryInsertCheckoutRecord);
			stat.setInt(1, key);
			stat.executeUpdate();
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


	public Member getMemberByID(String id) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();
			if(!rs.next()) return null;
			rs.beforeFirst();
			return populateMemberList(rs).get(0);
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
	private List<Member> populateMemberList(ResultSet rs) throws SQLException {
		List<Member> list = new ArrayList<>();
		String id = null;
		String street = null;
		String city = null;
		String state = null;
		String zip = null;
		String firstName = null;
		String lastName = null;
		String phoneNumber = null;
		int idCheckoutRecord = 0;
		int idMember = 0;
		while(rs.next()) {
			id = rs.getString("idPerson").trim();
			street = rs.getString("street").trim();
			city = rs.getString("city").trim();
			state = rs.getString("state").trim();
			zip = rs.getString("zip").trim();
			firstName = rs.getString("firstName").trim();
			lastName = rs.getString("lastName").trim();
			phoneNumber = rs.getString("phoneNumber").trim();
			idMember = rs.getInt("idMember");
			idCheckoutRecord = rs.getInt("idCheckoutRecord");
			Member m =new Member(new Address(street,state,zip,city), firstName, lastName, id, phoneNumber,idMember);
			m.setCheckoutRecord(new CheckoutRecord(idCheckoutRecord));
			list.add(m);
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
