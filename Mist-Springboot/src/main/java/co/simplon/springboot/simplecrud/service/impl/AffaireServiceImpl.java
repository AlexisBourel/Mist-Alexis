package co.simplon.springboot.simplecrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.springboot.simplecrud.dao.AffaireDao;
import co.simplon.springboot.simplecrud.model.Affaire;
import co.simplon.springboot.simplecrud.service.AffaireService;

/**
 * JDBC implementation of the Affaire DAO interface.
 */
@Service
public class AffaireServiceImpl implements AffaireService {

	@Autowired
	AffaireDao dao;
	
	public void mockAffaires(String titre, String description, Long idAgent) {
		Affaire affaire = new Affaire();
		affaire.setTitre(titre);
		affaire.setDescription(description);
		affaire.setIdAgent(idAgent);
	}

	@Override
	public List<Affaire> getAllAffaires() {
		return dao.getAllAffaires();
	}

	@Override
	public void deleteAffaire(Affaire affaire) {
		dao.deleteAffaire(affaire);
		
	}

	@Override
	public Affaire getAffaire(Long id) {
		return dao.getAffaire(id);
	}

	@Override
	public Affaire addAffaire(Affaire affaire) {
		return dao.addAffaire(affaire);
	}

	@Override
	public Affaire saveAffaire(Affaire affaire) {
		return dao.saveAffaire(affaire);
	}

}