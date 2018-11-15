# Refactoring with Design Patterns


#### Startup with Profile settings
##### Default profile, H2 database
##### execute tests
``
mvn clean test
``

or

``
mvn clean package -DskipTests=true
``

``
java  -jar target/refactoring-0.0.1-SNAPSHOT.jar
``


Final Product requires External MySql Database.
Install Docker
#### Docker Commands
##### Start MySql Container
``
docker run  --detach   --name refactor-mysql -p 6604:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=refactor -e MYSQL_USER=alex -e MYSQL_PASSWORD=alex -d mysql
``

##### view all images
``
docker images
``

##### view all containers (running or not)
``
docker ps -a
``

##### Interact with Database (link to ec-mysql container) with mysql client
``
docker run -it --link refactor-mysql:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'
``
##### Stop ec-mysql container
``
docker stop refactor-mysql
``
##### (ReStart) ec-mysql container
``
docker start refactor-mysql
``
##### Remove ec-mysql container (must stop it first)
``
docker rm refactor-mysql
``
##### Remove image (must stop and remove container first)
``
docker rmi mysql:latest
``




##### mysql profile, MySql database (requires running container refactor-mysql)
``
mvn clean test -Dspring.profiles.active=mysql 
``

or

``
java  -Dspring.profiles.active=mysql -jar target/refactoring-0.0.1-SNAPSHOT.jar
``
