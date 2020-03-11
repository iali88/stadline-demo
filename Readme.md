Test technique : Stadline 
-----------------------------

1. Liste des "endpoints" de l'api (en local):

http://localhost:8080/api/activities

http://localhost:8080/api/studios

http://localhost:8080/api/coaches

http://localhost:8080/api/events/full/{dateStart}/{dateEnd}/{calendrier}/{id} 
    
    -> permet d'avoir les events comme retourné par l'api Resamania

http://localhost:8080/api/events/{dateStart}/{dateEnd}/{calendrier}/{id}
    
    -> permet d'avoir les events dans un format simplifié

http://localhost:8080/api/activity/{id}

http://localhost:8080/api/studio/{id}

http://localhost:8080/api/coach/{id}


2. Une interface front a été implémentée, elle permet de voir les créneaux disponible à partir d'une plage de date.
   (http://localhost:8080/appli)

3. L'application stocke dans une table en base de données les intérrogations du planning. Utilisation d'une base en mémoire : H2. 
   
   
       -> accès à la base : http://localhost:8080/h2-console/
          Les informations de connexion sont par celles par défaut :
          _ Driver Class : org.h2.Driver
          _ JDBC URL : jdbc:h2:mem:testdb
          _ user Name : sa
          _ Password : (vide, aucun mot de passe)
      
      Les insertions se trouvent dans la table "TRACE_APPEL".
