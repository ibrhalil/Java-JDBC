package statement05;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

public class App {

	public static void main(String[] args) {

		Connection connection = DBConnection.getConnection();
		Statement statement = DBConnection.getStatement();
		
		String sorgu ="Create table kisiler(kisiId int primary key not null,ad varchar(45), soyad varchar(40))";

		try 
		{
			statement.execute(sorgu);
			LogManager.getLogger().info("sorgu Ba�ar�l� :D");
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("sorgu s�ras�nda hata olu�tu.");
		}
		finally 
		{
			DBConnection.closeConnection(connection, statement);
		}
		
	}

}
