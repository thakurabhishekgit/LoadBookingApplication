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




# API Documentation: Load & Booking Management System

This backend system manages **Load** and **Booking** operations efficiently using **Spring Boot** and **PostgreSQL**.

---

## Load Management APIs

### 1. Create a Load  
**Endpoint:** `POST /load`  
**Request Body:**
```json
{
  "shipperId": "SHIP123",
  "facility": {
    "loadingPoint": "Mumbai",
    "unloadingPoint": "Delhi",
    "loadingDate": "2024-04-01T10:00:00",
    "unloadingDate": "2024-04-02T12:00:00"
  },
  "productType": "Electronics",
  "truckType": "Trailer",
  "noOfTrucks": 2,
  "weight": 1000.0,
  "comment": "Fragile items, handle with care"
}
```
**Response (201 Created):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "shipperId": "SHIP123",
  "facility": {
    "loadingPoint": "Mumbai",
    "unloadingPoint": "Delhi",
    "loadingDate": "2024-04-01T10:00:00",
    "unloadingDate": "2024-04-02T12:00:00"
  },
  "productType": "Electronics",
  "truckType": "Trailer",
  "noOfTrucks": 2,
  "weight": 1000.0,
  "comment": "Fragile items, handle with care",
  "datePosted": "2024-03-29T08:00:00",
  "status": "POSTED"
}
```

### 2. Get All Loads  
**Endpoint:** `GET /load`  
**Response (200 OK):**
```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "shipperId": "SHIP123",
    "facility": {
      "loadingPoint": "Mumbai",
      "unloadingPoint": "Delhi",
      "loadingDate": "2024-04-01T10:00:00",
      "unloadingDate": "2024-04-02T12:00:00"
    },
    "productType": "Electronics",
    "truckType": "Trailer",
    "noOfTrucks": 2,
    "weight": 1000.0,
    "comment": "Fragile items, handle with care",
    "status": "POSTED"
  }
]
```

### 3. Get Load by ID  
**Endpoint:** `GET /load/{loadId}`  
**Response (200 OK):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "shipperId": "SHIP123",
  "facility": {
    "loadingPoint": "Mumbai",
    "unloadingPoint": "Delhi",
    "loadingDate": "2024-04-01T10:00:00",
    "unloadingDate": "2024-04-02T12:00:00"
  },
  "productType": "Electronics",
  "truckType": "Trailer",
  "noOfTrucks": 2,
  "weight": 1000.0,
  "comment": "Fragile items, handle with care",
  "status": "POSTED"
}
```

### 4. Update Load Details  
**Endpoint:** `PUT /load/{loadId}`  
**Request Body:**
```json
{
  "truckType": "Container",
  "weight": 1200.0
}
```
**Response (200 OK):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "shipperId": "SHIP123",
  "facility": {
    "loadingPoint": "Mumbai",
    "unloadingPoint": "Delhi",
    "loadingDate": "2024-04-01T10:00:00",
    "unloadingDate": "2024-04-02T12:00:00"
  },
  "productType": "Electronics",
  "truckType": "Container",
  "noOfTrucks": 2,
  "weight": 1200.0,
  "comment": "Fragile items, handle with care",
  "status": "POSTED"
}
```

### 5. Delete Load  
**Endpoint:** `DELETE /load/{loadId}`  
**Response (204 No Content)**
```json
{}
```

## Booking Management APIs

### 6. Create a Booking  
**Endpoint:** `POST /booking`  
**Request Body:**
```json
{
  "loadId": "550e8400-e29b-41d4-a716-446655440000",
  "transporterId": "67890",
  "proposedRate": 50000.0,
  "comment": "Can deliver in 24 hours"
}
```
**Response (201 Created):**
```json
{
  "id": "bc54ed55-f7e6-408f-b75e-a7b08ae813c9",
  "loadId": "550e8400-e29b-41d4-a716-446655440000",
  "transporterId": "67890",
  "proposedRate": 50000.0,
  "comment": "Can deliver in 24 hours",
  "status": "PENDING"
}
```

### 7. Get All Bookings  
**Endpoint:** `GET /booking`  
**Response (200 OK):**
```json
[
  {
    "id": "bc54ed55-f7e6-408f-b75e-a7b08ae813c9",
    "loadId": "550e8400-e29b-41d4-a716-446655440000",
    "transporterId": "67890",
    "proposedRate": 50000.0,
    "comment": "Can deliver in 24 hours",
    "status": "PENDING"
  }
]
```

### 8. Update Booking Status  
**Endpoint:** `PUT /booking/{bookingId}/status`  
**Request Body:**
```json
{
  "status": "ACCEPTED"
}
```
**Response (200 OK):**
```json
{
  "id": "bc54ed55-f7e6-408f-b75e-a7b08ae813c9",
  "loadId": "550e8400-e29b-41d4-a716-446655440000",
  "transporterId": "67890",
  "proposedRate": 50000.0,
  "comment": "Can deliver in 24 hours",
  "status": "ACCEPTED"
}
```

### 9. Delete Booking  
**Endpoint:** `DELETE /booking/{bookingId}`  
**Response (204 No Content)**
```json
{}
```

# Rules Implemented
- A booking cannot be created if the load is CANCELLED.
- When a booking is accepted, the status updates to ACCEPTED.
- When a booking is deleted, the load status resets to POSTED.

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
|   |   |   |---Exceptions #handles the exceptions of apis
│   ├── resources/
│   │   ├── application.properties  # App configuration
│── pom.xml  # Maven dependencies
│── README.md  # Documentation
```

---


