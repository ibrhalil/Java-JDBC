package connection01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Uygulama2 {

	private static Connection connection = null;
	private static final Logger logger = (Logger) LogManager.getLogger();
	
	public static void main(String[] args) 
	{
		try 
		{
			baglantiAc();
			logger.info("Ba�lant� Ba�ar�l�.");
			
				//veri taban� ekleme ��karma i�lemleri
			
			baglantiKapa();
		} 
		catch (ClassNotFoundException e) 
		{
			logger.warn("Ba�lant� sa�lay�c� Class bulunamad� !");
			return;
		} 
		catch (SQLException e) 
		{
			logger.warn("Veri Taban� ba�lant� hatas�.\n"+e);
		}
		

	}
	
	private static void baglantiAc() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC","root","toor");
	}
	
	private static void baglantiKapa() throws SQLException {

		if (connection!=null) {
			connection.close();
			connection=null;
			logger.info("Ba�lant� sonland�r�ld�.");
		}

	}

}
