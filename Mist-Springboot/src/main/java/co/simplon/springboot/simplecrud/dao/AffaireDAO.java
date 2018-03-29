package co.simplon.springboot.simplecrud.dao;
import java.util.List;

import co.simplon.springboot.simplecrud.model.Affaire;

public interface AffaireDAO {

	public List<Affaire> listAffaires() throws Exception;

	public Affaire getAffaire(Long id) throws Exception;

	public Affaire insertAffaire(Affaire affaire) throws Exception;

	public Affaire updateAffaire(Affaire affaire) throws Exception;
	
	public void deleteAffaire(Long id) throws Exception;

}