package CustomerJSP.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private static String url = "jdbc:mysql://localhost:3306/customer";
	private static String username = "root";
	private static String password = "1234";
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if(connection != null)
			return connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username , password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Cannot find MySQL Driver!");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot connect to Database!");
		}
		
		return connection;
	}
}
