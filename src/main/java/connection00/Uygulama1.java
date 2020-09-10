package connection00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Uygulama1 {

	public static void main(String[] args) {
		
		Logger logger = (Logger) LogManager.getLogger();
		Connection connection = null;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			logger.warn("mysql Dirver bulunamadı.\n"+e);
			return;
		}
		
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC","root","toor");
			logger.info("Bağlantı Başarılı.");
		} 
		catch (SQLException e) {
			
			logger.warn("VeriTabanı bağlantısında Hata !\n"+e);
		}
		
		if (connection!=null) {
			
			System.out.println("kod çalıştı");
		}

	}

}
