package co.simplon.springboot.simplecrud.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

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

import co.simplon.springboot.simplecrud.dao.AffaireDao;
import co.simplon.springboot.simplecrud.model.Affaire;

@RestController
@RequestMapping("/api")
public class AffaireController {
	
	AffaireDao dao = new AffaireDao();
	
	@CrossOrigin
	@GetMapping("/affaire")
	List<Affaire> getAllAffaire() throws ClassNotFoundException, SQLException{
		return dao.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/affaire/{id}")
	ResponseEntity<Affaire> getAffaireById(@PathVariable(value="id") long id) throws ClassNotFoundException, SQLException {
	    Affaire affaire = dao.findOne(id);
	    if(affaire == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(affaire);
	}
	
	@CrossOrigin
	@PostMapping("/affaire")
	Affaire addAffaire(@Valid @RequestBody Affaire affaire) throws ClassNotFoundException, SQLException{
		return dao.create(affaire);
	}
	
	@CrossOrigin
	@PutMapping("/affaire/{id}")
	ResponseEntity<Affaire> updateAffaire(@PathVariable(value="id") long id, @Valid @RequestBody Affaire affaire) throws ClassNotFoundException, SQLException{
		Affaire affaireToUpdate = dao.findOne(id);
		if(affaireToUpdate == null)
			return ResponseEntity.notFound().build();
		
		// Update the mandatory attributes
		affaireToUpdate.setAgentResponsable(affaire.getAgentResponsable());
		
		// Update all other not null attributes
		
		if(affaire.getDateCloture() != null)
			affaireToUpdate.setDateCloture(affaire.getDateCloture());
		
		Affaire updatedaffaire = dao.update(affaireToUpdate);
		return ResponseEntity.ok(updatedaffaire);
	}
	
	@CrossOrigin
	@DeleteMapping("/affaire/{id}")
	ResponseEntity<Affaire> deleteAffaire(@PathVariable(value="id") long id) throws ClassNotFoundException, SQLException{
		Affaire affaire = dao.findOne(id);
		if(affaire == null)
			return ResponseEntity.notFound().build();
		
		dao.delete(affaire);
		return ResponseEntity.ok().build();
	}
}
