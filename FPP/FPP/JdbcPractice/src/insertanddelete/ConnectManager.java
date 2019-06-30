package insertanddelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectManager {	
	private static final String DB_URL = "jdbc:mysql:/localhost:3306/FppDb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "kiranluitel";
	public static Connection getConnection() throws SQLException {	
		Connection conn = DriverManager.getConnection(DB_URL, USERNAME,
				PASSWORD);
		System.out.println("Got connection...");
		return conn;
	}
}


