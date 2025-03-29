# Load Booking System

## Objective
Develop a backend system using **Spring Boot** and **PostgreSQL** to manage **Load & Booking** operations efficiently. The system is designed for **performance, security, and scalability**.

---
## 🚀 Scope of Work
- Implement **REST APIs** for managing loads and bookings with full **CRUD operations**.
- Ensure **robust error handling, validation, and logging**.
- Maintain **status integrity** across load and booking operations.

---
## 📜 API Specifications

### 📦 **Load Entity**
```json
{
    "id": "2b7f8964-4832-420d-a877-a0bf284fe34f",
    "shipperId": "1234588",
    "loadingPoint": "Hyderabad",
    "unloadingPoint": "Delhi",
    "loadingDate": "2024-03-29T08:00:00",
    "unloadingDate": "2024-03-30T18:00:00",
    "productType": "Steel",
    "truckType": "Open plane",
    "noOfTrucks": 2,
    "weight": 1500.5,
    "comment": "Urgent shipment",
    "datePosted": "2024-03-28T10:00:00",
    "status": "POSTED"
}

```
#### ✅ **Rules:**
- The `status` should default to **POSTED** when a load is created.
- When a **booking is made**, the load status changes to **BOOKED**.
- If a booking is **deleted**, the load status changes to **CANCELLED**.

---
### 📑 **Booking Entity**
```json
{
  "id": "bc54ed55-f7e6-408f-b75e-a7b08ae813c9",
  "load": {
    "id": "2b7f8964-4832-420d-a877-a0bf284fe34f",
    "shipperId": "1234588",
    "loadingPoint": "Hyderabad",
    "unloadingPoint": "Delhi",
    "loadingDate": "2024-03-29T08:00:00",
    "unloadingDate": "2024-03-30T18:00:00",
    "productType": "Steel",
    "truckType": "Open plane",
    "noOfTrucks": 2,
    "weight": 1500.5,
    "comment": "Urgent shipment",
    "datePosted": "2024-03-28T10:00:00",
    "status": "POSTED"
  },
  "transporterId": "67890",
  "proposedRate": 50000.0,
  "comment": "Can deliver in 24 hours",
  "requestedAt": "2024-03-28T11:30:00",
  "status": "PENDING"
}


```
#### ✅ **Rules:**
- A **booking should not be created** if the load is already **CANCELLED**.
- When a **booking is accepted**, update the status to **ACCEPTED**.

---
## 🔹 API Endpoints

### **Load Management**
| Method | Endpoint | Description |
|--------|----------|-------------|
| **POST** | `load` | Create a new load |
| **GET** | `load` | Fetch all loads |
| **GET** | `load/{id}` | Get load details by ID |
| **PUT** | `load{id}` | Update load details |
| **DELETE** | `load{id}` | Delete a load |

### **Booking Management**
| Method | Endpoint | Description |
|--------|----------|-------------|
| **POST** | `Booking` | Create a new booking |
| **GET** | `Booking` | Fetch all bookings |
| **GET** | `Booking/{id}` | Get booking details by ID |
| **DELETE** | `Booking/{id}` | Delete a booking |

---
## 🛠️ **Setup & Installation**
### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/thakurabhishekgit/LoadBookingApplication/tree/master
cd loadbooking
```
### **2️⃣ Configure Database**
Update the `src/main/resources/application.properties` file with your **PostgreSQL** credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/loadbooking
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
```

### **3️⃣ Build & Run the Project**
```sh
mvn clean install
mvn spring-boot:run
```

### **4️⃣ API Testing**
Use **Postman** or **cURL** to test the API endpoints.

---
## 📌 **Project Structure**
```
loadbooking/
│── src/
│   ├── main/
│   │   ├── java/com/example/loadbooking/
│   │   │   ├── controller/  # Contains API controllers
│   │   │   ├── entity/      # Database entity models
│   │   │   ├── service/     # Business logic
│   │   │   ├── repository/  # Data access layer
│   │   │   ├── LoadbookingApplication.java # Main entry point
│   ├── resources/
│   │   ├── application.properties  # App configuration
│── pom.xml  # Maven dependencies
│── README.md  # Documentation
```

---


