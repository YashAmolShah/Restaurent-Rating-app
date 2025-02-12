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
- **Add Restaurant:** `POST /Restaurant/add`
- **Add Customer:** `POST /Customer/add`
- **Add Rating:** `POST /Rating/{customerId}/add/{restaurantName}`
- **Get All Ratings:** `GET /ratings`
- **Get All Customers:** `GET /customers`
- **Get Customers by Restaurant:** `GET /customers/restaurant/{restaurantName}`
- **Get Customers by Rating:** `GET /customers/restaurant/{restaurantName}/{rating}`
- **Get Restaurant Average Rating:** `GET /restaurant/{restaurantName}/average`



🛠 Tech Stack
Backend: Java, Spring Boot

Database: MySQL / PostgreSQL

Tools: IntelliJ / VS Code, Postman, GitHub

🏗️ Future Enhancements
✅ Implement authentication using Spring Security

✅ Add pagination & sorting for large datasets

✅ Integrate Swagger UI for better API documentation
