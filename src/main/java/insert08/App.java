package insert08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class App {

	public static void main(String[] args) {

		personelEkle(1, "Halil", "Ayd�n");
		personelEkle(2, "�brahim", "AY");
		personelEkle(3, "Halil Can", "Deniz");
		/*
		 * her ekleme i�eleminde performans sorunu �ekmekteyiz;
		 * her i�lem i�in a�lant� a��p kapamada.
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
			
			LogManager.getLogger().info("Ekleme ba�ar�l�");
			
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Veri ekleme s�ras�nda hata meydana geldi.\n"+e);
		}
		finally {
			con.closeConnection(connection, preparedStatement);
		}
		
		

	}

}
