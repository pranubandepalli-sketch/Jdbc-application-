# Student Management System

A complete beginner-friendly web application integrating:

- Java 17
- Spring Boot
- Spring MVC
- JDBC / JdbcTemplate
- MySQL
- Thymeleaf frontend
- HTML + CSS + JavaScript
- CRUD operations
- Server-side validation
- Search/filter in the frontend

## Features

1. Add student
2. View all students
3. Edit student
4. Delete student
5. Search students
6. Validation for name, email and course
7. Persistent MySQL storage
8. MVC structure: Controller -> Service -> Repository -> MySQL
9. Responsive frontend

## Project structure

src/main/java
  model/Student.java
  repository/StudentRepository.java
  service/StudentService.java
  controller/StudentController.java

src/main/resources
  templates/
  static/css/
  static/js/
  application.properties
  schema.sql

database/setup.sql

## Requirements

- JDK 17+
- Maven 3.9+
- MySQL 8+

## Setup

### 1. Create the database

Open MySQL and run:

SOURCE database/setup.sql;

Or execute the SQL in database/setup.sql manually.

### 2. Configure MySQL password

Open:

src/main/resources/application.properties

Change:

spring.datasource.password=YOUR_MYSQL_PASSWORD

to your actual MySQL root password.

If your MySQL username is not root, change the username too.

### 3. Run the application

From the project directory:

mvn spring-boot:run

Then open:

http://localhost:8080

## How data is stored

When you submit the Add Student form:

Browser -> StudentController -> StudentService -> StudentRepository -> JdbcTemplate -> MySQL

The INSERT query stores the record in the students table.

Edit uses UPDATE and Delete uses DELETE.

## Build a JAR

mvn clean package

Then run:

java -jar target/student-management-1.0.0.jar

## Notes

The application uses Thymeleaf for server-rendered HTML. The JavaScript search is client-side; all student records themselves are stored in MySQL.

For production use, add authentication, CSRF protection, database migrations, stronger validation, logging, and environment variables for secrets.
