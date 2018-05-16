# Mist-Alexis

Afin de pourvoir installer et lancer l'application, il faut savoir utiliser les lignes de commandes
https://windows.developpez.com/cours/ligne-commande/




** CONFIGURATION REQUISE **

- JRE installer sur l'ordinateur (v 1.8), attention la v 1.9 est déconseillée
https://www.java.com/fr/download/help/download_options.xml
- MySql-server (v 5.7 +)
https://dev.mysql.com/downloads/mysql/#downloads
https://openclassrooms.com/courses/administrez-vos-bases-de-donnees-avec-mysql/installation-de-mysql
- git (v2.14 +) 
https://git-scm.com/book/fr/v1/D%C3%A9marrage-rapide-Installation-de-Git
- Node.js 
https://openclassrooms.com/courses/des-applications-ultra-rapides-avec-node-js/installer-node-js (tuto installation)
https://nodejs.org/en/download/ (téléchargement)
- Angular CLI (v1.6.5 +)
lancer la ligne de commande "npm install @angular/cli" (nécéssite node.js)
 
un Environnement Developpement Intégré (Eclipse oxygen de préférence) peux être nécéssaire pour l'import et le lancement de l'application (voir section lancement de l'application 2. importer dans un EDI)




**  IMPORT DU PROJET**

Installer les prérequis si nécéssaire
Télécharger le dossier .zip du projet 
ou l'importer (voir ci dessous)
 - Lancer le gitBash à l'emplacement ou vous voulez importez le projet (click Droit "Git Bash Here")
 - Lancer la commande "git clone https://github.com/AlexisBourel/Mist-Alexis.git"
 
 
 
 
**  CONFIGURATION TECHNIQUE   **

Tour d'abords il faut crée un base de données

Allez dans le dossier Ressources (Mist-Springboot/src/main/ressources) : 

Dedans se trouve fichier "application.properties", il faut indiquer les informations de connection a votre base de données (url, et identiffiants admins de connexions)

Lancer le server sql si il ne se lance pas automatiquement au démarage du système d'exploitation (google => 'How to check if mySql server is working'), puis lancer l'application (voir ci dessous). 

** LANCEMENT DE L'APPLICATION **

L'application étant séparer en deux parties, il faut les démarrer toutes les deux pour que l'application fonctionne

-- Lancer l'application Springboot --
 
 Deux possibilité :
  
    1. Créer un .jar : 
    
      Ouvrez une invite de commande dans le dossier "Mist-Springboot" et lancez les lignes suivantes :
      
      - mvn package -DskipTests
      - cd target
      - java -jar java-springboot-simplecrud-0.0.1-SNAPSHOT.jar"
      
    2. Sans créer de .jar :
    
      Ouvrez une invite de commande dans le dossier "Mist-Springboot" et lance la ligne suivante :
      - mvn run -DskipTests

-- Lancer l'application angular --

    Ouvrez une invite de commande dans le dossier "Mist-Angular" et lancez les lignes suivantes :
      
      - npm install
      - ng serve -o

L'application est prête a fonctionner 

** Credits **

Merci :
@SMartin81 pour la partie Springboot
https://github.com/simplonco/java-workshops-springboot-simplecrud
@Hemoroide, @jnl06140 et @KyzenLJ pour la partie Angular
https://github.com/Hemoroide/mist_angular
@Google, pour tout le reste

*** POUR LES FORMATEURS ***
La création des données fictives / test (Tables + entrées) dans la base de données se fait automatiquement via des méthodes dans les services côté server (Java) au premier appel (un refresh de la page est nécéssaire).
Les requêtes correspondantes sont : 

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
# Insertion d'une affaire de test
INSERT INTO affaire (id_agent, titre, date_ouverture, status, description)
VALUES (1, "Entrée Test", "23 septembre 2002", "Ouverte", "Test résumé");
# Ajout d'une contrainte (intéractions entre tables)
ALTER TABLE affaire
  ADD CONSTRAINT fk_id_agent FOREIGN KEY (id_agent) REFERENCES agent (id);






