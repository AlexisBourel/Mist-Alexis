package co.simplon.springboot.simplecrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import co.simplon.springboot.simplecrud.model.Affaire;
import co.simplon.springboot.simplecrud.dao.DaoFactory;

public class AffaireDao implements DAO<Affaire> {

	DaoFactory factory;
	Connection connection;
	ResultSet result = null;
	String requete;
	PreparedStatement statement;
	
	@Override
	public Affaire findOne(long id) throws SQLException, ClassNotFoundException {
		factory = new DaoFactory();
		connection = factory.getConnection();
		requete = "SELECT * FROM affaire WHERE id = " + id;
		statement = connection.prepareStatement(requete);
		// Exécution de la requête
		result = statement.executeQuery(requete);
		result.next();
		// instanciation d'un objet Affaire avec le resultat de la requete
		Affaire affaire = new Affaire();
		affaire.setId(result.getInt("id"));
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
		requete = "INSERT INTO affaire (id_agent, titre, date_ouverture, status, description) VALUES (" 
		+ affaire.getAgentResponsable() + ", " + affaire.getTitre() + ", " + affaire.getDateOuverture() + ", " + affaire.getDateCloture()
		+ ", " + affaire.getStatus() + ", " + affaire.getDescription() + ")";
		statement = connection.prepareStatement(requete);
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

	public List<Affaire> findAll() throws ClassNotFoundException, SQLException {
		List<Affaire> affaires = new ArrayList<>();
		factory = new DaoFactory();
		connection = factory.getConnection();
		requete = "SELECT * FROM affaire";
		statement = connection.prepareStatement(requete);
		// Exécution de la requête
		result = statement.executeQuery(requete);
		while(result.next()) {
		// instanciation d'un objet Affaire avec le resultat de la requete
		Affaire affaire = new Affaire();
		affaire.setId(result.getInt("id"));
		affaire.setAgentResponsable(result.getInt("id_agent"));
		affaire.setTitre(result.getString("titre"));
		affaire.setDateOuverture(result.getString("date_ouverture"));
		affaire.setDateCloture(result.getString("date_cloture"));
		affaire.setStatus(result.getString("status"));
		affaire.setDescription(result.getString("Description"));
		affaires.add(affaire);
		}
		// Fermeture de la connexion
		connection.close();
		result.close();
		statement.close();

		return affaires;
	}

}
