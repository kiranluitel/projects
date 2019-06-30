package insertanddelete;

import java.sql.SQLException;
import read.*;

public class Main {

	public static void main(String[] args) {
		try {
//			System.out.println((new ReadPerson()).getPersonList());
//			System.out.println("+++++++++++++++++++++++++++");
//			System.out.println((new ReadPerson()).getPerson("John"));
//			System.out.println("+++++++++++++++++++++++++++");//			
//			
			System.out.println("+++++++++++++++++++++++++++");
			insertPerson("Tony", "Thomas", "213334764");
			System.out.println((new ReadPerson()).getPersonList());
//			System.out.println("+++++++++++++++++++++++++++");
//			System.out.println("Deleting person with ssn 5251233412");
//			deletePerson("213334764");
//			System.out.println("+++++++++++++++++++++++++++");
//			System.out.println((new ReadPerson()).getPersonList());
			
//			System.out.println("+++++++++++++++++++++++++++");
//			insertPersonPlus("Primary", "Key", "000031111");
//			System.out.println((new ReadPerson()).getPersonList());
//			System.out.println("+++++++++++++++++++++++++++");
		} catch(SQLException e) {
			System.out.println("Exception! " + e.getMessage());
		}
	}
	
	private static void insertPerson(String firstName, String lastName, String ssn) throws SQLException {
		InsertAndDeletePerson.insertNewPerson(firstName, lastName, ssn);
		
	}
	private static void deletePerson(String ssn) throws SQLException {	
		InsertAndDeletePerson.deletePerson(ssn);
	}
	private static void insertPersonPlus(String firstName, String lastName, String ssn) throws SQLException {
		InsertAndDeletePerson.insertPersonPlusPrimaryKey(firstName, lastName, ssn);
		
	}
}
