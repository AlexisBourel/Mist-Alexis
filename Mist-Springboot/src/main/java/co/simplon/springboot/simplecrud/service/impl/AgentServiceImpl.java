package co.simplon.springboot.simplecrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.springboot.simplecrud.model.Agent;
import co.simplon.springboot.simplecrud.repository.AgentRepository;
import co.simplon.springboot.simplecrud.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	AgentRepository repo;
	
	@Override
	public List<Agent> getAll() {
		return repo.findAll();
	}

	@Override
	public void delete(Agent agent) {
		repo.delete(agent);		
	}

	@Override
	public Agent getOneById(Long id) {
		return repo.getOne(id);
	}

	@Override
	public Agent add(Agent agent) {
		return repo.save(agent);
	}

	@Override
	public Agent update(Agent agent) {
		return repo.save(agent);
	}
	
	@Override
	public Agent mockAgent(String nom, String prenom, String profil) {
		Agent mockedAgent = new Agent();
		String mockEmail = new StringBuilder(
				nom.toLowerCase()).append(".").append(prenom.toLowerCase()).append("@mail.com").toString();
		String mockMdp = new StringBuilder(prenom).append("MDP").toString();
		mockedAgent.setNom(nom);
		mockedAgent.setPrenom(prenom);
		mockedAgent.setProfil(profil);
		mockedAgent.setEmail(mockEmail);
		mockedAgent.setMotDePasse(mockMdp);
		return mockedAgent;
	}

}
