# 🛒 Terminal-Based E-Commerce Application

This project is a **terminal-based e-commerce system** developed using **Java**.  
It provides a simple yet functional structure where users can **register**, **log in**, **search for products**, and **place orders** — all through a text-based menu interface.

---

## 🧩 Project Purpose

The main goal of this project was to design and implement a **complete system architecture** that includes:
- User management  
- Password encryption  
- Product management  
- Order processing  

The system is built using **Java**, **PostgreSQL**, and **Maven**, focusing on maintainability and a real-world e-commerce flow.

---

## 🔐 User Operations

### 👤 Sign Up  
Users can register to the system with their **email** and **password**.  
Passwords are encrypted using the **SHA-256** algorithm before being stored in the database.

### 🔑 Log In  
Registered users can log into the system using their credentials.  
Invalid login attempts are handled with appropriate warning messages.

### 🚫 Orders Require Authentication  
Only authenticated users can create orders.  
This ensures that all purchase operations are performed securely.

---

## 🛍️ Product & Order Management

### 🔍 Product Search  
Users can search for products by name directly through the terminal.  
The system queries the database and returns all matching results.

### 🧾 Create Order  
Logged-in users can select desired products and create an order through the menu interface.

### 📦 Stock Tracking  
Each product includes a **stock quantity**.  
If a product is out of stock, the system prevents the user from placing an order — simulating a realistic shopping scenario.

---

## 🧭 Menu System

All user interactions are managed via a clear and user-friendly terminal menu.

Example Menu:
```text
1 - Sign Up
2 - Log In
3 - Search Product
4 - Create Order
5 - Exit
