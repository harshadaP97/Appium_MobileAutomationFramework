# Appium Mobile Automation Framework

A hybrid automation framework built using **Java**, **TestNG**, and **Appium** for testing Android mobile applications. The project follows modular design principles with a strong focus on reusability, maintainability, and reporting.

---

## 🔧 Tech Stack

- **Java** + **TestNG**
- **Appium** for mobile automation
- **ExtentReports** for HTML reports
- **Console Logs** for terminal-level test insights
- **Apache POI** for reading test data from Excel
- **Maven** for build and dependency management
- **Page Object Model** for code structure

---

## ✅ Features

- **Data-Driven Testing:** Fetches login and other input data from an external Excel file
- **Configurable Setup:** Uses `config.properties` for device, app, and environment settings
- **Reusable Utilities:**
  - `ScrollUtil`, `WaitUtil`, `ScreenshotUtil`, etc.
  - Centralized Excel handling with `TestDataUtil`
- **Screenshots on Failure:** Automatically captures screenshots for failed test cases
- **Extent Reports:** Test steps and status are logged into an interactive HTML report
- **Console Logs:** Lightweight feedback during test execution

---

## 📂 Project Structure

├── src
│ ├── main
│ │ ├── java/com/mobile/base/ → TestBase class with setup/teardown
│ │ ├── java/com/mobile/pages/ → Page classes using Page Object Model
│ │ ├── java/com/mobile/util/ → Reusable utility classes
│ │ └── java/com/mobile/config/ → config.properties
│ ├── test
│ │ └── java/com/mobile/test/ → Test classes using TestNG
│
├── testng.xml → TestNG suite configuration
├── pom.xml → Maven dependencies and config
├── UserLoginData.xlsx → Excel test data
├── Reports/ → Sample Extent Reports (generated)
├── screenshots/ → Failure screenshots (generated)

## 🚀 How to Run

1. Connect your Android device or emulator
2. Update device/app details in `config.properties`
3. Run tests via your IDE or:

```bash
mvn clean test

📸 Sample Output
TestNG Console Logs
Extent HTML Report with test steps
Captured Screenshots for failed scenarios

This framework is built to simulate real-world QA automation project structures and workflows.
