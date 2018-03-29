package co.simplon.springboot.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.simplon.springboot.model.Affaire;

/**
 * JDBC implementation of the Affaire DAO interface.
 */
//@Component
@Repository
public class JdbcAffaireDAO implements AffaireDAO {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private DataSource datasource;

	/**
	 * Constructor
	 * @param jdbcTemplate : the JDBCTemplace connected to the Database (thanks to Spring)
	 */
	@Autowired
	public JdbcAffaireDAO(JdbcTemplate jdbcTemplate) {
		this.datasource = jdbcTemplate.getDataSource();
	}

	/**
	 * Get the list of all the affaires.
	 * @return : the list of all the affaires.
	 */
	@Override
	public List<Affaire> listAffaires() throws Exception {
		Affaire affaire;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		ArrayList<Affaire> aLlistOfAffaire = new ArrayList<Affaire>();

		try {
			// Prepare the SQL query
			sql = "SELECT * FROM affaire ";
			pstmt = datasource.getConnection().prepareStatement(sql);
			
			// Log info
			logSQL(pstmt);

			// Run the query
			rs = pstmt.executeQuery();

			// Handle the query results
			while (rs.next()) {
				affaire = getAffaireFromResultSet(rs);
				aLlistOfAffaire.add(affaire);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}

		return aLlistOfAffaire;
	}

	/**
	 * Get a specific affaire based on ID
	 * @param id : the id of affaire.
	 * @return Affaire : the affaire object (or null)
	 */
	@Override
	public Affaire getAffaire(Long id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs;
		Affaire affaire = null;

		try {
			// Prepare the SQL query
			String sql = "SELECT * FROM affaire WHERE id = ?";
			pstmt = datasource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);

			// Log info
			logSQL(pstmt);

			// Run the query
			rs = pstmt.executeQuery();
			
			// Handle the query results
			if (rs.next())
				affaire = getAffaireFromResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}
		return affaire;
	}

	/**
	 * create a new affaire.
	 * @param affaire : the affaire information.
	 */
	@Override
	public Affaire insertAffaire(Affaire affaire) throws Exception {
		PreparedStatement pstmt = null;
		Affaire result = null;
		int i = 0;
		Timestamp updateTime = new Timestamp(System.currentTimeMillis());
		
		// TODO
		// force auto incremente en initialisant à 0, sinon erreur sql si id
		// existant
		affaire.setId(new Long(0));

		try {
			// Prepare the SQL query
			String sql = "INSERT INTO affaire (id_agent, titre, date_ouverture, status, date_cloture, description, last_update) VALUES (?,?,?,?,?,?,?)";
			pstmt = datasource.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			//pstmt.setLong(++i, affaire.getId());
			pstmt.setLong(++i, affaire.getAgentResponsable());
			pstmt.setString(++i, affaire.getTitre());
			pstmt.setString(++i, affaire.getDateOuverture());
			pstmt.setString(++i, affaire.getStatus());
			pstmt.setString(++i, affaire.getDateCloture());
			pstmt.setString(++i, affaire.getDescription());
			pstmt.setTimestamp(++i, updateTime);
			
			// Log info
			logSQL(pstmt);
			
			// Run the the update query
			pstmt.executeUpdate();

			// TODO 
			// recupération de l'id genere, et maj de l'acteur avec l'id et la date de modif
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				affaire.setId(rs.getLong(1));
				affaire.setLastUpdate(updateTime);
				
				result = affaire;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}
		
		return result;

	}

	/**
	 * Update an existing affaire.
	 * @param affaire : the affaire information.
	 */
	@Override
	public Affaire updateAffaire(Affaire affaire) throws Exception {
		Affaire result = null;
		PreparedStatement pstmt = null;
		int i = 0;
		Timestamp updateTime = new Timestamp(System.currentTimeMillis());
				
		try {
			// Prepare the SQL query
			String sql = "UPDATE affaire SET id_agent = ?, titre = ?, date_ouverture = ?,"
					+ " status = ?, date_cloture = ?, description = ?, last_update = ? WHERE id = ?";
			pstmt = datasource.getConnection().prepareStatement(sql);
			pstmt.setLong(++i, affaire.getAgentResponsable());
			pstmt.setString(++i, affaire.getTitre());
			pstmt.setString(++i, affaire.getDateOuverture());
			pstmt.setString(++i, affaire.getStatus());
			pstmt.setString(++i, affaire.getDateCloture());
			pstmt.setString(++i, affaire.getDescription());
			pstmt.setTimestamp(++i, updateTime);
			pstmt.setLong(++i, affaire.getId());
			
			// Log info
			logSQL(pstmt);
			
			// Run the the update query
			int resultCount = pstmt.executeUpdate();
			if(resultCount != 1)
				throw new Exception("Affaire not found !");
			
			affaire.setLastUpdate(updateTime);
			result = affaire;

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}

		return result;
	}

	/**
	 * Delete an existing affaire.
	 * @param id : the id of affaire.
	 */
	@Override
	public void deleteAffaire(Long id) throws Exception {
		PreparedStatement pstmt = null;
		
		try {
			// Prepare the SQL query
			String sql = "DELETE FROM affaire WHERE id = ?";
			pstmt = datasource.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			
			// Log info
			logSQL(pstmt);
			
			// Run the the update query
			int result = pstmt.executeUpdate();
			if(result != 1)
				throw new Exception("Affaire not found !");
			
			System.out.println("Result : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}

	}

	/**
	 * Build an affaire object with data from the ResultSet
	 * @param rs : the ResultSet to process.
	 * @return Affaire : The new Affaire object
	 */
	private Affaire getAffaireFromResultSet(ResultSet rs) throws SQLException {
		Affaire affaire = new Affaire();
		affaire.setId(rs.getLong("id"));
		affaire.setAgentResponsable(rs.getLong("id_agent"));
		affaire.setTitre(rs.getString("titre"));
		affaire.setDateOuverture(rs.getString("date_ouverture"));
		affaire.setStatus(rs.getString("status"));
		affaire.setDateCloture(rs.getString("date_cloture"));
		affaire.setDescription(rs.getString("description"));
		affaire.setLastUpdate(rs.getTimestamp("last_update"));
		
		return affaire;
	}

	/**
	 * Debug function used to log information on the database requests
	 * @param pstmt : The PreparedStatement.
	 */
	private void logSQL(PreparedStatement pstmt) {
		String sql;
		
		if (pstmt == null)
			return;
		
		sql = pstmt.toString().substring(pstmt.toString().indexOf(":") + 2);
		log.debug(sql);
	}
}