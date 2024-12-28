# Timber Shop Management System

This repository contains the code for a Timber Shop Management System developed as a first-semester final project. The project is implemented using a layered architecture and MySQL as the database. It is designed to handle all essential operations of a timber shop, including managing items, orders, customers, order placement, and delivery.

## Features
- **Item Management:** Add, update, view, and delete timber items.
- **Customer Management:** Maintain customer details.
- **Order Management:** Place, view, and manage orders.
- **Delivery Management:** Track and update delivery status.
- **Layered Architecture:** Separation of concerns between different layers such as presentation, business logic, and data access.

## Technologies Used
- **Programming Language:** Java
- **Database:** MySQL
- **Build Tool:** Maven

## Project Structure
The project follows a layered architecture, which includes:

1. **Presentation Layer:** Handles user interactions.
2. **Business Logic Layer:** Contains the core business logic of the application.
3. **Data Access Layer:** Manages database interactions.

```
├── src
│   ├── presentation
│   │   └── [UI and controllers]
│   ├── business
│   │   └── [Business logic classes]
│   ├── data
│   │   └── [Database interaction classes]
├── resources
│   ├── database
│   │   └── schema.sql
│   │   └── seed.sql
├── README.md
└── pom.xml/build.gradle
```

## Setup Instructions

### Prerequisites
1. Install Java (JDK 11 or higher).
2. Install MySQL Server.
3. Install a build tool like Maven or Gradle (if required).


### Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/nethmiumaya/Project-Timber.git
   cd timber-shop-management
   ```
2. Build the project using your build tool (e.g., Maven/Gradle):
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   java -jar target/timber-shop-management.jar
   ```

### Testing
- Unit and integration tests can be found in the `src/test` directory.
- Run tests using:
  ```bash
  mvn test
  ```

---
Thank you for using the Timber Shop Management System!

