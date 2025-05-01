# 📦 Container Routing Optimization API

A Java-based REST API to compute the optimal route plan for containers based on cost.

---

## 🧪 Features
- Accepts container source/destination and route costs
- Uses Dijkstra's algorithm to find the shortest path
- Returns optimized path and cost per container

---

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
