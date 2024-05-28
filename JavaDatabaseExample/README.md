# Student Database Management System

This is a simple Java project that demonstrates basic CRUD (Create, Read, Update, Delete) operations on a PostgreSQL database using JDBC. The project manages student records in a database.

## Project Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- - `main`
- - - `java`
- - - - `com`
- - - - - `example`
- - - - - - `database`: the folder to maintain the source code for the project
- - - - - - `models`: the folder to maintain the students object
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- PostgreSQL database
- PostgreSQL JDBC Driver

### Database Setup

1. **Install PostgreSQL** and create a new database called `school` (You can change the credentials tho).
2. **Create a table** for storing student records:

```sql
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL
);
```

### Configuration

1. Update the database connection details in `DatabaseManager.java`

```java
public static Connection getConnection() {
    String url = "jdbc:postgresql://localhost:5432/school";
    String user = "your_username";
    String password = "your_password";

    try {
        return DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}
```
2. Replace `your_username` and `your_password` with your PostgreSQL username and password.

### Running the Application

1. Compile the project using your preferred IDE or using the command line:

```sh
javac -d out/ src/main/java/com/example/database/*.java src/main/java/com/example/database/models/*.java
```

2. Run the app:

```sh
java -cp out/ main.java.com.example.database.Main
```

## Usage

The `main` class demonstrates the following operations:

1. Connecting to the database: Establishes a connection to the PostgreSQL database.
2. Creating a new student: Adds a new student to the database.
3. Retrieving a student: Fetches a student record by ID.
4. Updating a student: Updates the student's last name.
5. Deleting a student: Deletes the student record from the database.
6. Disconnecting from the database: Closes the database connection.

### Example Output

```sh
Connected to the database successfully.
Added student: Student{id=1, name='Joan', lastName='Garcia'}
Retrieved student: Student{id=1, name='Joan', lastName='Garcia'}
Updated student: Student{id=1, name='Joan', lastName='Martínez'}
Deleted student with ID 1
Disconnected from the database.
```

## Contributing
No quiero nada, me gusta como me ha queda'o, dejadme en paz.

## License
This project is licensed under the MIT License. See the [LICENSE]() file for details.

## Acknowledgements
- [PostgreSQL](https://www.postgresql.org/) - Postgres official page
- [Java](https://www.oracle.com/java/) - JAVA THINGS, GO READ THE API OR SOMETHING