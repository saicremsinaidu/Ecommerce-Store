# 🛒 Ecommerce-Store

A full-stack E-commerce application featuring a robust **Java Spring Boot** backend and a dynamic **React** frontend. This project demonstrates a complete CRUD flow for managing products, handling carts, and processing orders.

## 🏗️ Project Architecture

### Backend (Spring Boot)
The backend follows a layered architecture for scalability and maintainability:
- **Controllers**: Handles REST API endpoints (e.g., `ProductController.java`, `OrderController.java`).
- **Services**: Contains business logic (e.g., `ProductService.java`).
- **Repositories**: Manages database interactions using Spring Data JPA.
- **Models/DTOs**: Defines data structures for products and orders.

### Frontend (React)
A component-based UI built with React:
- **Core Components**: `Navbar.jsx`, `Cart.jsx`, `Home.jsx`.
- **Product Features**: `AddProduct.jsx`, `UpdateProduct.jsx`, and `SearchResults.jsx`.
- **Checkout**: `CheckoutPopup.jsx` for a streamlined user experience.

---

## 🛠️ Tech Stack

**Frontend:**
- React.js (JSX)
- CSS/Markdown for styling (`OrderStyles.md`)

**Backend:**
- Java & Spring Boot
- Spring Data JPA
- **PostgreSQL** (Database)

---

## 🚀 Getting Started

### 1. Database Configuration (PostgreSQL)
Ensure you have PostgreSQL installed and running. Update your `src/main/resources/application.properties` file:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
