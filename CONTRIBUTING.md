# Contributing to Movie Ticket Management System

Welcome! We're glad you're interested in contributing to the Movie Ticket Management System project. This guide outlines how to get started and the best practices to follow.

---

## Table of Contents

1. [Prerequisites & Tech Stack Overview](#prerequisites--tech-stack-overview)
2. [Project Setup](#project-setup)
3. [Contribution Workflow](#contribution-workflow)
4. [Code Standards & Best Practices](#code-standards--best-practices)


## Prerequisites & Tech Stack Overview

**You should have:**
- Basic Java programming knowledge
- Java Development Kit (JDK 8 or higher)
- MySQL installed and configured
- Java IDE (VS Code, IntelliJ IDEA, Eclipse, etc.)

**Tech Stack:**

- Language: Java
- Frontend: Java Swing
- Backend: Java (JDBC for database interaction)
- Database: MySQL (using JDBC)

## Project Setup

### 1. Prerequisites
* Java JDK 8 or above
* MySQL installed and running (MySQL Workbench)
* VS Code


### 2. Clone the Project

If you haven't already:

```bash
git clone https://github.com/<your-username>/movie-ticket-management.git
cd movie-ticket-management
```

### 3. Open the Project in VS Code
* Open VS Code → File > Open Folder → Select the cloned folder.
* Make sure your project folder contains .java files and the assets/ folder.

### 4. Set Up the MySQL Database
* Open MySQL Workbench.
* Create a new database:
  ```
  movie_ticket_management_system_CP
  ```
* Make sure MySQL is running.
* User: root, Password: 12345 (as used in your Conn.java)

### 5. Project Files and Image Setup
* Ensure your GUI background image is placed at:
  ```
  assets/images/MovieBackGround.jpeg
  ```
* Confirm the image path used in `User_Interface.java` matches this location.

### 6. Run the Application
* Open User_Interface.java in VS Code
* Right-click → Run Java
* The GUI window should open with menu options and background image.

## Contribution Workflow
If you’d like to contribute to this Movie Ticket Management System project, follow the steps below:

### 1. **Fork the Repository**

Click on the **Fork** button on GitHub to create your own copy of the project.

### 2. **Clone Your Fork**

```bash
git clone https://github.com/your-username/movie-ticket-management.git
cd movie-ticket-management
```

### 3. **Create a New Branch**

Use a meaningful name for your feature or fix:

```bash
git checkout -b feature/your-feature-name
```

### 4. **Make Changes**

Work on the Java files, assets, or database logic using **VS Code**.


### 5. **Commit Your Changes**

```bash
git add .
git commit -m "Add: short description of your changes"
```

### 6. **Push to GitHub**

```bash
git push origin feature/your-feature-name
```

### 7. **Open a Pull Request**

Go to your forked repo → Click **"Compare & pull request"** → Add a description → Submit.

## Code Standards & Best Practices
### Java Code Guidelines
* Use **meaningful class and method names** (`User_Interface`, `List_of_movies`, `Conn`, etc.).
* Follow **camelCase** for variables and methods, and **PascalCase** for classes.
* Add **comments** to explain complex logic, especially in database interaction (`Conn`) or UI transitions.
* Keep each class focused on **a single responsibility** (UI, DB, etc.).

### UI Guidelines (Swing)
* Add components **to the container before calling `setVisible(true)`**.
* Set layout manually using `setBounds()` or use layout managers if needed.
* Keep image paths consistent (e.g., `assets/images/...`) and accessible with `ClassLoader.getSystemResource`.

### Database

* Use **parameterized queries** (in future updates) to avoid SQL injection.
* Keep database name and credentials **configurable**, not hardcoded.

### General

* Format code using **Java formatting tools** (e.g., VS Code Java Formatter).
* Test each feature before pushing.
* Keep PRs **focused** – one feature or fix per PR.


# 
*Thank you for your interest in contributing! We appreciate your time and effort in helping improve the Movie Ticket Management System. If you have any questions or suggestions, feel free to open an issue.*