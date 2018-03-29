package co.simplon.springboot.model;

import java.sql.Timestamp;

public class Affaire {

	private long id;
	private long agentResponsable;
	private String titre;
	private String description;
	private String dateOuverture;
	private String status;
	private String dateCloture;
	private Timestamp lastUpdate;
	

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getAgentResponsable() {
		return agentResponsable;
	}

	public void setAgentResponsable(long idAgent) {
		this.agentResponsable = idAgent;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(String dateCloture) {
		this.dateCloture = dateCloture;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
