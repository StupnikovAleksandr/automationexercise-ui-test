# automationexercise-ui-test

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
git clone https://github.com/StupnikovAleksandr/automationexercise-ui-test.git
cd automationexercise-ui-test
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


## UI case coverage

The suite implements [Automation Exercise test cases 1?26](https://automationexercise.com/test_cases).
Page objects remain in `src/main/java/pages`, data factories in `dataHelper`,
and tests in `src/test/java`. Shared navigation is in `BasePage`; reusable
product-list and subscription controls are in `pages/components`.

| Test class | Case numbers |
| --- | --- |
| RegistrationTest | 1, 5 |
| LoginTest | 2, 3, 4 |
| ContactTest | 6 |
| NavigationTest | 7 |
| ProductTest | 8, 9, 18, 19, 21 |
| SubscriptionTest | 10, 11 |
| CartTest | 12, 13, 17, 20, 22 |
| CheckoutTest | 14, 15, 16, 23, 24 |
| ScrollTest | 25, 26 |

Each test starts with a fresh browser session. Account scenarios create their
own user through the UI and delete that user during the scenario or teardown.
The shared hardcoded account is not used by this suite.

Run all cases in headless Chrome on Windows:

```powershell
.\gradlew.bat test "-Dheadless=true"
```

Run one group:

```powershell
.\gradlew.bat test --tests CartTest "-Dheadless=true"
```

`-DbaseUrl=https://automationexercise.com` overrides the target URL.
Tests need internet access and Chrome. They submit practice reviews/contact
forms and simulated orders to the demonstration site. The contact attachment
is in `src/test/resources`; downloaded invoices are stored under `build`.

The live payment confirmation currently displays `ORDER PLACED!` and
`Congratulations! Your order has been confirmed!`; these are checked instead
of the older success wording in the published cases.
