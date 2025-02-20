# CSY2094PSA2-PFM-Java

#Author
**Toheeb A. Husain**
[GitHub Profile](https://github.com/toheeb-orelope)
[Linkedin Profile](https://www.linkedin.com/in/toheeb-ajala-husain-a9110b255/)

# Personal Financial Manager (PFM)

## Overview

Personal Financial Management (PFM) is a web-based financial management application designed to help users track and analyze their income and expenses over time. The application provides interactive charts, allowing users to gain insights into their financial patterns and make informed decisions.

## Features

- **Income & Expense Tracking** – Users can add, modify, and delete income and expense records.
- **Financial Monitoring** – Compare financial data across multiple months.
- **Data Visualization** – Generate graphical charts for financial analysis.
- **User Flexibility** – Full control over financial records.
- **Secure Data Storage** – MySQL database for persistent data management.
- **Responsive UI** – Built with Angular for a seamless user experience.

## Technologies Used

### **Frontend**

- Angular
- Chart.js (for data visualization)

### **Backend**

- Java (Spring Boot)
- MySQL (Database)
- JPA (Java Persistence API)

### **Development Tools**

- Maven (Dependency Management)
- Postman (API Testing)
- IntelliJ IDEA (Backend Development)
- Visual Studio Code (Frontend Development)

## Installation & Setup

### Prerequisites

Ensure you have the following installed:

- **Node.js (16+)**
- **Angular CLI** (`npm install -g @angular/cli`)
- **MySQL Server**
- **Java JDK 17+**
- **IntelliJ IDEA & Visual Studio Code**

### **1. Clone the Repository**

````sh
git clone https://github.com/toheeb-orelope/CSY2094PSA2-PFM-Java

## Setup Backend (Spring Boot)
1. Open the `PersonalFinancialManagement` project in IntelliJ IDEA.
2. Update `src/main/resources/application.properties` with your MySQL credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/pfmapplication
   spring.datasource.username=your-username
   spring.datasource.password=your-password

3.  Run the backend server: mvn spring-boot:run

##  Setup Frontend (Angular)
Navigate to the frontend directory:
navigate to PFMAPP1
Install dependencies:
npm install
Start the frontend server:
ng serve or nmp start
Open the app in your browser: http://localhost:4200

##  Usage
Add Income & Expenses – Navigate to the dashboard and input financial records.
View Reports – Analyze financial trends with interactive charts.
Modify & Delete Records – Update or remove financial entries as needed.

##  Future Enhancements
1.  AI-driven financial insights
2.  Multi-user support
3.  Mobile app integration
4.  Bank API synchronization

## License
This project is licensed under the MIT License.
````
