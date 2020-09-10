package connection02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDBConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC","root","toor");
		System.out.println("ba�lant� ba�ar�l�");
		return connection;

	}
	
	public static void closeConnection(Connection connection) throws SQLException 
	{
		if (connection!=null) {
			connection.close();
		}
		System.out.println("Ba�lant� kapat�ld�.");
	}

}
