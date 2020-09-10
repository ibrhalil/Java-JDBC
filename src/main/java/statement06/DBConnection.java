package statement06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class DBConnection 
{
	private Connection connection = null;
	private final Logger LOGGER = (Logger) LogManager.getLogger();
	
	public Connection getConnection() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC","root","toor");
		} 
		catch (SQLException e) 
		{

			LOGGER.warn("Veritabanan� ba�lant� ger�ekle�tirilemedi.\n"+e);
		} 
		catch (ClassNotFoundException e) 
		{
			LOGGER.warn("Gerekli s�n�flar bulunamad�.\n"+e);
		}
		LOGGER.info("Ba�lant� Ba�ar�l�.");
		return connection;
	}
	
	public void closeConnection(Connection connection,PreparedStatement preparedStatement) 
	{
		/*statement s�n�f�da baz� g�venlik a��klar� nedeniyle 
		daha g�venilir bir s�n�f kullanmaktay�z.*/
		
		if (preparedStatement!=null) 
		{
			try 
			{
				preparedStatement.close();
			} 
			catch (SQLException e) 
			{
				LOGGER.warn("statement hatas�. "+e);
			}
		}
		
		if (connection!=null) {
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				LOGGER.warn("connection hatas�. "+e);
			}
		}
		LOGGER.info("G�venli Kapat�ld�.");
	}
}
