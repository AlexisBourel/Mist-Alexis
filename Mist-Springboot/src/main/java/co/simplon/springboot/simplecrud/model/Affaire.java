package co.simplon.springboot.simplecrud.model;

public class Affaire {

	private int id;
	private int agentResponsable;
	private String titre;
	private String description;
	private String dateOuverture;
	private String status;
	private String dateCloture;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAgentResponsable() {
		return agentResponsable;
	}

	public void setAgentResponsable(int agentResponsable) {
		this.agentResponsable = agentResponsable;
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

}
