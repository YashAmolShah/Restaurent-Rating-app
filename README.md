# 🍽️ Restaurant Rating App

## 📌 Overview
The **Restaurant Rating App** is a RESTful API built using **Spring Boot**, allowing customers to rate restaurants and track their visits. It manages three main entities:

- **Customer**: A user who can visit and rate restaurants.
- **Restaurant**: A place where customers can dine.
- **Rating**: A rating given by a customer to a restaurant.

---

## 🚀 Features
✔ Customers can **register** and **rate** restaurants.  
✔ Fetch all **ratings, customers, and restaurant details**.  
✔ Retrieve **customers who visited a restaurant** or rated it above a given score.  
✔ Compute the **average rating** of a restaurant.  

---

## 🔧 API Endpoints

### **📌 Customer APIs**
- **Add a new customer:**  
  ```http
POST /Customer/add

GET /customers

GET /customers/restaurant/{restaurantName}

GET /customers/restaurant/{restaurantName}/{rating}

POST /Restaurant/add

GET /restaurant/{restaurantName}/average

POST /Rating/{customerId}/add/{restaurantName}


🛠 Tech Stack
Backend: Java, Spring Boot

Database: MySQL / PostgreSQL

Tools: IntelliJ / VS Code, Postman, GitHub

🏗️ Future Enhancements
✅ Implement authentication using Spring Security

✅ Add pagination & sorting for large datasets

✅ Integrate Swagger UI for better API documentation
