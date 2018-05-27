package co.simplon.springboot.simplecrud.service.impl;

import java.sql.Date;
import java.time.LocalDate;
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

	public Affaire mockAffaires(String titre, String description, Long idAgent, Date date, String status) {
		Affaire affaire = new Affaire();
		affaire.setTitre(titre);
		affaire.setDescription(description);
		affaire.setIdAgent(idAgent);
		affaire.setDateOuverture(date);
		affaire.setStatus(status);
		return affaire;
	}

	@Override
	public List<Affaire> getAllAffaires() {
		return dao.getAllAffaires();
	}
	
	@Override
	public List<Affaire> getAllAffairesJoin() {
		return dao.getAllAffairesJoin();
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

	@Override
	public boolean checkDuplicateAffaire(Affaire affaire) {
		return dao.checkDuplicateAffaire(affaire);
	}

	@Override
	public void populateDbWithMockedAffaire() {
		dao.addAffaire(mockAffaires("Affaire Test", "affaire crée pour les tests", 1L, Date.valueOf(LocalDate.now()),
				"Close"));
		dao.addAffaire(mockAffaires("Affaire Brierre ", "assassinat de cinq enfants", 2L, Date.valueOf("1901-04-22"),
				"Close"));
		dao.addAffaire(
				mockAffaires("Affaire Calers", "Assassinat d'Éric Calers", 3L, Date.valueOf("2001-11-02"), "Ouverte"));
		dao.addAffaire(mockAffaires("Affaire Sagno", "Meurtre et viol de Marie-Agnès Bedot",
				4L, Date.valueOf("2002-05-22"), "Close"));
		dao.addAffaire(mockAffaires("Affaire Kusama", "Assassinat de Mika Kusama 29 ans japonaise", 1L,
				Date.valueOf("2002-05-02"), "Ouverte"));
		dao.addAffaire(mockAffaires("Affaire Mouzin", "Enlèvement d'Estelle Mouzinà Guermantes.", 2L,
				Date.valueOf("2003-01-09"), "Ouverte"));
		dao.addAffaire(mockAffaires("Affaire Flactif", "Assassinats de Xavier Flactif", 3L, Date.valueOf("2003-04-11"),
				"Ouverte"));
		dao.addAffaire(mockAffaires("Affaire des bébés de Galfingue",
				"Découverte des corps de quatre bébés en forêt de Galfingue", 4L, Date.valueOf("2003-10-21"),
				"Ouverte"));

	}

}