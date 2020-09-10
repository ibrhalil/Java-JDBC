package statement05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class DBConnection {

	private static Connection connection = null;
	private static final Logger LOGGER = (Logger) LogManager.getLogger();
	private static Statement statement = null;
	
	public static Connection getConnection() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC","root","toor");
		} 
		catch (ClassNotFoundException e) 
		{
			LOGGER.warn("jdbc Driver bulunamad�. "+e);
		} 
		catch (SQLException e) 
		{
			LOGGER.warn("ba�lant� s�ras�nda bir hata olu�tu. "+e);
		}
		
		LOGGER.info("Ba�lant� ba�ar�l�.");
		return connection;
	}
	
	public static Statement getStatement() {
		
		try 
		{
			statement = connection.createStatement();
		} 
		catch (SQLException e) 
		{
			LOGGER.warn("statement olu�turulurken bir hata olu�tu. "+e);
		}
		
		return statement;
	}
	
	public static void closeConnection(Connection connection,Statement statement) 
	{
		if (statement!=null) 
		{
			try 
			{
				statement.close();
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
	}
}
