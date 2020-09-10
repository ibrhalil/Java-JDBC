package insert10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DBConnection 
{
	private static Connection connection = null;
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";		//hatýrlatma ?serverTimezone=UTC -> türkiye zaman hatasý için çözüm
		String kullanici = "root";
		String parola = "toor";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			LogManager.getLogger().warn("Eksik sýnýf ulunmakta!!");
		}
		
		try 
		{
			connection = DriverManager.getConnection(url,kullanici,parola);
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Baðlantý sorunu.\n"+e);
		}
		LogManager.getLogger().info("BAðlantý Baþarýlý.");
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
			LogManager.getLogger().warn("BAðlantý kapatma baþarýsýz!!");
		}
		LogManager.getLogger().info("BAðlantý Güvenli Kapatýldý.");

	}
	
}
