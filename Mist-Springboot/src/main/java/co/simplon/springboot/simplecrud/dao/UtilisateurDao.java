package co.simplon.springboot.simplecrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.simplon.springboot.simplecrud.model.Profil;
import co.simplon.springboot.simplecrud.model.Utilisateur;

public class UtilisateurDao extends DAO<Utilisateur> {
	
	Connection connection;

	public UtilisateurDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur find(long id){
		/**
		 * Méthode de recherche des informations
		 * 
		 * @param id
		 * @return Utilisateur
		 **/
		Utilisateur utilisateur = new Utilisateur();
		ResultSet result = null;
		Statement statement = null;
		
		loadDatabase();
		
		String requete = "SELECT * FROM utilisateur WHERE id = " + id;
		try {
			statement = connection.createStatement();
			
			//Exécution de la requête
			result = statement.executeQuery(requete);
			if(result.first())
				utilisateur = new Utilisateur(
						id, 
						result.getString("nom"),
						result.getString("prenom"),
						result.getString("email"),
						result.getString("motdepasse"),
						(Profil) result.getObject("profil"));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            // Fermeture de la connexion
            try {
            	connection.close();
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();                    
            } catch (SQLException ignore) {
            }
        }
		
		return utilisateur;
		}
	
	private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mist?useSSL=false", "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
