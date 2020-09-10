package connection03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class DBConnection 
{
	private static final Logger LOGGER = (Logger) LogManager.getLogger();
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC","root","toor");
		} 
		catch (SQLException e) 
		{
			LOGGER.warn("Baðlantý Baþarýsýz..!\n"+e);
		} 
		catch (ClassNotFoundException e) 
		{
			LOGGER.warn("Baðlantý sýnýfý bulunamadý..!\n"+e);
		}
		LOGGER.info("Baðlantý Baþarýlý.");
		return connection;
	}
	
	public static void closeConnection(Connection connection) {

		if (connection!=null) 
		{
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				LOGGER.warn("Baðlantý Kapatýlamadý..!\n"+e);
			}
		}
		LOGGER.info("Baðlantý Kapatýldý.");
	}
}
