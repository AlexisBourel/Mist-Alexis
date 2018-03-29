package co.simplon.springboot.simplecrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.springboot.simplecrud.model.Affaire;
import co.simplon.springboot.simplecrud.dao.DaoFactory;

public class AffaireDaoImpl implements AffaireDAO {

	DaoFactory factory;
	Connection connection;
	ResultSet result = null;
	String requete;
	PreparedStatement statement;

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
				+ affaire.getAgentResponsable() + ", " + affaire.getTitre() + ", " + affaire.getDateOuverture() + ", "
				+ affaire.getDateCloture() + ", " + affaire.getStatus() + ", " + affaire.getDescription() + ")";
		statement = connection.prepareStatement(requete);
		// Exécution de la requête
		result = statement.executeQuery(requete);
		// Fermeture de la connexion
		connection.close();
		result.close();
		statement.close();
		return affaire;

	}

	public Affaire delete(Affaire affaire) throws ClassNotFoundException, SQLException {
		factory = new DaoFactory();
		connection = factory.getConnection();
		requete = "DELETE FROM affaire WHERE id = " + affaire.getId();
		statement = connection.prepareStatement(requete);
		statement.executeUpdate();
		// Exécution de la requête
		result = statement.executeQuery(requete);
		// Fermeture de la connexion
		connection.close();
		result.close();
		statement.close();
		return affaire;
	}

	public Affaire update(Affaire affaire) {
		Affaire affaireUpdated = new Affaire();
		
		return affaire;
	}

	@Override
	public List<Affaire> listAffaires() throws Exception {
		List<Affaire> affaires = new ArrayList<>();
		factory = new DaoFactory();
		connection = factory.getConnection();
		requete = "SELECT * FROM affaire";
		statement = connection.prepareStatement(requete);
		// Exécution de la requête
		result = statement.executeQuery(requete);
		while (result.next()) {
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

	@Override
	public Affaire getAffaire(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Affaire insertAffaire(Affaire affaire) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Affaire updateAffaire(Affaire affaire) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAffaire(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
