# About this project
A basic API service using Spring Boot   
## Prequisites
- Have Docker installed on your local machine
## Installation
1. Clone the repository
2. Replace the sensitive values like database credentials in the `.env` file with your own values
3. Run the following command to build the jar package
```bash
  mvn clean package -DskipTests
```
4. Run the following command to start the application
```bash
  docker compose up -d --build
```

## Usage
Access the url `http://localhost:<your port>/swagger-ui.html` to get the API documentation