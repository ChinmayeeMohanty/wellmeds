# 🩺 WellMed – Tele Medical E-Commerce Platform

##  Overview

**WellMed** is a full-stack medical e-commerce web application developed using **Java 17, Spring Boot, MongoDB, Thymeleaf, and Spring AI**. The application allows users to browse medicines and supplements, search products, manage a shopping cart, book doctor appointments, receive email confirmations, make secure online payments using Razorpay, and get AI-powered medicine recommendations powered by Google Gemini.

The project follows a **Layered Architecture (Controller → Service → Repository)** and was developed using the **Agile Software Development Methodology**, where the application was built incrementally by implementing and testing features in small iterations.

---

# Features

## 💊 Medicine & Supplement Management

- Browse medicines and supplements
- View product details
- Add new products (Admin)
- Update products (Admin)
- Delete products (Admin)

---

## 🛒 Shopping Cart

- Add products to cart
- Remove products from cart
- Update quantity
- Automatic total calculation

---

## 📅 Doctor Appointment Booking

- Book doctor appointments
- Store appointment details in MongoDB
- Generate appointment ticket
- Send appointment confirmation email automatically

---

## 🤖 AI Medicine Recommendation

- Integrated Google Gemini using Spring AI
- Accepts user symptoms
- Retrieves available medicines from MongoDB
- Sends product data to Gemini
- Recommends the best available medicine

---

## 💳 Razorpay Payment Integration

- Implemented Razorpay Checkout

---

## 📧 Email Notification

- Sends appointment confirmation email
- Includes appointment details
- Implemented using Spring Mail

---

## 🔍 Product Search

- Search medicines by keyword
- Case-insensitive search

---

## 🐳 Docker Support

- Dockerized Spring Boot application
- Docker Compose for multi-container deployment

---

## ⚙️ CI/CD Pipeline

- GitHub Actions
- Automatic Maven Build
- JAR generation
- SCP deployment to AWS EC2
- Restart application using systemctl

---

# 🏗️ Software Development Methodology

## Agile Methodology

This project was developed using the **Agile Software Development Methodology**.

Instead of building the complete application at once, the project was divided into small iterations. Each iteration focused on implementing one feature, testing it, and then moving to the next feature.

### Agile Development Flow

1. Requirement Analysis
2. Sprint Planning
3. Feature Development
4. Unit Testing
5. Review & Feedback
6. Deployment
7. Repeat for Next Sprint


### Sprint 1

- Project Setup
- MongoDB Configuration
- Product CRUD

### Sprint 2

- Doctor Module
- Appointment Booking

### Sprint 3

- Shopping Cart

### Sprint 4

- Razorpay Integration

### Sprint 5

- Email Notification

### Sprint 6

- AI Medicine Recommendation

### Sprint 7

- Dockerization
- AWS Deployment
- GitHub Actions CI/CD

---

# 🏛️ Project Architecture

```
                Browser

                   │

                   ▼

             Thymeleaf Views

                   │

                   ▼

             Controller Layer

                   │

                   ▼

              Service Layer

                   │

                   ▼

            Repository Layer

                   │

                   ▼

            MongoDB Database
```

The project follows a **Layered Architecture**, where:

- Controllers handle HTTP requests.
- Services contain business logic.
- Repositories communicate with MongoDB.
- MongoDB stores application data.

---

# 🛠️ Technology Stack

## Backend

- Java 17
- Spring Boot
- Spring MVC
- Spring Data MongoDB
- Spring AI
- Spring Mail
- Maven

## Frontend

- Thymeleaf
- HTML5
- CSS3
- JavaScript
- Bootstrap

## Database

- MongoDB Compass

## AI

- Google Gemini
- Spring AI

## Payment Gateway

- Razorpay

## DevOps

- Docker
- Docker Compose
- GitHub Actions
- AWS EC2


## Version Control

- Git
- GitHub

---


# ▶️ Running the Project

## Clone Repository

```bash
git clone ahttps://github.com/ChinmayeeMohanty/wellmeds
```

---

## Build

```bash
mvn clean package
```

---

## Run

```bash
mvn spring-boot:run
```

or

```bash
java -jar target/WellMed.jar
```

---

## Docker

```bash
docker compose up --build
```

---

# 📚 Spring Boot Concepts Used

- Spring Boot
- Spring MVC
- Dependency Injection (DI)
- IoC Container
- REST APIs
- Spring Data MongoDB
- Query Derivation
- Thymeleaf
- Spring AI
- Spring Mail
- Spring Security Authentication & Authorization
- Role-Based Access Control
- Admin Dashboard
- Exception Handling
- Layered Architecture

---

# 🎯 Key Learnings

- Layered Architecture
- MongoDB Integration
- Spring Data MongoDB
- AI Integration using Spring AI
- Razorpay Payment Gateway
- Spring Mail
- Docker & Docker Compose
- GitHub Actions CI/CD
- AWS EC2 Deployment
- Secure Environment Variable Management

---

# 🚀 Future Enhancements

- JWT Authentication
- Order History
- Inventory Management
- Product Reviews & Ratings
- OTP Verification
- Doctor Availability Scheduling
- Payment History
- Cloud Storage for Images

---

# 👩‍💻 Author

**Chinmayee Mohanty**

**Java Full Stack Developer**

### Skills

- Java
- Spring Boot
- Spring MVC
- REST APIs
- MongoDB
- MySQL
- Thymeleaf
- HTML
- CSS
- JavaScript
- Docker
- AWS EC2
- Git
- GitHub
- GitHub Actions
- Spring AI
- Razorpay
- Spring Mail

---

# ⭐ Project Highlights

- AI-powered medicine recommendation using Google Gemini
- Secure Razorpay payment integration
- Doctor appointment booking
- Automatic email notifications
- Shopping cart implementation
- MongoDB database
- Dockerized application
- CI/CD with GitHub Actions
- AWS EC2 deployment
- Agile Software Development Methodology
- Layered Architecture
- Clean, modular, and maintainable code

---

# 📄 License

This project is created for learning, portfolio, and demonstration purposes.