package search14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DBProcesses 
{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private Personel personel = new Personel();
	
	public Personel personelBul(int personelId) {

		connection = DBConnection.getConnection();
		String sorgu = "SELECT * FROM personel WHERE personelId = ?";
		
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, personelId);
			
			resultSet = preparedStatement.executeQuery();	//sonuc tipinden veriyi �ekeriz
			
			while (resultSet.next()) 
			{
				personel.setPersonelId(resultSet.getInt(1));	//1. kolondaki int de�eri al
				personel.setAd(resultSet.getString(2));
				personel.setSoyad(resultSet.getString("soyad"));	//illaki colon indis yerine ad�n�da yazabiliriz.
			}
			
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Silme i�lemi s�ras�nda hata meydana geldi.");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement,resultSet);
		}
		return personel;
		

	}
}
