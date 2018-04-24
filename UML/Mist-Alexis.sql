# Creation de la base de donnees
CREATE DATABASE IF NOT EXISTS mist;
USE mist;

# Creation de la table Profil
CREATE TABLE IF NOT EXISTS profil (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  libelle varchar(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

# Creation de la table agent 
CREATE TABLE IF NOT EXISTS agent (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(255) DEFAULT NULL,
  motdepasse varchar(255) DEFAULT NULL,
  nom varchar(255) DEFAULT NULL,
  prenom varchar(255) DEFAULT NULL,
  id_profil bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


# Creation de la table affaire
CREATE TABLE IF NOT EXISTS affaire (
    id bigint(20) NOT NULL AUTO_INCREMENT, 
    id_agent bigint(20) NOT NULL,
    titre varchar(45)NOT NULL,
    date_ouverture varchar(25) NOT NULL,
    status varchar(10) NOT NULL,
    date_cloture varchar(25),
    description text NOT NULL,
	PRIMARY KEY (id)
)   ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
COMMIT;

# Ajout des contraintes (intéractions entre tables)
ALTER TABLE agent
  ADD CONSTRAINT fk_id_profil FOREIGN KEY (id_profil) REFERENCES profil (id);
ALTER TABLE affaire
  ADD CONSTRAINT fk_id_agent FOREIGN KEY (id_agent) REFERENCES agent (id);
#Transaction manuelle
COMMIT;	
--
-- Insertions des donnees pour des test
--
# Insertion des deux profils 
INSERT INTO profil (id, libelle) VALUES
(1, 'ADMIN'),
(2, 'UTILISATEUR');
# Insertion de 4 agents
INSERT INTO agent (nom, prenom, id_profil) VALUES
('BOUREL', 'Alexis', 1),
('NOURRY', 'Jean-Luc', 2),
('SUZANNE', 'Jordan', 1),
('NESIC', 'Alexandre', 2);
# Insertion d'affaires de test
INSERT INTO affaire (id_agent, titre, date_ouverture, status, description)
VALUES (1, "Entrée Test", "23 septembre 2002", "Ouverte", "Test résumé");
INSERT INTO affaire (id_agent, titre, date_ouverture, status, description)
VALUES (1, "Plus dure sera la chute", "23 septembre 2002", "Ouverte", "Résumé1");
INSERT INTO affaire (id_agent, titre, date_ouverture, status, description)
VALUES (2, "Apparences trompeuses", "30 septembre 2002", "Ouverte", "Résumé2");
INSERT INTO affaire (id_agent, titre, date_ouverture, status, description)
VALUES (3, "Le Prix de la liberté", "7 octobre 2002", "Ouverte", "Résumé3");
INSERT INTO affaire (id_agent, titre, date_ouverture, status, description)
VALUES (4, "Les Dessous de Miami", "14 octobre 2002", "Ouverte", "Résumé4");


