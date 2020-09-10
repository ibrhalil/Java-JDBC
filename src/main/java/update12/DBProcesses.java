package update12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DBProcesses 
{
	private Connection connection = null;
	
	public Personel personelGuncelle(Personel personel) 
	{
		String sorgu = "UPDATE personel SET ad = ?, soyad = ? WHERE personelId = ?";
		
		connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);
			/*
			 * sorgu c�mlesinde ki soru i�aretleri (?) s�ras�na g�re index verilecek
			 */
			preparedStatement.setString(1, personel.getAd());
			preparedStatement.setString(2, personel.getSoyad());
			preparedStatement.setInt(3, personel.getPersonelId());
			
			preparedStatement.executeUpdate();
			
			LogManager.getLogger().info("Personel G�ncellendi.");
			
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Veri G�ncelleme s�ras�nda hata meydana geldi !!!");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		

		return personel;
	}
}
