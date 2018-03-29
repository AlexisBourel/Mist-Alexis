package co.simplon.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.springboot.model.Affaire;
import co.simplon.springboot.service.AffaireService;

/**
 * The AffaireController defines all the rest api for handling affaires.
 */
@RestController
@RequestMapping("/api")
public class AffaireController {

	@Autowired
	private AffaireService affaireService;
	
	/**
	 * Get all the affaires.
	 * @return a list with all the affaires
	 * @throws Exception 
	 */
	@RequestMapping(value = "/affaires", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAffaires(){
		List<Affaire> listAffaire = null;
		try {
			listAffaire = affaireService.getAllAffaires();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listAffaire);
	}
	
	/**
	 * Get a specific affaire based on ID
	 * @param id : the id of affaire.
	 * @return the affaire
	 * @throws Exception 
	 */
	@RequestMapping(value = "/affaire/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAffaire(@PathVariable Long id){
		Affaire affaire = null;
				
		try {
			affaire =affaireService.getAffaire(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		if(affaire == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		return ResponseEntity.status(HttpStatus.OK).body(affaire);
	}
	
	/**
	 * Create a new affaire.
	 * @param affaire : the affaire information.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/affaire", method = RequestMethod.POST)
	public ResponseEntity<?> addAffaire(@RequestBody Affaire affaire){
		Affaire resultAffaire = null;
		
		Long agentResponsable = affaire.getAgentResponsable();
		if(agentResponsable < 1) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'id de l'Agent Responsable de l'affaire n'est pas renseigné");
		
		String titre = affaire.getTitre();
		if((titre == null) || (titre.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Donnez un titre à l'affaire");
		
		String dateOuverture = affaire.getDateOuverture();
		if((dateOuverture == null) || (dateOuverture.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merci de renseigner la date d'ouverture de l'affaire");
		
		String status = affaire.getStatus();
		if((status == null) || (status.isEmpty()))
			affaire.setStatus("Ouverte");
		
		String description = affaire.getDescription();
		if((description == null) || (description.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merci de renseigner la descrpition de l'affaire");
		
		try {
			resultAffaire = affaireService.addAffaire(affaire);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resultAffaire);
	}
	
	/**
	 * Update an existing affaire.
	 * @param affaire : the affaire information.
	 * @param id : the id of affaire.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/affaire/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAffaire(@RequestBody Affaire affaire,@PathVariable Long id) throws Exception {
		Affaire result = null;
		
		Long agentResponsable = affaire.getAgentResponsable();
		if(agentResponsable < 1) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'id de l'Agent Responsable de l'affaire n'est pas renseigné");
		
		String titre = affaire.getTitre();
		if((titre == null) || (titre.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Donnez un titre à l'affaire");
		
		String dateOuverture = affaire.getDateOuverture();
		if((dateOuverture == null) || (dateOuverture.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merci de renseigner la date d'ouverture de l'affaire");
		
		String status = affaire.getStatus();
		if((status == null) || (status.isEmpty()))
			affaire.setStatus("Ouverte");
		
		String description = affaire.getDescription();
		if((description == null) || (description.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merci de renseigner la descrpition de l'affaire");
		
		try {
			result = affaireService.updateAffaire(id, affaire);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	/**
	 * Delete an existing affaire.
	 * @param id : the id of affaire.
	 * @throws Exception
	 */
	@RequestMapping(value = "/affaire/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAffaire(@PathVariable Long id){
		try {
		affaireService.deleteAffaire(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}