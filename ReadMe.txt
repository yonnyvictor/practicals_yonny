Create a Mariadb database name eprod_school
Run the eprod_school.sql to setup the database structure
The database username and password must be set on the main Applicaiton File found in src/com/eprod/school/EprodSchoolApp.java

Compile and Run to teust

The application is built using Javalin framework (https://javalin.io/)

API endpoints

Retrieve Students
GET http:127.0.0.1:8080/students

Add/Edit/Delete Student
POST http:127.0.0.1:8080/students


Retrieve Registrations
GET http:127.0.0.1:8080/registrations
