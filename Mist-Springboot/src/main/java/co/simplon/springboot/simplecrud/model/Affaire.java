package co.simplon.springboot.simplecrud.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "affaire")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Affaire implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7492656493898251454L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	@Column(name="id_agent")
	private long idAgent;
	@NotNull
	@Column(name="titre", unique=true)
	private String titre;
	@NotNull
	@Column(name="date_ouverture")
	private Date dateOuverture;
	@NotNull
	@Column(name="status", length=25)
	private String status;
	@Column(name="date_cloture")
	private Date dateCloture;
	@NotNull
	@Lob
	@Column(name="description")
	private String description;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(long idAgent) {
		this.idAgent = idAgent;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateCloture() {
		return dateCloture;
	}
	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}