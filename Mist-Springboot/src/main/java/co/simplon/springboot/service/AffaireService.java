package co.simplon.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.springboot.dao.AffaireDAO;
import co.simplon.springboot.model.Affaire;

@Service
public class AffaireService {
	
	@Autowired
	private AffaireDAO dao;
	
	// Retrieve all rows from table and populate list with objects
	public List<Affaire> getAllAffaires() throws Exception {
		return dao.listAffaires();
	}
	
	// Retrieves one row from table based on given id
	public Affaire getAffaire(Long id) throws Exception {
		return dao.getAffaire(id);
	}
	
	// Inserts row into table 
	public Affaire addAffaire(Affaire affaire) throws Exception {
		return dao.insertAffaire(affaire);
	}
	
	// Updates row in table
	public Affaire updateAffaire(Long id, Affaire affaire) throws Exception {
		return dao.updateAffaire(affaire);
	}
	
	// Removes row from table
	public void deleteAffaire(Long id) throws Exception {
		dao.deleteAffaire(id);
	}
}