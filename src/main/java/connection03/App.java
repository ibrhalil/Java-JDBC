package connection03;

import java.sql.Connection;

public class App {

	public static void main(String[] args) {

		Connection connection = DBConnection.getConnection();
			//VT i�lemleri
		DBConnection.closeConnection(connection);

	}

}
