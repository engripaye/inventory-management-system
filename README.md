### 📦 Inventory Management System (Backend)

A production-style **Inventory Management System backend** built with **Java 21** and **Spring Boot 3**, designed to demonstrate real-world backend engineering skills including transactional integrity, clean architecture, and RESTful API design.

---

## 🚀 Features

* Product management
* Warehouse management
* Inventory tracking per warehouse
* Inventory transactions:

  * Inbound
  * Outbound
  * Adjustment
  * Transfers
* Stock validation (prevents negative inventory)
* Transaction audit trail
* Global exception handling
* Input validation
* Clean layered architecture

---

## 🛠 Tech Stack

* **Java 21**
* **Spring Boot 3**
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Lombok
* Maven

---

## 🧱 Architecture

```
Controller → Service → Repository → Database
```

Each layer has a clear responsibility:

* **Controller**: API contracts
* **Service**: Business logic & transactions
* **Repository**: Data access
* **Model**: Domain entities

---

## 🗄 Database Design (Core Tables)

* `product`
* `warehouse`
* `inventory`
* `inventory_transaction`

Inventory is uniquely tracked by:

```
(product_id + warehouse_id)
```

---

## 🔁 Inventory Transaction Flow

1. Validate product and warehouse
2. Fetch or create inventory record
3. Apply transaction logic:

   * INBOUND → add stock
   * OUTBOUND → reduce stock
   * ADJUSTMENT → reset stock
4. Prevent negative stock
5. Persist transaction audit record

All operations are **atomic and transactional**.

---

## 📡 API Endpoints

### Products

```
POST   /api/products
GET    /api/products
GET    /api/products/{id}
```

### Warehouses

```
POST   /api/warehouses
GET    /api/warehouses
GET    /api/warehouses/{id}
```

### Inventory Transactions

```
POST   /api/inventory/transaction
```

---

## 📥 Sample Inventory Transaction Request

```json
{
  "productId": 1,
  "warehouseId": 1,
  "transactionType": "INBOUND",
  "quantity": 50,
  "reference": "Initial stock"
}
```

---

## ⚙️ Configuration

Update `application.yml` with your MySQL credentials:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/inventory_db
    username: root
    password: password
```

---

## ▶️ How to Run

1. Clone the repository
2. Create MySQL database `inventory_db`
3. Run the application:

   ```bash
   mvn spring-boot:run
   ```
4. Test APIs using Postman

---

## 🎯 Purpose of This Project

This project was built to demonstrate:

* Backend system design
* Transactional business logic
* Clean code practices
* Enterprise-ready Spring Boot development

---

## 👤 Author

**Olabowale**
Junior Backend Developer (Java & Spring Boot)

---

You’re no longer “just applying”.
You’re building leverage now. 💪
