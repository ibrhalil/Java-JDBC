package connection02;

import java.sql.Connection;
import java.sql.SQLException;

public class Uygulama3 {

	public static void main(String[] args) {

		try {
			Connection connection = MysqlDBConnection.getConnection();
			
			MysqlDBConnection.closeConnection(connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
