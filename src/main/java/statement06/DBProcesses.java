package statement06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class DBProcesses 
{
	private final Logger logger = (Logger) LogManager.getLogger();
	
	DBConnection con = new DBConnection();
	
	Connection connection = con.getConnection();
	
	PreparedStatement preparedStatement = null;
	
	public void createTable() 
	{
		String yeniTabloSqlSorgusu = "Create table sehirler(sehirID int primary key not null,sehir_adi varchar(70))";
		
		try 
		{
			preparedStatement = connection.prepareStatement(yeniTabloSqlSorgusu);
			preparedStatement.execute();
			
			/*
			 * preparedStatement �nce sorguyu sonra al�yor sonra i�leme sokuyor.
			 * 
			 *** eski hali
			 * statement = connection.createStatement();
			 * statement.execute(sorgu);
			 */
		} 
		catch (SQLException e) 
		{
			logger.warn("Sorgu i�leme s�ras�nda bir hata olu�tu.\n"+e);
		}
		logger.info("Tablo olu�turuldu.");
		con.closeConnection(connection, preparedStatement);
		
	}
}
