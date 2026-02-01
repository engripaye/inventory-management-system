---

# 📦 Inventory Management System (Java + Spring Boot)

> **A production-style Inventory Management System built with modern Java and Spring Boot, focusing on clean architecture, real-world business rules, and recruiter-ready backend design.**

This project simulates how inventory systems are built in real companies — **not toy code**.
It demonstrates proper layering, transactional consistency, audit trails, and stock validation.

---

## 🚀 Tech Stack

* **Java 21**
* **Spring Boot 3.5+**
* Spring Web (REST APIs)
* Spring Data JPA
* MySQL
* Lombok
* Bean Validation (Jakarta Validation)
* Hibernate
* Docker (planned)
* Clean Layered Architecture

---

## 🎯 Key Features

✔ Product management (SKU-based)
✔ Warehouse / location management
✔ Inventory tracking per product per warehouse
✔ Inventory transactions:

* Inbound
* Outbound
* Adjustments
* Transfers

✔ Stock validation (no negative inventory allowed)
✔ Full audit trail of inventory movements
✔ Transactional consistency
✔ RESTful APIs
✔ Recruiter-friendly project structure

---

## 🧱 Project Architecture

This project follows a **clean layered architecture** similar to production systems:

```
controller  →  service  →  repository  →  database
```

### Package Structure

```
com.yourname.inventory
│
├── config
├── controller
├── service
├── repository
├── model
├── dto
└── exception
```

📌 This separation improves:

* maintainability
* testability
* scalability

---

## 🗂️ Core Domain Model

### Product

Represents an item tracked in inventory.

* Unique SKU
* Pricing
* Active flag
* Audit timestamps

### Warehouse

Represents a physical or logical storage location.

### Inventory

Tracks **current stock level per product per warehouse**
Enforced with a unique constraint.

### InventoryTransaction

Stores a **complete audit log** of all stock movements.

### Transaction Types

```java
INBOUND, OUTBOUND, ADJUSTMENT, TRANSFER_IN, TRANSFER_OUT
```

---

## 🧠 Business Logic Highlights

### Stock Integrity

* Inventory **can never go negative**
* All updates are transactional

### Transaction Processing

* Stock is calculated based on transaction type
* Each transaction is persisted for auditing
* Inventory is auto-created if missing

```java
@Transactional
public void processTransaction(...) {
    // calculate new stock
    // validate quantity
    // persist inventory
    // persist transaction audit
}
```

📌 This mirrors **real enterprise inventory systems**.

---

## 🔌 REST API Capabilities

* Create and manage products
* Register warehouses
* Perform inventory transactions
* Track inventory levels
* Audit all stock movements

📦 APIs are **Postman-ready** and designed with REST best practices.

---

## ⚙️ Configuration

### `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/inventory_db
    username: root
    password: password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

server:
  port: 8080
```

---

## 🧪 Validation & Error Handling

* Bean validation for request payloads
* Centralized exception handling
* Meaningful API error responses
* Business-rule enforcement at service layer

---

## 🐳 Docker Support (Planned)

Upcoming improvements:

* Dockerized Spring Boot service
* MySQL container
* `docker-compose.yml` for local setup

---

## 📈 Why This Project Stands Out

✔ Uses **modern Java (21)**
✔ Follows **real-world backend patterns**
✔ Demonstrates **business rule enforcement**
✔ Clean architecture & naming
✔ Not a tutorial clone
✔ Built like a **job-ready backend service**

---

## 🔜 Roadmap

* [ ] REST Controllers & DTOs
* [ ] Validation & global exception responses
* [ ] Sample API flows (Inbound / Outbound)
* [ ] Docker + MySQL
* [ ] Swagger / OpenAPI documentation
* [ ] Unit & integration tests

---

## 👨‍💻 Author

**Olabowale Babatunde Ipaye**
Backend / Full-Stack Java Developer
Focused on building clean, scalable, production-ready systems.

---

> **Next: Controllers** 🚀
