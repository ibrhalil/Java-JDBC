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
			LOGGER.warn("Ba�lant� Ba�ar�s�z..!\n"+e);
		} 
		catch (ClassNotFoundException e) 
		{
			LOGGER.warn("Ba�lant� s�n�f� bulunamad�..!\n"+e);
		}
		LOGGER.info("Ba�lant� Ba�ar�l�.");
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
				LOGGER.warn("Ba�lant� Kapat�lamad�..!\n"+e);
			}
		}
		LOGGER.info("Ba�lant� Kapat�ld�.");
	}
}
