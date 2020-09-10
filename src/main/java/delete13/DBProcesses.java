package delete13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DBProcesses 
{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	public void personelSil(int personelId) {

		connection = DBConnection.getConnection();
		String sorgu = "DELETE FROM personel WHERE personelId = ?";
		
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, personelId);
			
			preparedStatement.executeUpdate();
			LogManager.getLogger().info("Silme Baþarýlý.");
			
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Silme iþlemi sýrasýnda hata meydana geldi.");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		
		

	}
}
