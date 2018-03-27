package co.simplon.springboot.simplecrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/mist?useSSL=false";
	private static final String IDENTIFIANT = "root";
	private static final String MOTDEPASSE = "admin";

	public static DaoFactory getInstance() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return new DaoFactory();
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, IDENTIFIANT, MOTDEPASSE);
	}
}
