package co.simplon.springboot.simplecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.springboot.simplecrud.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
