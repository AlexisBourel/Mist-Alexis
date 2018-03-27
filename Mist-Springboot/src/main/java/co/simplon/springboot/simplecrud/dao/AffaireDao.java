package co.simplon.springboot.simplecrud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import co.simplon.springboot.simplecrud.model.Affaire;
import co.simplon.springboot.simplecrud.dao.DaoFactory;

public class AffaireDao implements DAO<Affaire> {

	DaoFactory factory;
	Connection connection;
	Affaire affaire;
	ResultSet result = null;
	String requete;
	Statement statement;
	@Override
	public Affaire findOne(long id) throws SQLException, ClassNotFoundException {
		factory = new DaoFactory();
		connection = factory.getConnection();
		requete = "SELECT * FROM affaire WHERE id = " + id;
		statement = connection.createStatement();
		// Exécution de la requête
		result = statement.executeQuery(requete);
		result.next();
		// instanciation d'un objet Affaire avec le resultat de la requete
		affaire = new Affaire();
		affaire.setAgentResponsable(result.getInt("id_agent"));
		affaire.setTitre(result.getString("titre"));
		affaire.setDateOuverture(result.getString("date_ouverture"));
		affaire.setDateCloture(result.getString("date_cloture"));
		affaire.setStatus(result.getString("status"));
		affaire.setDescription(result.getString("Description"));

		// Fermeture de la connexion
		connection.close();
		result.close();
		statement.close();

		return affaire;
	}

	public Affaire create(Affaire affaire) throws SQLException, ClassNotFoundException {
		factory = new DaoFactory();
		connection = factory.getConnection();
		requete = "SELECT * FROM affaire";
		statement = connection.createStatement();
		// Exécution de la requête
		result = statement.executeQuery(requete);
		return affaire;

	}

	public Affaire delete(Affaire affaire) {
		return affaire;
	}

	public Affaire update(Affaire affaire) {
		return affaire;
	}

	public List<Affaire> findAll() {
		return null;
	}

}
