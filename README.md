# 📦 Container Routing Optimization API

A Java-based REST API to compute the optimal route plan for containers based on cost.

---

## 🧪 Features
- Accepts container source/destination and route costs  
- Uses Dijkstra's algorithm to find the shortest path  
- Returns optimized path and cost per container

---

## 🌐 Live Deployment

This project is deployed and running on **Render**:  
🔗 **Live API URL:** [https://container-routing.onrender.com](https://container-routing.onrender.com)

You can test the API using tools like Postman or cURL.

---
## 🧪 API Testing

The API has been tested using **Postman** to ensure correct functionality.
## 🚀 API Endpoint

### `POST /api/optimize`

**Request Example:**

```json
{
  "containers": [
    { "id": 1, "source": "A", "destination": "C" }
  ],
  "routes": [
    { "from": "A", "to": "B", "cost": 2 },
    { "from": "B", "to": "C", "cost": 3 },
    { "from": "A", "to": "C", "cost": 10 }
  ]
}
```
**Response:**
```json
{
  "plan": [
    {
      "container_id": 1,
      "path": ["A", "B", "C"],
      "cost": 5
    }
  ],
  "total_cost": 5
}
```
![Screenshot 2025-05-01 174200](https://github.com/user-attachments/assets/abc4b31f-f2cc-4541-ab34-3b449eeec074)

