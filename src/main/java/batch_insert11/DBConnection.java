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
			LogManager.getLogger().warn("Eksik sýnýf bulunmakta !!!");
		}
		
		try 
		{
			connection = DriverManager.getConnection(url,kul,pas);
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Baðlantý Hatasý !!!\n"+e);
		}
		
		LogManager.getLogger().info("Baðlantý Baþarýlý.");
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
			LogManager.getLogger().warn("Baðlantý Güvenli bir þekilde kapatýlamadý !!!\n"+e);
		}
		LogManager.getLogger().info("Baðlantý Güvenli Kapatýldý.");
	}
}
