# BookMyTrip

**BookMyTrip** is a backend application built using a microservices architecture to enable users to search and book flight and bus tickets efficiently. Designed for scalability, reliability, and performance, the system leverages modern technologies and best practices in backend development.

---

## Features

- **Flight and Bus Ticket Search:** Seamlessly search for available flights and buses using various filters.
- **Authentication & Authorization:** Secure access using JWT (JSON Web Tokens) for robust user authentication and authorization.
- **Error Handling:** Centralized logging and error management to ensure system reliability.
- **Notifications:** Automatic notification integration for confirmations and updates

---

## Technologies Used

- **Programming Language:** Java
- **Framework:** Spring Boot
- **Databases:**
    - **PostgreSQL:** Relational database for storing critical application data like bookings, user information, and schedules.
    - **MongoDB:** NoSQL database for logging exceptions and errors.
- **Caching:** Redis for managing JWT tokens and optimizing performance.
- **Messaging Systems:**
    - **Kafka:** Event streaming for sending high-throughput exceptions to the `exception-service`.
    - **RabbitMQ:** Message queuing for reliable communication with the `notification-service`.
- **Security:** JWT (JSON Web Tokens) for user authentication and access control.
- **Containerization:** Docker for simplifying deployment and ensuring consistency across environments.
- **Service Discovery:** Integrated service discovery for efficient load balancing.
- **Reverse Proxy:** Nginx for enhancing security by validating client requests and controlling access.

---

## Architecture and Design

The application is designed as a collection of microservices, each responsible for a specific business function. Here are the key design decisions:

### PostgreSQL
- Used for persisting main application data to leverage its relational structure.
- Ideal for maintaining structured data like user profiles, bookings, and ticket inventories.

### MongoDB
- Dedicated for logging exceptions and error data.
- Enables flexible schema design to handle diverse error types without schema constraints.

### Redis
- Provides a caching layer for JWT tokens, ensuring token validity checks are fast and efficient.
- Supports revocation of tokens in real time, adding an extra layer of security.

### Kafka
- Implements high-throughput event streaming.
- Handles exception data flow to the `exception-service` with minimal latency, ensuring seamless processing under heavy load.

### RabbitMQ
- Manages communication with the `notification-service`, ensuring reliable delivery of booking confirmations and updates.

### JWT Authentication
- Secures API endpoints by validating tokens for each request.
- Ensures user sessions are both secure and lightweight.

### Service Discovery
- Provides automatic registration and discovery of services.
- Handles load balancing internally, ensuring efficient distribution of requests across instances.

### Docker
- Each microservice is containerized using Docker, simplifying deployment and enabling consistent runtime environments across different systems.
- Docker Compose is used to manage and orchestrate the services efficiently.

### Nginx
- Configured as a reverse proxy to validate client requests and control access to backend services.
- Enhances security by preventing direct client access to internal microservices.
---

## Challenges Solved

- **Scalability:** Designed to handle high volumes of user traffic by decoupling services and leveraging service discovery for load balancing.
- **Error Handling:** Centralized logging and error management using MongoDB ensure the application remains robust and easy to debug.
- **Performance Optimization:** Redis caching for JWT validation reduces latency and ensures a seamless user experience.
- **Security:** Comprehensive authentication and authorization mechanisms protect sensitive user data. Nginx adds another layer of security by validating and controlling access.
- **Efficient Deployment:** Docker ensures the application runs consistently across different environments, while service discovery and Nginx streamline communication.
---

## Installation and Setup

To run the application locally:

1. Clone this repository:
   ```bash
   git clone https://github.com/mehmetfatiherdem/BookMyTrip.git
   cd BookMyTrip

2. Build each microservice: Navigate to the directory of each microservice and run the following command:

   ```bash
   mvn clean package

3. Navigate back to the root directory of the project and run the following command:
   
   ```bash
   docker-compose up --build

4. Access the application through the Nginx reverse proxy at:

   ```bash
   http://localhost
---

## Troubleshooting
- **Dependencies:** If you encounter issues during the Maven build process, ensure all dependencies are properly downloaded and check the pom.xml files for each microservice.
- **Docker-specific issues** Verify that Docker and Docker Compose are installed and running correctly on your system.
---

## Let's Connect
If you would like to discuss how I can bring value to your team, feel free to reach out:

[GitHub](https://github.com/mehmetfatiherdem)
[LinkedIn](https://linkedin.com/in/matterdem)