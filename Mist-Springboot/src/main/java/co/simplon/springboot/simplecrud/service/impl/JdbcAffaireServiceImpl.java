package co.simplon.springboot.simplecrud.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import co.simplon.springboot.simplecrud.model.Affaire;
import co.simplon.springboot.simplecrud.service.AffaireService;

/**
 * JDBC implementation of the Affaire DAO interface.
 */
@Service
public class JdbcAffaireServiceImpl implements AffaireService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private DataSource datasource;

	/**
	 * Constructor
	 * 
	 * @param jdbcTemplate
	 *            : the JDBCTemplace connected to the Database (thanks to Spring)
	 */
	@Autowired
	public JdbcAffaireServiceImpl(JdbcTemplate jdbcTemplate) {
		this.datasource = jdbcTemplate.getDataSource();
	}

	/**
	 * Get the list of all the affaires.
	 * 
	 * @return : the list of all the affaires.
	 */
	@Override
	public List<Affaire> getAllAffaires() {
		Affaire affaire;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		ArrayList<Affaire> aLlistOfAffaire = new ArrayList<>();

		try {
			// Prepare the SQL query
			sql = "SELECT * FROM affaire ";
			pstmt = datasource.getConnection().prepareStatement(sql);

			// Run the query
			rs = pstmt.executeQuery();

			// Handle the query results
			while (rs.next()) {
				affaire = getAffaireFromResultSet(rs);
				aLlistOfAffaire.add(affaire);
			}

		} catch (Exception e) {

			log.error("SQL Error !:", e);

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				log.error("SQL Error !:" + pstmt.toString(), e);
			}
		}

		return aLlistOfAffaire;
	}

	/**
	 * Get a specific affaire based on ID
	 * 
	 * @param id
	 *            : the id of affaire.
	 * @return Affaire : the affaire object (or null)
	 */
	@Override
	public Affaire getAffaire(Long id) {
		PreparedStatement pstmt = null;
		ResultSet rs;
		Affaire affaire = null;

		try {
			// Prepare the SQL query
			String sql = "SELECT * FROM affaire WHERE id = ?";
			pstmt = datasource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);

			// Run the query
			rs = pstmt.executeQuery();

			// Handle the query results
			if (rs.next())
				affaire = getAffaireFromResultSet(rs);
		} catch (SQLException e) {
			log.error("SQL Error !:", e);
		} finally {
			try {
				if(pstmt != null)
				pstmt.close();
			} catch (SQLException e) {
				//Nothing to do
			}
		}
		return affaire;
	}

	/**
	 * create a new affaire.
	 * 
	 * @param affaire
	 *            : the affaire information.
	 */
	@Override
	public Affaire addAffaire(Affaire affaire) {
		PreparedStatement pstmt = null;
		Affaire result = null;
		int i = 0;

		// force auto incremente en initialisant à 0, sinon erreur sql si id
		// existant
		affaire.setId(0);

		try {
			// Prepare the SQL query
			String sql = "INSERT INTO affaire (id_agent, titre, date_ouverture, status, date_cloture) VALUES (?,?,?,?,?)";
			pstmt = datasource.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			//pstmt.setLong(++i, affaire.getId());
			pstmt.setLong(++i, affaire.getIdAgent());
			pstmt.setString(++i, affaire.getTitre());
			pstmt.setString(++i, affaire.getDateOuverture());
			pstmt.setString(++i, affaire.getStatus());
			pstmt.setString(++i, affaire.getDateCloture());
			

			// Run the the update query
			pstmt.executeUpdate();

			// recupération de l'id genere, et maj de l'acteur avec l'id et la date de modif
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				affaire.setId(rs.getLong(1));

				result = affaire;
			}
		} catch (SQLException e) {
			log.error("SQL Error !:", e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				//Nothing to do
			}
		}

		return result;

	}

	/**
	 * Update an existing affaire.
	 * 
	 * @param affaire
	 *            : the affaire information.
	 */
	@Override
	public Affaire saveAffaire(Affaire affaire) {
		Affaire result = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {
			// Prepare the SQL query
			String sql = "UPDATE affaire SET id_agent = ?, titre = ?, date_ouverture = ?,"
					+ " status = ?, date_cloture = ? WHERE id = ?";
			pstmt = datasource.getConnection().prepareStatement(sql);
			pstmt.setLong(++i, affaire.getIdAgent());
			pstmt.setString(++i, affaire.getTitre());
			pstmt.setString(++i, affaire.getDateOuverture());
			pstmt.setString(++i, affaire.getStatus());
			pstmt.setString(++i, affaire.getDateCloture());
			pstmt.setLong(++i, affaire.getId());

			// Run the the update query
			int resultCount = pstmt.executeUpdate();
			if (resultCount != 1)

				log.error("Affaire not found !");

			result = affaire;

		} catch (SQLException e) {
			log.error("SQL Error !:", e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// nothing to do
			}
		}

		return result;
	}

	/**
	 * Delete an existing affaire.
	 * 
	 * @param id
	 *            : the id of affaire.
	 */
	@Override
	public void deleteAffaire(Affaire affaire) {
		PreparedStatement pstmt = null;

		try {
			// Prepare the SQL query
			String sql = "DELETE FROM affaire WHERE id = ?";
			pstmt = datasource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, affaire.getId());

			// Run the the update query
			int result = pstmt.executeUpdate();
			if (result != 1)
				log.info("Affaire not Found", pstmt.toString());

			log.info("Result : ", result);
		} catch (SQLException e) {
			log.error("SQL Error !:", e);

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// nothing to do
			}
		}

	}

	/**
	 * Build an affaire object with data from the ResultSet
	 * 
	 * @param rs
	 *            : the ResultSet to process.
	 * @return Affaire : The new Affaire object
	 */
	private Affaire getAffaireFromResultSet(ResultSet rs) throws SQLException {
		Affaire affaire = new Affaire();
		affaire.setId(rs.getLong("id"));
		affaire.setIdAgent(rs.getLong("id_agent"));
		affaire.setTitre(rs.getString("titre"));
		affaire.setDateOuverture(rs.getString("date_ouverture"));
		affaire.setStatus(rs.getString("status"));
		//affaire.setDateCloture(rs.getString("date_cloture"));
	

		return affaire;
	}


}