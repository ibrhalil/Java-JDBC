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

			LOGGER.warn("Veritabananý baðlantý gerçekleþtirilemedi.\n"+e);
		} 
		catch (ClassNotFoundException e) 
		{
			LOGGER.warn("Gerekli sýnýflar bulunamadý.\n"+e);
		}
		LOGGER.info("Baðlantý Baþarýlý.");
		return connection;
	}
	
	public void closeConnection(Connection connection,PreparedStatement preparedStatement) 
	{
		/*statement sýnýfýda bazý güvenlik açýklarý nedeniyle 
		daha güvenilir bir sýnýf kullanmaktayýz.*/
		
		if (preparedStatement!=null) 
		{
			try 
			{
				preparedStatement.close();
			} 
			catch (SQLException e) 
			{
				LOGGER.warn("statement hatasý. "+e);
			}
		}
		
		if (connection!=null) {
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				LOGGER.warn("connection hatasý. "+e);
			}
		}
		LOGGER.info("Güvenli Kapatýldý.");
	}
}
