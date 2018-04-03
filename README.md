# Mist-Alexis

** CONFIGURATION REQUISE **

JRE installer sur l'ordinateur (v 1.8)
MySql-server (v 5.7)
git (v2.14)
un Environnement Developpement Intégré (Eclipse oxygen de préférence)


**  Pour le fonctionnement  **

Installer les prérequis si nécéssaire (Super tutoriels présent sur le net #Demande à Google)
Lancer le gitBash à l'emplacement ou vous voulez importez le projet (click Droit "Git Bash Here")
Lancer la commande "git clone https://github.com/AlexisBourel/Mist-Alexis.git"
 
**  CONFIGURATION TECHNIQUE   **

Allez dans le dossier Ressources (Mist-Springboot/src/main/ressources) : 

Dedans se trouve fichier "mist.sql" qui permet de construire la base de données et la remplir avec quelques entrée de test)
Ainsi que "application.properties" (y indiquer les informations de connection a votre base de données)

Lancer le server sql, 
initier la base de données (avec le fichier mist.sql voir ci dessus)


** LANCEMENT DE L'APPLICATION **

L'application étant séparer en deux parties, il faut les démarrer toutes les deux pour 

-- Lancer l'application Springboot --
 
 Deux possibilité :
  
    1. Créer un .jar : ! ATTENTION ! il faut bien se positionner dans le dossier Mist-Springboot
      -lancer la commande suivante :
      "mvn package -DskipTests
       cd target
       java -jar java-springboot-simplecrud-0.0.1-SNAPSHOT.jar"
      Mise en route du programme : 
      -lancer la commande shell "java -jar mist.jar"
      
    2. Importer le projet dans un EDI:
        -Click Droit dans le "package explorer" 
        -Séléctionner "import"
        -"Existing Maven Project"
        -Parcourir (bouton) dans les dossier afin de retrouver l'emplacement du dossier et y retrouver le pom.xml
        -"Valider"
      - Click Droit sur le dossier du projet
      - "Run as"
      - "Spring Boot App"

-- Lancer l'application angular --

via la commande "npm install" puis "ng serve -o" ! ATTENTION ! il faut bien se positionner dans le dossier Mist-Angular


Ps (coté formateur): La partie que j'ai développé seul est tout ce qui est relié a la table "affaire" 
  Il faut aller sur le boutton "GESTION" puis cliquer sur "affaires" en dessous du header
  les bouttons lister et ajouter affaire fonctionnent correctement
  - Bouttons modifier et supprimer ne s'affiche pas sur le front, mais l'api fonctionne correctement   
  (A test sur POSTMAN via les URL suivant :
  ici {{id}} à remplacer par l'id d'une affaire éxistante dans la BDD
  PUT http://localhost:8080/api/affaire/{{id}} pour la modification 
  exemple PUT http://localhost:8080/api/affaire/1
  pour modifier une affaire
  avec {
        "id": 1,
        "idAgent": 1,
        "titre": "Entrée Test",
        "dateOuverture": "23 septembre 2002",
        "status": "Ouverte",
        "dateCloture": null,
        "description": "Test résumé"
    } en format JSON
    
    DELETE http://localhost:8080/api/affaire/{{id}} 
    pour supprimer une affaire 
