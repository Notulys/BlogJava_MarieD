package Post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {

	private static MySQLManager instance = null;

	private Connection connection = null;
	private String url = "jdbc:mysql://localhost:3306/blog_java?serverTimezone=Europe/Paris";
	private String utilisateur = "root";
	private String motDePasse = "";

	public static synchronized MySQLManager getInstance() {
		if (instance == null) {
			instance = new MySQLManager();
		}
		return instance;
	}

	private MySQLManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, utilisateur, motDePasse);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	

	protected void finalize() throws Throwable {

		super.finalize();
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {

			}
		}
	}
	
	
	public Connection getConnection() {
		return connection;
	}
}
