package statement04;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class AppTest {

	public static void main(String[] args) {

		Logger LOGGER = (Logger) LogManager.getLogger();
		
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		try 
		{
			statement = connection.createStatement();
		} 
		catch (SQLException e) 
		{
			LOGGER.warn("Statement Oluþturulurken hata oluþtu : "+e);
		}
		
		
		String sorgu = "CREATE TABLE personel ("
					   +"personelId INT PRIMARY KEY NOT NULL,"
					   +"ad VARCHAR(50),"
					   +"soyad VARCHAR(50)"+")";
		
		
		try 
		{
			statement.execute(sorgu);
			LOGGER.info("Sorgu iþleme baþarýlý.");
			
			statement.close();
			LOGGER.info("statement kapatýldý.");
			
			DBConnection.closeConnection(connection);
		} 
		catch (SQLException e) 
		{
			LOGGER.warn("Sorgu iþlenirken hata oluþtu : "+e);
		}
		
		
		

	}

}
