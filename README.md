Example Of Spring Boot with REST Service By Diwakar
=====================================================================================

Requirements
------------

* [Java Platform (JDK) 7 or above
* [Apache Maven 3.x](http://maven.apache.org/)


Set Up
------------
	1. Clone the Code using "git clone <Branch Name with URL>"
	2. Import this project as Maven Project in your Eclipse IDE
	3. Make sure there is no errors/problems in Eclipse tab bottom 


How to run the project
-----------
First Method:

mvn spring-boot:run

Second method:

1. `mvn package`
2. `java -jar target\spring-boot-example-1.0.jar`


Test your project
-----------

1. Point your browser to [http://localhost:8080/users] (http://localhost:8080/users)
   - You will get any empty [] data response as there is no user data present in the database.

2. Create a user either by Rest Client ot cURL command
   
   From Command prompt:
   
   `curl -X POST -d '{ "id": "i1", "password": "pass1" }' http://localhost:8080/users` 
   
   Or, 
   
   from Rest Client like PostMan or Chrome Advanced Rest Client send the POST request with sample data as above.

3. http://localhost:8080/users

4. You should get the response with user data

5. If you try to add the same user details again, you should receive an error saying duplicate user.


Note: 
In case, you want to change the Port to anything else,
change in application.properties
in case you are using JDK 7, change the JDK version to 1.7 in POM.xml in <java.version>1.8</java.version> to <java.version>1.7</java.version>


