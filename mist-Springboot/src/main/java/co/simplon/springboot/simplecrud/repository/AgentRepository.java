package co.simplon.springboot.simplecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.springboot.simplecrud.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

}
