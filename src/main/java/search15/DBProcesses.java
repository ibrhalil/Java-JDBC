package search15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

public class DBProcesses 
{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private List<Personel> personels = new ArrayList<>();
	
	public List<Personel> personelListesi() {

		connection = DBConnection.getConnection();
		String sorgu = "SELECT * FROM personel";
		
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) 
			{
				Personel personel = new Personel();
				personel.setPersonelId(resultSet.getInt(1));	
				personel.setAd(resultSet.getString("ad"));
				personel.setSoyad(resultSet.getString("soyad"));
				
				personels.add(personel);
			}
			
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Silme iþlemi sýrasýnda hata meydana geldi.");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement,resultSet);
		}
		return personels;
		

	}
}
