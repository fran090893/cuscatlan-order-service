# cuscatlan-order-service
The order microservice manages the creation, retrieval, and processing of orders, including integration with the product microservice for product information and order calculations.

## Features
- Create and retrieve orders.
- Integrates with the product microservice to get product details for order creation and total cost calculation.
- Request validation and error handling.
- Stores orders in an H2 database for local testing.

## Prerequisites
- Java 17
- Spring Boot 3.3.4
- Maven 3.x
- H2 Database (for local testing)

## Installation
1. Clone the repository:
   git clone https://github.com/fran090893/cuscatlan-order-service.git
2. Navigate to the project directory:
   cd productservice
3. Build the project with Maven:
   mvn clean install
4. Run the microservice:
   mvn spring-boot:run