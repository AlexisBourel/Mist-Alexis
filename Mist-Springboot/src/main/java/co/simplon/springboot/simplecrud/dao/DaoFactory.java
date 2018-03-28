package co.simplon.springboot.simplecrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory{

	private static final String URL = "jdbc:mysql://localhost:3306/mist?useSSL=false";
	private static final String IDENTIFIANT = "root";
	private static final String MOTDEPASSE = "admin";
	private Connection connection;

	public DaoFactory() throws SQLException, ClassNotFoundException {
		// Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");
		// creation de la connexion
		connection = DriverManager.getConnection(URL, IDENTIFIANT, MOTDEPASSE);
	}
	
	public Connection getConnection() {
		return connection;
	}

}
