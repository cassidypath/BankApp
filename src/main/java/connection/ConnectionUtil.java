package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() {
		try {
			String url = "jdbc:postgresql://localhost:5432/bankapp";
			String username = "bankapp";
			String password = "wannatreat18";
			
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

}
	
}
