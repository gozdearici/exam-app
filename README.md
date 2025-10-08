# Exam Application

A simple **Spring Boot + PostgreSQL** application to manage exams, designed as a mini project to demonstrate backend skills including REST API development, database integration, validation, and exception handling.

## Features

- Create, read, update, delete exams (CRUD)
- Exam entity contains:
  - `title` (cannot be empty)
  - `description`
  - `questions` (at least one)
- Validation using `@Valid` and `@NotNull`
- Global exception handling for:
  - Resource not found
  - Validation errors
- PostgreSQL integration
- Ready for frontend connection (tested with React)

## Technologies

- Java 17
- Spring Boot
- JPA / Hibernate
- PostgreSQL
- Maven

## Getting Started

1. Clone the repository:
   ```bash
   git clone <repo-url>
   cd exam-app
   ```
   
2. Configure your database in application.properties:
  ```bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/examdb
  spring.datasource.username=postgres
  spring.datasource.password=postgres
  spring.jpa.hibernate.ddl-auto=update
  ```

3. Build and run the application:
  ```bash
  mvn clean install
  mvn spring-boot:run
  ```

4. Test API endpoints:

GET /api/exams → list all exams

POST /api/exams → create a new exam

PUT /api/exams/{id} → update an exam

DELETE /api/exams/{id} → delete an exam

## Notes
- A React frontend was optionally developed for testing purposes.
- Validation and global exception handling ensures clean API responses.
