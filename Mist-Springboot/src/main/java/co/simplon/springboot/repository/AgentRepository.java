package co.simplon.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.springboot.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
