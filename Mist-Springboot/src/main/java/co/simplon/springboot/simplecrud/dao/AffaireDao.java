package co.simplon.springboot.simplecrud.dao;

import java.util.List;

import co.simplon.springboot.simplecrud.model.Affaire;

public interface AffaireDao {

	List<Affaire> getAllAffaires();

	Affaire getAffaire(Long id);

	Affaire addAffaire(Affaire affaire);

	Affaire saveAffaire(Affaire affaire);

	void deleteAffaire(Affaire affaire);

	boolean checkDuplicateAffaire(Affaire affaire);

}
