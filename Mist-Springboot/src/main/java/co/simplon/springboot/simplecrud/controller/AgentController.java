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

import co.simplon.springboot.simplecrud.model.Agent;
import co.simplon.springboot.simplecrud.service.AgentService;

@RestController
@RequestMapping("/api")
public class AgentController {

	@Autowired
	AgentService service;

	@CrossOrigin
	@GetMapping("/agent")
	ResponseEntity<List<Agent>> getAllAgents() {
		List<Agent> agents =  service.getAll();
		if (agents.isEmpty()) {
			service.add(service.mockAgent("BOUREL", "Alexis", "Administrateur"));
			service.add(service.mockAgent("NESIC", "Alexandre", "Scientifique"));
			service.add(service.mockAgent("NOURRY", "Jean-Luc", "Officier"));
			service.add(service.mockAgent("SUZANNE", "Jordan", "Agent"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(agents);
	}

	@CrossOrigin
	@GetMapping("/agent/{id}")
	ResponseEntity<Agent> getAgentById(@PathVariable(value = "id") long id) {
		Agent agent = service.getOneById(id);
		if (agent == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(agent);
	}

	@CrossOrigin
	@PostMapping("/agent")
	ResponseEntity<?> addAgent(@Valid @RequestBody Agent agent) {
		String error = "Champ non renseigné : ";

		if (agent.getEmail() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error + "email");
		}
		if (agent.getNom() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error + "nom");
		}
		if (agent.getPrenom() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error + "prenom");
		}
		if (agent.getMotDePasse() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error + "mot de passe");
		}
		return ResponseEntity.status(HttpStatus.OK).body(service.add(agent));
	}

	@CrossOrigin
	@PutMapping("/agent/{id}")
	ResponseEntity<?> updateAgent(@PathVariable(value = "id") long id, @Valid @RequestBody Agent agentForm) {
		Agent agentToUpdate = service.getOneById(id);
		if (agentToUpdate == null)
			return ResponseEntity.notFound().build();

		// Update the mandatory attributes
		agentToUpdate.setEmail(agentForm.getEmail());
		agentToUpdate.setNom(agentForm.getNom());
		agentToUpdate.setPrenom(agentForm.getPrenom());
		agentToUpdate.setMotDePasse(agentForm.getMotDePasse());

		Agent updatedAgent = service.update(agentToUpdate);

		return ResponseEntity.ok(updatedAgent);
	}

	@CrossOrigin
	@DeleteMapping("/agent/{id}")
	ResponseEntity<?> deleteAgent(@PathVariable(value = "id") long id) {
		Agent agent = service.getOneById(id);
		if (agent == null)
			return ResponseEntity.notFound().build();

		service.delete(agent);
		return ResponseEntity.ok().build();
	}
}
