package search14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DBConnection 
{
	private static Connection connection = null;

	public static Connection getConnection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			LogManager.getLogger().warn("Eksik Class bulunmakta !!!");
		}
		
		String url="jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
		String kul="root";
		String pas="toor";
		
		try 
		{
			connection = DriverManager.getConnection(url,kul,pas);
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Baðlanýrken HAta meydana geldi !!!");
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection, PreparedStatement preparedStatement,ResultSet resultSet)
	{
		try 
		{
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} 
		catch (SQLException e) {
			LogManager.getLogger().warn("Güvenli kapatýlamadý !!!");
		}
		
	}
}
