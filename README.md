# Mist-Alexis

** CONFIGURATION REQUISE **

JRE installer sur l'ordinateur (v 1.8)
MySql-server (v 5.7)

** CONFIGURATION TECHNIQUE **

Allez dans le dossier Ressources (Mist-Springboot/src/main/ressources) : 

Dedans se trouve le .jar(package du programme Spring boot)
Ainsi que le fichier mist.sql qui permet de construire la base de données et la remplir avec quelques entrée de test)
Et le fichier application.properties (y indiquer les informations de connection a votre base de données)


**  Pour le fonctionnement  **

Lancer le server sql, 
initier la base de données (avec le fichier mist.sql voir ci dessus)

Lancer l'application Springboot :
via la commande shell "java -jar mist.jar" ! ATTENTION ! il faut bien se positionner dans le dossier Mist-Springboot

Lancer l'application angular 
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
