package co.simplon.springboot.simplecrud.service;

import java.util.List;

import co.simplon.springboot.simplecrud.model.Agent;

public interface AgentService {
	
	List<Agent> getAll();
	void delete(Agent agent);
	Agent getOneById(Long id);
	Agent add(Agent agent);
	Agent update(Agent agent);
	Agent mockAgent(String nom, String prenom, String profil);

}
