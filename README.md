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

Allez dans le dossier Ressources (Mist-Springboot/src/main/ressources) : 

Dedans se trouve fichier "application.properties", il faut indiquer les informations de connection a votre base de données (url, et identiffiants admins 

Lancer le server sql, 
importer la base de données (avec le fichier Mist-Alexis.sql présent dans le dossier UML https://www.it-connect.fr/importer-un-fichier-sql-en-ligne-de-commande%EF%BB%BF/)




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

Ps (coté formateur):
  Lors de la migration jpa vers JDBC, j'ai eu des problèmes, des bugs anormaux sont apparus, j'ai donc recrée un projet ou j'ai épuré tout ce qui ne concernais pas la partie affaires.

  Pour voir le résultat, il faut aller sur le boutton "GESTION" directement de la page d'accueil, (j'ai enlevé la page de connexion qui n'était pas fonctionnelle)
  L'affichage de la liste d'affaires s'affiche automatiquement, dans le meilleur des monde (la V2),j'ai essayer de faire une version imbricable directement dans le projet groupe (voirs les mock-up) ou gestion retourne plusieurs onglet (affaires, vehicules, armes et suspects), mais n'étant pas présente dans mon projet, j'ai affiché directement la liste sans passer par l'onglet.
  De plus j'ai rajouter un gros bouton "créer affaire" qui dans la V2 devrait faire partie de l'onglet "affaire" (qui contiendrais donc deux options, liste et créer).
  
  Pour l'import de la base SQL, j'ai réécri entierement le fichier Mist-Alexis.sql, ce fichier ainsi que les autres UML sont disponibles dans un nouveau dossier à la racine, "UML".
