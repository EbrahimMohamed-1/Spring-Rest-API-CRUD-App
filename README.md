# Spring-Rest-API-CRUD-App


## Introduction
REST API web service built using **Spring Boot**, **Spring Data JPA**, and **REST API**. The project allows managing Products with endpoints for creating, retrieving, updating, and deleting Proudct records. It also includes **Swagger/OpenAPI documentation** and a global **exception** handler for better error management.

## Quick start
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/EbrahimMohamed-1/Spring-Rest-API-CRUD-App.git
 
   ```
2. **Set Up MySQL Database with Docker**:
   - Start a MySQL container using Docker:
     ```bash
     docker container run -d --name mysqldatabase -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root mysql:latest
      ```
3. **Build the Project**:
   - Use Maven to build the project:
     ```bash
     mvn clean install
     ```

## Quick links
- API Documentation: `http://localhost:8080/swagger-ui/index.html#/`
- Base URL: `http://localhost:8080/api/v1`

## Core Technologies
- Java 17
- Spring Boot 3.4.4
- SpringDoc OpenAPI 2.7.0
- Spring data JPA
- MySQL Database
- Maven 

## API Documentation
### Proudct managment

```
GET /api/v1/product         # Get product by ID
PUT /api/v1/product         # Update proudct details
POST /api/v1/product        # Create new proudct
DELETE /api/v1/product      # Delete product
GET /api/v1/products        # Get all proudcts
GET /api/v1/productDetails  # Get productDetails by product ID
```
![Swagger](https://github.com/user-attachments/assets/c411da83-5e70-4fe7-b0a3-fb1070f5fa3a)

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.