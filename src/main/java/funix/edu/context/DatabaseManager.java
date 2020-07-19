package funix.edu.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=Assignment3;"
			+ "TrustServerCertificate=false;" + "integratedSecurity=false";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "Hoangtien018";
	public static Connection connection;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		getConnection();
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("connected!");
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
