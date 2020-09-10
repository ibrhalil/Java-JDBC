package insert08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class App {

	public static void main(String[] args) {

		personelEkle(1, "Halil", "Aydýn");
		personelEkle(2, "Ýbrahim", "AY");
		personelEkle(3, "Halil Can", "Deniz");
		/*
		 * her ekleme iþeleminde performans sorunu çekmekteyiz;
		 * her iþlem için aðlantý açýp kapamada.
		 */
		
	}
	
	private static void personelEkle(int id, String ad, String soyad) {

		DBConnection con = new DBConnection();
		Connection connection = con.getConnection();
		PreparedStatement preparedStatement = null;
		
		String sorgu = "insert into personel(personelId, ad, soyad) values(?,?,?)";
		
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, ad);
			preparedStatement.setString(3, soyad);
			
			preparedStatement.executeUpdate();
			
			LogManager.getLogger().info("Ekleme baþarýlý");
			
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Veri ekleme sýrasýnda hata meydana geldi.\n"+e);
		}
		finally {
			con.closeConnection(connection, preparedStatement);
		}
		
		

	}

}
