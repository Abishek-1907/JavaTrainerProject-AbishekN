

# Smart Training Platform – Java Trainer Machine Test

A Spring Boot RESTful application to manage Students, Trainers, and Batches with custom trainer allocation and batch recommendation logic.

---

## Project Features

- Add Students, Trainers, and Batches
- Assign best-suited Trainer to Batch (greedy algorithm)
- Recommend best Batch to Student (preference logic)
- REST API with validation and exception handling
- Dockerized for deployment on Render

---

## Render Deployment Instructions

1. Push your code to GitHub
2. Go to [https://render.com](https://render.com) and sign in
3. Click **New Web Service** → Select your GitHub repository
4. Choose:
   - **Environment**: Docker
   - **Name**: abishek-machine-test
   - **Branch**: master
   - **Root Directory**: (leave empty)
   - **Port**: 8080
5. Render will auto-detect the Dockerfile and build

### Live Render URL
https://abishek-machine-test.onrender.com

---

## Teaching Explanation

### 1. What is Dependency Injection?
Dependency Injection is when Spring automatically provides required dependencies (like services) into your classes. We use `@RequiredArgsConstructor` to inject services into controllers.

### 2. How did you implement Trainer Assignment?
We filter trainers by subject match, exclude overlapping batches, and pick the one with the best rating and lowest current workload. It's a greedy algorithm using sorting and filtering.

### 3. Why this Architecture?
The project uses a clean layered architecture: controller → service → repository → model. Business logic and API layers are separated for clarity and testability.

---

## 📡 Sample API Calls

### Add Student
```http
POST /api/students
Content-Type: application/json

{
  "name": "abi",
  "email": "john@example.com",
  "phone": "9876543210",
  "dateOfBirth": "2000-01-15",
  "previousCourses": ["OOP", "Core Java"],
  "appliedSubject": "Java"
}
```

### Add Trainer
```http
POST /api/trainers
Content-Type: application/json

{
  "name": "Ravi Kumar",
  "subjectExpertise": ["Java", "Spring"],
  "rating": 4.7,
  "yearsOfExperience": 5,
  "availabilityPeriods": ["July", "August"]
}
```

### Add Batch
```http
POST /api/batches
Content-Type: application/json

{
  "title": "Java Basics Batch A",
  "subject": "Java",
  "maxCapacity": 30,
  "startDate": "2025-07-01",
  "endDate": "2025-07-15"
}
```

### Assign Trainer
```http
POST /api/assign-trainer/1
```

### Recommend Batch to Student
```http
GET /api/recommend-batch/1
```

---

## Project Structure

```
trainingplatform/
├── controller
├── service
├── repository
├── model
├── dto
├── util
├── exception
├── Dockerfile
├── README.md
└── pom.xml
```

---

## Author
**Abishek Natarajan**
GitHub: https://github.com/Abishek-1907

---

