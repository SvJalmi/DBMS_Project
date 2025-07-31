# DBMS_Project

Movie Theatre Management System using Java and MySQL.

---

## Local Development Setup

This guide will help you set up and run the Movie Theatre Management System on your local machine.

### Prerequisites

Before you begin, ensure you have the following installed:

* **Java Development Kit (JDK) 8 or higher**: Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.java.net/install/).
* **MySQL Database Server**: Download from [MySQL Community Downloads](https://dev.mysql.com/downloads/mysql/).
* **MySQL Connector/J (JDBC Driver)**: The project uses `mysql-connector-j-9.2.0.jar`. You will need to download this JDBC driver to establish a connection between Java and MySQL. You can download it from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).
* **An IDE (Integrated Development Environment)**: Such as [Apache NetBeans](https://netbeans.apache.org/download/index.html) or [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/). These IDEs make it easier to manage Java projects and dependencies.

### Database Setup

1.  **Start MySQL Server**: Ensure your MySQL server is running.

2.  **Create Database and Tables**:
    * Open your MySQL client (e.g., MySQL Workbench, command-line client).
    * Execute the SQL script located in `movie_ticket_management_system_CP.sql`. This script will create the `movie_ticket_management_system_CP` database and all necessary tables.

    ```sql
    -- Example commands if using MySQL command line:
    -- mysql -u root -p
    -- SOURCE path/to/your/cloned/repo/movie_ticket_management_system_CP.sql;
    ```

3.  **Configure Database Connection**:
    * The project uses the `Conn.java` file for database connectivity.
    * **Crucially, update the connection details in `Conn.java`** to match your MySQL server's root password (or create a new user and use its credentials).
    * **Default Connection String (from `Conn.java`):**
        ```java
        c = DriverManager.getConnection("jdbc:mysql:///movie_ticket_management_system_CP", "root", "12345");
        ```
    * **Change `"12345"` to your actual MySQL root password.** If your MySQL server is running on a different host or port, you'll need to update `jdbc:mysql:///movie_ticket_management_system_CP` accordingly (e.g., `jdbc:mysql://localhost:3306/movie_ticket_management_system_CP`).

### Application Setup and Run

1.  **Clone the Repository**:
    ```bash
    git clone [https://github.com/chirag-ydv/DBMS_Project.git](https://github.com/chirag-ydv/DBMS_Project.git)
    cd DBMS_Project
    ```

2.  **Add MySQL Connector/J to Classpath**:
    * Place the downloaded `mysql-connector-j-9.2.0.jar` file into a `lib` folder within your project directory (you might need to create this folder).
    * **In your IDE (Recommended):**
        * **NetBeans**: Right-click on your project -> `Properties` -> `Libraries` -> `Add JAR/Folder` and select `mysql-connector-j-9.2.0.jar`.
        * **IntelliJ IDEA**: Right-click on your project module -> `Open Module Settings` -> `Libraries` tab -> Click `+` -> `Java` -> Select `mysql-connector-j-9.2.0.jar`.

3.  **Compile and Run**:
    * The main entry point for the application is the `Login.java` file, which then leads to `User_Interface.java` upon successful login.
    * **Using an IDE (Recommended):**
        * Open the project in your IDE.
        * Ensure all `.java` files are part of the project.
        * Right-click on `Login.java` and select "Run File" or run the project directly from the IDE's run button.
    * **Using Command Line (More Advanced):**
        * Navigate to your project's `src` directory (or wherever your `.java` files are).
        * Compile the Java files, including the JDBC driver in the classpath:
            ```bash
            # Assuming you're in the project root and mysql-connector-j-9.2.0.jar is in a 'lib' folder
            javac -cp "lib/mysql-connector-j-9.2.0.jar;." *.java # For Windows
            # or
            javac -cp "lib/mysql-connector-j-9.2.0.jar:." *.java # For Linux/macOS
            ```
        * Run the main application:
            ```bash
            java -cp "lib/mysql-connector-j-9.2.0.jar;." Login # For Windows
            # or
            java -cp "lib/mysql-connector-j-9.2.0.jar:." Login # For Linux/macOS
            ```

### Login Credentials (Default/Example)

* **To create a user**: The `Login.java` has a "Sign up" button that leads to `Signup.java`. You should use this to create new user accounts in the `users` table.
* The `signup` table also stores user data, it seems to be an older version or a separate registration flow. Focus on the `users` table for login.

---

## Project Structure (Key Files)

* `Login.java`: Handles user authentication and is the application's starting point.
* `User_Interface.java`: The main graphical user interface after successful login.
* `Conn.java`: Manages the MySQL database connection. **(Remember to update credentials here)**
* `movie_ticket_management_system_CP.sql`: SQL script for database creation and initial table population.
* `mysql-connector-j-9.2.0.jar`: MySQL JDBC driver.
* Other `.java` files (e.g., `Signup.java`, `List_of_movies.java`, `Contact.java`, `Suggestion.java`, `payment.java`, `CANCEL.java`, `cardselection.java`, `recepit.java`, `recepit1.java`, `movies.java`, `Submitted.java`, `Thankyou.java`): These represent various features and screens of the Movie Theatre Management System.

---

Feel free to open an issue or pull request if you encounter any problems or have suggestions for improvement.