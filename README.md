# ☕ CuppaBliss Coffee Shop Management System

A desktop-based Coffee Shop Management System developed using Java Swing, NetBeans, and MySQL. The system follows the Model-View-Controller (MVC) architecture to separate data management, user interface, and application logic, improving maintainability and scalability. It helps manage products and users with role-based access control for Managers and Baristas.
---

## 📌 Features

### 👨‍💼 Manager
- Secure Login
- Dashboard
- View Products
- View Low Stock Products
- Create Users

### ☕ Barista
- Secure Login
- Dashboard
- Add Products
- Update Products
- Delete Products
- Search Products
- View Products
- View Low Stock Products

---

## 🛠️ Technologies Used

- Java
- Java Swing
- NetBeans IDE
- MySQL
- JDBC

---

## 📂 Project Structure

```
cuppabliss/
│
├── src/
│   ├── controller/
│   ├── database/
│   ├── model/
│   ├── view/
│   └── main/
│
├── database(cuppabliss)/
    └── cuppabliss40.sql

```

---

## 🗄️ Database Setup

1. Open **MySQL**.
2. Create a new database.

```
cuppabliss40
```

3. Import the SQL file:

```
database(cuppabliss)/cuppabliss40.sql
```

---

## ⚙️ How to Run

### Requirements

- Java JDK 17 or later
- NetBeans IDE
- MySQL Server
- MySQL Connector/J (JDBC Driver)

### Steps

1. Clone the repository.

```bash
git clone https://github.com/SumuduVihanga1/CuppaBliss-Coffee-Shop-Management-System-JAVA.git
```

2. Open the project in NetBeans.

3. Import the database.

4. Configure the database connection in:

```
src/database/DBConnection.java
```

Example:

```java
String url = "jdbc:mysql://localhost:3306/cuppabliss40";
String username = "root";
String password = "";
```

5. Add the MySQL JDBC driver to the project libraries.

6. Build and Run the project.

---

## 📷 Screenshots

### Login
```
screenshots(cuppabliss)/login.png
```

### Manager Dashboard
```
screenshots(cuppabliss)/manager dashboard.png
```

### Barista Dashboard
```
screenshots(cuppabliss)/barista dashboard.png
```

### Product Management
```
screenshots(cuppabliss)/products.png
```

### Create User
```
screenshots(cuppabliss)/add user.png
```

---


---

## 📁 Database

The SQL file is included in the repository.

```
database(cuppabliss)/cuppabliss40.sql
```

---


---

## 👨‍💻 Author

**Sumudu Vihanga**

GitHub:
https://github.com/SumuduVihanga1

---

This project is created for educational purposes.
