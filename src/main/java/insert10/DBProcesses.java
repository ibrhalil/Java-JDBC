package insert10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DBProcesses 
{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	public void personelEkle(Personel personel) {

		connection = DBConnection.getConnection();
		
		String sorgu = "insert into personel(personelId, ad, soyad) values(?, ?, ?)";
		
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, personel.getPersonelId());
			preparedStatement.setString(2, personel.getAd());
			preparedStatement.setString(3, personel.getSoyad());
			
			preparedStatement.executeUpdate();
			
			LogManager.getLogger().info("Ekleme Baþarýlý");
		} 
		catch (SQLException e) {
			LogManager.getLogger().warn("Ekleme Baþarýsýz oldu !!");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		

	}
	
}
