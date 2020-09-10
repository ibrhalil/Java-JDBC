package batch_insert11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DBConnection 
{
	private static Connection connection = null;
	
	public static Connection getConnection() 
	{
		String url="jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC",kul="root",pas="toor";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			LogManager.getLogger().warn("Eksik s�n�f bulunmakta !!!");
		}
		
		try 
		{
			connection = DriverManager.getConnection(url,kul,pas);
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Ba�lant� Hatas� !!!\n"+e);
		}
		
		LogManager.getLogger().info("Ba�lant� Ba�ar�l�.");
		return connection;
	}
	
	public static void closeConnection(Connection connection, PreparedStatement preparedStatement) 
	{
		try 
		{
			preparedStatement.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Ba�lant� G�venli bir �ekilde kapat�lamad� !!!\n"+e);
		}
		LogManager.getLogger().info("Ba�lant� G�venli Kapat�ld�.");
	}
}
