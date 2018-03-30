package co.simplon.springboot.simplecrud.service;

import java.util.List;

import co.simplon.springboot.simplecrud.model.Agent;

public interface AgentService {

	List<Agent> getAllAgents();
	void deleteAgent(Agent agent);
	Agent getAgent(Long id);
	Agent addAgent(Agent agent);
	Agent saveAgent(Agent agent); 
}
