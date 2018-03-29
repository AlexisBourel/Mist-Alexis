package co.simplon.springboot.controller;

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

import co.simplon.springboot.model.Agent;
import co.simplon.springboot.repository.AgentRepository;

@RestController
@RequestMapping("/api")
public class AgentController {
	@Autowired
	AgentRepository repository;
	
	@CrossOrigin
	@GetMapping("/agent")
	List<Agent> getAllAgent(){
		return repository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/agent/{id}")
	ResponseEntity<Agent> getAgentById(@PathVariable(value="id") long id) {
	    Agent agent = repository.findOne(id);
	    if(agent == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(agent);
	}
	
	@CrossOrigin
	@PostMapping("/agent")
	Agent addAgent(@Valid @RequestBody Agent agent){
		return repository.save(agent);
	}
	
	@CrossOrigin
	@PutMapping("/agent/{id}")
	ResponseEntity<Agent> updateAgent(@PathVariable(value="id") long id, @Valid @RequestBody Agent agent){
		Agent agentToUpdate = repository.findOne(id);
		if(agentToUpdate == null)
			return ResponseEntity.notFound().build();
		
		// Update the mandatory attributes
		agentToUpdate.setPrenom(agent.getPrenom());
		agentToUpdate.setNom(agent.getNom());
		agentToUpdate.setProfilId(agent.getIdProfil());
		
		// Update all other not null attributes
		
		if(agent.getEmail() != null)
			agentToUpdate.setEmail(agent.getEmail());
		
		Agent updatedagent = repository.save(agentToUpdate);
		return ResponseEntity.ok(updatedagent);
	}
	
	@CrossOrigin
	@DeleteMapping("/agent/{id}")
	ResponseEntity<Agent> deleteAgent(@PathVariable(value="id") long id){
		Agent agent = repository.findOne(id);
		if(agent == null)
			return ResponseEntity.notFound().build();
		
		repository.delete(agent);
		return ResponseEntity.ok().build();
	}
}
