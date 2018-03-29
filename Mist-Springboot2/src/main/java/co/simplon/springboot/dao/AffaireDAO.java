package co.simplon.springboot.dao;

import java.util.List;

import co.simplon.springboot.model.Affaire;

/**
 * DAO interface for the affaire model.
 */
public interface AffaireDAO {

	public List<Affaire> listAffaires() throws Exception;

	public Affaire getAffaire(Long id) throws Exception;

	public Affaire insertAffaire(Affaire affaire) throws Exception;

	public Affaire updateAffaire(Affaire affaire) throws Exception;
	
	public void deleteAffaire(Long id) throws Exception;

}