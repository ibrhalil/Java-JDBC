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
			logger.warn("Ba�lant� hatas�.");
		}
		
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1,101);
			preparedStatement.setString(2, "Halil");
			preparedStatement.setString(3, "Ayd�n");
			
			preparedStatement.executeUpdate();
			//veri ekleme i�lemleri i�in executeUpdate() metodu kullanmaktay�z.
			
			logger.info("veri ba�ar�l� bir �ekilde eklendi.");
		} 
		catch (SQLException e) 
		{
			logger.warn("Veri ekleme s�ras�nda hata meydana geldi.");
		}
		
		try 
		{
			preparedStatement.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			logger.warn("Ba�lant� kapama hatas�");
		}
		
		
	}

}
