# Task Management Mini Project

This project is a Task Management application that uses **Spring Boot** for the backend and **Angular** for the frontend. The application allows users to manage tasks with two roles: **Admin** and **User**. The admin can manage all tasks, while the user can only view, edit, and filter their assigned tasks.

---

## Project Structure

The project has two main folders:

1. **Frontend**: Contains the Angular application (client-side).
2. **TasksProjectTest**: Contains the Spring Boot application (server-side).

---

## Features

### Backend Features (Spring Boot)

- **Authentication**:
  - The backend uses **JWT (JSON Web Token)** for authentication. Users can log in to the application, and the JWT token is returned, which includes the user’s role.
- **User Roles**:

  - **Admin**: Can access all functionality.
  - **User**: Can only access tasks assigned to them and can edit the status of those tasks.

- **Task Management**:
  - **Admin** can create, read, update, and delete tasks.
  - **User** can view their tasks, edit the status of their tasks, and filter tasks by title and status.

### API Endpoints

- **Authentication**:

  - `POST /api/auth/login`: Logs in the user and returns a JWT token with their role.

- **Task-Related APIs**:
  - `GET /api/tasks/all`: Retrieves all tasks from the database (Admin only).
  - `GET /api/tasks/user_tasks`: Retrieves tasks assigned to a specific user.
  - `GET /api/tasks/{id}`: Retrieves a task by its ID.
  - `POST /api/tasks`: Creates a new task (Admin only).
  - `PUT /api/tasks/{id}`: Updates an existing task (Admin only).
  - `DELETE /api/tasks/{id}`: Deletes a task (Admin only).
  - `GET /api/tasks/filter`: Filters tasks by title and status for all tasks.
  - `GET /api/tasks/user_filter`: Filters tasks by title and status for a specific user.

---

## Setup and Configuration

### Backend Configuration (Spring Boot)

- **Database**:
  The application uses **PostgreSQL** hosted by **Vercel** for the database. The connection details are configured in the `application.properties` file:

  ```properties
  # PostgreSQL Configuration (from Vercel)
  spring.datasource.url=jdbc:postgresql://ep-autumn-forest-a5649r79-pooler.us-east-2.aws.neon.tech/neondb?sslmode=require
  spring.datasource.username=neondb_owner
  spring.datasource.password=npg_eOaKBLqM4h7D
  spring.datasource.driver-class-name=org.postgresql.Driver

  # Hibernate Configuration
  spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  logging.level.org.springframework.security=DEBUG
  ```
