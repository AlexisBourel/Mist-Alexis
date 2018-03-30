package co.simplon.springboot.simplecrud.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import co.simplon.springboot.simplecrud.model.Affaire;
import co.simplon.springboot.simplecrud.service.AffaireService;

public class AffaireServiceImplTest {

		AffaireService service = new AffaireServiceImpl();
		
		
		
		@Test
		public void getAllAffairesTest(){
			assertFalse(service.getAllAffaires().isEmpty());
		}
		
		@Rollback
		public void deleteAffaire(Affaire affaire) {
			affaire = new Affaire();
			affaire.setIdAgent(2);
			affaire.setDateOuverture("01/02/2001");
			affaire.setDescription("Description");
			affaire.setStatus("ouverte");
			affaire.setTitre("titreTest");
			
		}
		
		// sql: "SELECT FROM affaire WHERE id = " + affaire.getId();
		public void getAffaire(Long id) {
			Affaire affaire = new Affaire();
			affaire = service.getAffaire((long) 1);
			assertEquals("Entrée Test", affaire.getTitre());
		}

		// sql: "ALTER TABLE 
		public void addAffaire(Affaire affaire) {
		}
		
		public void saveAffaire(Affaire affaire) {
			
		}
	
}
