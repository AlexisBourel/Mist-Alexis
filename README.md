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




**  IMPORTATION DU PROJET**

Installer les prérequis si nécéssaire
Télécharger le dossier .zip du projet ou l'importer (voir ci dessous)
- Lancer le gitBash à l'emplacement ou vous voulez importez le projet (click Droit "Git Bash Here")
- Lancer la commande "git clone https://github.com/AlexisBourel/Mist-Alexis.git"
 
 
 
 
**  CONFIGURATION TECHNIQUE   **

Allez dans le dossier Ressources (Mist-Springboot/src/main/ressources) : 

Dedans se trouve fichier "mist.sql" qui permet de construire la base de données et la remplir avec quelques entrée de test)
Ainsi que "application.properties" (y indiquer les informations de connection a votre base de données)

Lancer le server sql, 
importer la base de données (avec le fichier mist.sql https://www.it-connect.fr/importer-un-fichier-sql-en-ligne-de-commande%EF%BB%BF/)




** LANCEMENT DE L'APPLICATION **

L'application étant séparer en deux parties, il faut les démarrer toutes les deux pour que l'application fonctionne

-- Lancer l'application Springboot --
 
 Deux possibilité :
  
    1. Créer un .jar : 
    
      Ouvrez une invite de commande dans le dossier "Mist-Springboot" et lancez les lignes suivantes :
      
      - mvn package -DskipTests
      - cd target
      - java -jar java-springboot-simplecrud-0.0.1-SNAPSHOT.jar"
      
    2. Importer le projet dans un EDI:
    
      - Click Droit dans le "package explorer" 
      - Séléctionner "import"
      - "Existing Maven Project"
      - Parcourir (bouton) dans les dossier afin de retrouver l'emplacement du dossier et y retrouver le pom.xml
      - "Valider"
      - Click Droit sur le dossier du projet
      - "Run as"
      - "Spring Boot App"



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

Ps (coté formateur): La partie que j'ai développé seul est tout ce qui est relié a la table "affaire" 
  Il faut aller sur le boutton "GESTION" puis cliquer sur "affaires" en dessous du header
  les bouttons lister et ajouter affaire fonctionnent correctement tandis que les bouttons modifier et supprimer ne s'affiche pas sur le front, mais l'api fonctionne correctement (test sur POSTMAN via les URL suivant :
  
  
    PUT http://localhost:8080/api/affaire/{{id}} 
  pour la modification d'une affaire, 
  exemple PUT http://localhost:8080/api/affaire/1
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
    
   {{id}} à remplacer par l'id d'une affaire éxistante dans la BDD
