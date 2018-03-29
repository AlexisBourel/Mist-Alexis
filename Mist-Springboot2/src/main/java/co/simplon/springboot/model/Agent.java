package co.simplon.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "agent")
public class Agent implements Serializable{

	private static final long serialVersionUID = -7492656493898251454L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Email
	@Column(name ="email")
	private String email;
	
	@Column(name ="motdepasse")
	private String motdepasse;

	@Column(name = "id_profil")
	private int idProfil;
	
	
	public Agent(long id, String nom, String prenom, String email, String motdepasse, int idProfil) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motdepasse = motdepasse;
		this.idProfil = idProfil;
	}

	public Agent() {
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMotdepasse() {
		return motdepasse;
	}
	
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public int getIdProfil() {
		return idProfil;
	}

	public void setProfilId(int idProfil) {
		this.idProfil = idProfil;
	}

	
	
	
	
}