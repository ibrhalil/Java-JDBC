package batch_insert11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;

public class DBProcesses 
{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	public void personellerEkle(List<Personel> listePersonel) {

		connection = DBConnection.getConnection();
		
		String sorgu = "insert into personel(personelId, ad, soyad) values(?,?,?)";
		
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);//for içine alma !
			for (Personel personel : listePersonel) 
			{
				
				preparedStatement.setInt(1, personel.getPersonelId());
				preparedStatement.setString(2, personel.getAd());
				preparedStatement.setString(3, personel.getSoyad());
				
				preparedStatement.addBatch();
			}
			
			preparedStatement.executeBatch();	//liste seklinde eklemede executeBatch() metodu kullanýlýr
			
			LogManager.getLogger().info("Liste Baþarýlý bir þekilde eklendi.");
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Personel listesi eklenireken hata meyadana geldi !!!\n"+e);
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
	}
}
