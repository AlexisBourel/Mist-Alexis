package co.simplon.springboot.simplecrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.springboot.simplecrud.model.Affaire;
import co.simplon.springboot.simplecrud.service.impl.AffaireServiceImpl;

@RestController
@RequestMapping("/api")
public class AffaireController {
	
	@Autowired
	AffaireServiceImpl affaireService;
	
	@CrossOrigin
	@GetMapping("/affaire")
	ResponseEntity<List<Affaire>> getAllAffaires(){		
		return ResponseEntity.status(HttpStatus.OK).body(affaireService.getAllAffaires());
	}
	
	
	@CrossOrigin
	@GetMapping("/affaire/{id}")
	ResponseEntity<Affaire> getAffaireById(@PathVariable(value="id") long id) {
	    Affaire affaire = affaireService.getAffaire(id);
	    if(affaire == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(affaire);
	}
	
	@CrossOrigin
	@PostMapping("/affaire")
	ResponseEntity<?> addAffaire(@Valid @RequestBody Affaire affaire){
		if (affaireService.checkDuplicateAffaire(affaire)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Doublon détecté, veuillez changer de nom");
		}
		if (affaire.getDateOuverture() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez renseigner la date d'ouverture de l'enquête");
		}
		if (affaire.getTitre() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez renseigner le titre de l'enquête");
		}
		if (affaire.getIdAgent() == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez renseigner le responsable de l'enquête");
		}		
		return ResponseEntity.status(HttpStatus.OK).body(affaireService.addAffaire(affaire));
	}
	
	@CrossOrigin
	@PutMapping("/affaire/{id}")
	ResponseEntity<?> updateAffaire(@PathVariable(value="id") long id, @Valid @RequestBody Affaire affaire){
		Affaire affaireToUpdate = affaireService.getAffaire(id);
		if(affaireToUpdate == null)
			return ResponseEntity.notFound().build();
		
		// Update the mandatory attributes
		affaireToUpdate.setIdAgent(affaire.getIdAgent());
		affaireToUpdate.setTitre(affaire.getTitre());
		affaireToUpdate.setDateOuverture(affaire.getDateOuverture());
		affaireToUpdate.setStatus(affaire.getStatus());
		affaireToUpdate.setDescription(affaire.getDescription());
				
		// Update all other not null attributes
		
		if(affaire.getDateCloture() != null)
			affaireToUpdate.setDateCloture(affaire.getDateCloture());
		
		Affaire updatedaffaire = affaireService.saveAffaire(affaireToUpdate);
		
		return ResponseEntity.ok(updatedaffaire);
	}
	
	@CrossOrigin
	@DeleteMapping("/affaire/{id}")
	ResponseEntity<?> deleteAffaire(@PathVariable(value="id") long id){
		Affaire affaire = affaireService.getAffaire(id);
		if(affaire == null)
			return ResponseEntity.notFound().build();
		
		affaireService.deleteAffaire(affaire);
		return ResponseEntity.ok().build();
	}
}
