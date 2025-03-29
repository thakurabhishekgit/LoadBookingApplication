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

