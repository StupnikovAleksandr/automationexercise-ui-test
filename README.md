# Automation Exercise UI Tests

![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Selenide](https://img.shields.io/badge/Selenide-UI%20Testing-4B9CD3)
![JUnit 5](https://img.shields.io/badge/JUnit-5-25A162?logo=junit5)
![Gradle](https://img.shields.io/badge/Gradle-Build%20Tool-02303A?logo=gradle)
![License](https://img.shields.io/badge/License-MIT-blue)

A UI test automation project for [Automation Exercise](https://automationexercise.com/) built with **Java, Selenide, JUnit 5, and Gradle**.

The project demonstrates a clean and maintainable approach to UI test automation using the **Page Object Model (POM)** pattern.

## ✨ What is covered

The test suite includes the following user scenarios:

* User registration
* Login with valid credentials
* Login with invalid credentials
* Registration with an existing email
* User logout
* Account deletion
* Additional UI scenarios

## 🛠 Tech Stack

| Technology            | Purpose                         |
| --------------------- | ------------------------------- |
| **Java**              | Programming language            |
| **Selenide**          | UI test automation              |
| **JUnit 5**           | Test framework                  |
| **Gradle**            | Build and dependency management |
| **Page Object Model** | Test architecture               |

## 🏗 Architecture

The project follows the **Page Object Model** approach, separating page interactions from test logic.


Test data is stored separately to keep the test code clean, readable, and reusable.

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/StupnikovAleksandr/automationexercise-ui-tests.git
cd automationexercise-ui-tests
```

### Run all tests

Linux / macOS:

```bash
./gradlew test
```

Windows:

```bash
gradlew.bat test
```

## 📊 Test Reports

After the test execution, Gradle generates an HTML test report:

```text
build/reports/tests/test/index.html
```

Open `index.html` in a browser to review the test results.

## 📁 Project Overview

```text
src/
└─ main/
        └── pages
        └── dataHelper
└── test/
    └── java/
```

The project structure keeps page objects, tests, and test data separated, making the test suite easier to maintain and extend.

## 🎯 Project Goals

This project was created to practice and demonstrate:

* UI test automation with Java
* Selenide
* JUnit 5
* Page Object Model
* Test data management
* Gradle-based test execution
* Writing maintainable and readable automated tests

## 🌐 Application Under Test

**Automation Exercise**

https://automationexercise.com/

## 📌 Future Improvements

Possible improvements for the project:

* Add CI/CD with GitHub Actions
* Add Allure test reporting
* Introduce test configuration via properties
* Add screenshots and videos for failed tests
* Expand test coverage
* Add parallel test execution
* Improve test data generation

---

**Built for learning, practicing, and improving UI test automation skills.**
