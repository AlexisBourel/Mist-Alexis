package co.simplon.springboot.simplecrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.springboot.simplecrud.model.Agent;
import co.simplon.springboot.simplecrud.repository.AgentRepository;
import co.simplon.springboot.simplecrud.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService{

	@Autowired
	private AgentRepository agentRepository;
	
	
	public List<Agent> getAllAgents(){
		return this.agentRepository.findAll();
	}
	
	public void deleteAgent(Agent utilisateur) {
		this.agentRepository.delete(utilisateur);
	}
	
	public Agent getAgent(Long id) {
		return this.agentRepository.findOne(id);
	}

	@Override
	public Agent addAgent(Agent agent) {
		return this.agentRepository.save(agent);
	}
	
	public Agent saveAgent(Agent agent) {
		return this.agentRepository.save(agent);
	}
}
