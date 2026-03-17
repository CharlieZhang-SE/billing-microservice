
# Billing Microservice

## Overview

The **Billing Microservice** is a Spring Boot-based application for managing insurance policy billing. It includes functionality to:

- Retrieve premium schedules for policies.
- Record payment attempts and their results (success/failure).
- Manage delinquent policies.
- Trigger retry actions for failed payments.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Running the Application](#running-the-application)
- [Running Unit Tests](#running-unit-tests)
- [Testing the Endpoints](#testing-the-endpoints)
- [Directory Structure](#directory-structure)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

These instructions will help you set up and run the **Billing Microservice** on your local machine.

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/CharlieZhang-SE/billing-microservice.git
```

Navigate to the project directory:

```bash
cd billing-microservice
```

### 2. Install Dependencies

Ensure you have **Java 11+** and **Maven** installed. To install the required dependencies, run the following command:

```bash
mvn clean install
```

This command will download all necessary dependencies and compile the project.

### 3. Run the Application

To run the application locally, use the **Spring Boot Maven Plugin**:

```bash
mvn spring-boot:run
```

By default, the application will run on **port 8080**. You can interact with the following API endpoints:

- **GET** `/policies/{policyId}/schedule` – Retrieve the premium schedule for a policy.
- **POST** `/policies/{policyId}/payment` – Record a payment attempt for a policy.
- **GET** `/policies/delinquent` – Retrieve a list of delinquent policies.
- **POST** `/policies/{policyId}/retry` – Trigger retry for a failed payment.

### 4. Accessing the Application

You can use an **HTTP client** (like **Postman** or **cURL**) to interact with the APIs, or simply use a browser for **GET** requests.

## Prerequisites

To run the project, make sure the following are installed:

- **Java 11+** (You can check your Java version with `java -version`).
- **Maven** (for building the project and running tests).
- **IDE** (Optional but recommended, e.g., IntelliJ IDEA, Eclipse).
- **Git** (for version control).

## Running Unit Tests

Unit tests are written using **JUnit 5** and **Mockito** for mocking dependencies. To run all tests, use the following command:

```bash
mvn test
```

To run a specific test class, you can use this command:

```bash
mvn -Dtest=com.billing.controller.BillingControllerTest test
```

### Viewing Test Results

After running the tests, Maven generates a test report in the `target/surefire-reports` directory. You can open the files in this directory to see detailed test results.

For example, to view the test results of **BillingControllerTest**:

```bash
cd target/surefire-reports
cat com.billing.controller.BillingControllerTest.txt
```

## Testing the Endpoints

Here are the available endpoints with example usage.

### 1. **Get Premium Schedule for a Policy**

**Request**:

```bash
GET http://localhost:8080/policies/101/schedule
```

**Response**:

```json
{
  "message": "Premium schedule retrieved successfully",
  "data": {
    "policyId": 101,
    "premiumSchedule": [100, 100, 100],
    "delinquent": false
  }
}
```

### 2. **Record a Payment Attempt**

**Request**:

```bash
POST http://localhost:8080/policies/101/payment
Content-Type: application/json
Body:
{
  "status": "success",
  "amount": 100
}
```

**Response**:

```json
{
  "message": "Payment recorded successfully",
  "data": {
    "policyId": 101,
    "status": "success",
    "amount": 100
  }
}
```

### 3. **Get Delinquent Policies**

**Request**:

```bash
GET http://localhost:8080/policies/delinquent
```

**Response**:

```json
{
  "message": "Delinquent policies retrieved successfully",
  "data": [102]
}
```

### 4. **Trigger Retry for a Failed Payment**

**Request**:

```bash
POST http://localhost:8080/policies/102/retry
```

**Response**:

```json
{
  "message": "Retry triggered",
  "data": "Retry successfully initiated for policy 102"
}
```

## Directory Structure

Here’s an overview of the project structure:

```plaintext
/billing-microservice
├── /src
│   ├── /main
│   │   ├── /java
│   │   │   ├── /com
│   │   │   │   ├── /billing
│   │   │   │   │   ├── /controller      # REST controller classes (BillingController.java)
│   │   │   │   │   ├── /model           # Model classes (Payment.java, Policy.java, Response.java)
│   │   │   │   │   ├── /service          # Service classes (BillingService.java)
│   │   │   │   │   └── /BillingApplication.java  # Spring Boot application class
│   ├── /test
│   │   ├── /java
│   │   │   ├── /com
│   │   │   │   ├── /billing
│   │   │   │   │   ├── /controller      # Test classes for controllers (BillingControllerTest.java)
│   │   │   │   │   ├── /service         # Test classes for service (BillingServiceTest.java)
│   │   │   │   │   └── /model           # Test classes for models (ResponseTest.java)
├── pom.xml                                  # Maven configuration file
└── README.md                                # This file
```

## Contributing

Welcome contributions to the project! Follow the steps below to contribute:

1. Fork the repository on GitHub.
2. Create a new branch: `git checkout -b feature/your-feature`.
3. Commit your changes: `git commit -m 'Add your feature'`.
4. Push your changes to your branch: `git push origin feature/your-feature`.
5. Open a pull request to merge your changes.

## License

This project is licensed under the **MIT License**.
