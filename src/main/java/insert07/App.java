package insert07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class App {

	public static void main(String[] args) {

		Logger logger = (Logger) LogManager.getLogger();
		
		String sorgu = "INSERT INTO personel(personelId, ad, soyad) values(?, ?, ?)";
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC","root","toor");
		} 
		catch (SQLException e) 
		{
			logger.warn("Baðlantý hatasý.");
		}
		
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1,101);
			preparedStatement.setString(2, "Halil");
			preparedStatement.setString(3, "Aydýn");
			
			preparedStatement.executeUpdate();
			//veri ekleme iþlemleri için executeUpdate() metodu kullanmaktayýz.
			
			logger.info("veri baþarýlý bir þekilde eklendi.");
		} 
		catch (SQLException e) 
		{
			logger.warn("Veri ekleme sýrasýnda hata meydana geldi.");
		}
		
		try 
		{
			preparedStatement.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			logger.warn("Baþlantý kapama hatasý");
		}
		
		
	}

}
