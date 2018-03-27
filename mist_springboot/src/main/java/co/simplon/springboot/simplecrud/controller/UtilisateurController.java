package co.simplon.springboot.simplecrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import co.simplon.springboot.simplecrud.model.Utilisateur;
import co.simplon.springboot.simplecrud.repository.UtilisateurRepository;

@RestController
@RequestMapping("/api")
public class UtilisateurController {
	@Autowired
	UtilisateurRepository repository;
	
	@CrossOrigin
	@GetMapping("/utilisateur")
	List<Utilisateur> getAllUtilisateur(){
		return repository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/utilisateur/{id}")
	ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable(value="id") long id) {
	    Utilisateur utilisateur = repository.findOne(id);
	    if(utilisateur == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(utilisateur);
	}
	
	@CrossOrigin
	@PostMapping("/utilisateur")
	Utilisateur addUtilisateur(@Valid @RequestBody Utilisateur utilisateur){
		return repository.save(utilisateur);
	}
	
	@CrossOrigin
	@PutMapping("/utilisateur/{id}")
	ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value="id") long id, @Valid @RequestBody Utilisateur utilisateur){
		Utilisateur utilisateurToUpdate = repository.findOne(id);
		if(utilisateurToUpdate == null)
			return ResponseEntity.notFound().build();
		
		// Update the mandatory attributes
//		utilisateurToUpdate.setPrenom(utilisateur.getPrenom());
//		utilisateurToUpdate.setNom(utilisateur.getNom());
		utilisateurToUpdate.setProfil(utilisateur.getProfil());
		
		// Update all other not null attributes
		
//		if(utilisateur.getEmail() != null)
//			utilisateurToUpdate.setEmail(utilisateur.getEmail());
		
		Utilisateur updatedutilisateur = repository.save(utilisateurToUpdate);
		return ResponseEntity.ok(updatedutilisateur);
	}
	
	@CrossOrigin
	@DeleteMapping("/utilisateur/{id}")
	ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable(value="id") long id){
		Utilisateur utilisateur = repository.findOne(id);
		if(utilisateur == null)
			return ResponseEntity.notFound().build();
		
		repository.delete(utilisateur);
		return ResponseEntity.ok().build();
	}
}
