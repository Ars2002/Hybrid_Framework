# Hybrid Framework

## Overview
This project is a robust and scalable **Hybrid Framework** for automation testing, developed using **Java**, **Selenium**, and **Maven**. It incorporates industry-standard design patterns and tools like **TestNG**, **Page Object Model (POM)**, **Extent Reports**, and various utility classes to ensure efficient and maintainable test automation.

---

## Features
- **Selenium WebDriver**: For browser automation.
- **Maven**: For build management and dependency management.
- **TestNG**: For test case management and execution.
- **Page Object Model (POM)**: For maintaining modular and reusable code.
- **Listener Class**: To enhance reporting by capturing test execution details.
- **Extent Reports**: Integrated with screenshots for detailed reporting.
- **Excel Utility**: To read input data from Excel files dynamically.
- **Cross-Browser Testing**: Configurable to run on multiple browsers.

---

## Project Structure
```
Hybrid_Framework/
|
|-- src/main/java/
|   |-- base/                # Base classes for WebDriver initialization
|   |-- listeners/           # Listener classes for enhanced reporting
|   |-- pages/               # Page Object Model (POM) classes
|   |-- utils/               # Utility classes (e.g., Excel utilities)
|
|-- src/test/java/
|   |-- testcases/           # Test case classes
|
|--target/
|   |-- screenshots/            # Captured screenshots for failed test cases
|-- reports/                # Generated Extent Reports
|-- pom.xml                 # Maven configuration file
```

---

## Prerequisites
- **Java**: JDK 8 or higher
- **Maven**: Installed and configured
- **IDE**: IntelliJ IDEA, Eclipse, or any Java IDE
- **Browser Drivers**: Ensure WebDriver binaries (e.g., ChromeDriver) are properly set up

---

## How to Set Up and Run

### Clone the Repository
```bash
git clone https://github.com/Ars2002/Hybrid_Framework.git
cd Hybrid_Framework
```

### Install Dependencies
```bash
mvn clean install
```

### Configure Test Data
1. Place your test data in the designated Excel file.
2. Update the file path in the configuration utility.

### Run Tests
```bash
mvn test
```

### Generate Reports
1. After execution, navigate to the `target/` directory.
2. Open the **Extent Report** HTML file to view detailed test execution results with screenshots.

---

## Key Components

### 1. **Base Class**
- Centralized WebDriver initialization.
- Configures browser settings and implicit waits.

### 2. **Page Object Model (POM)**
- Encapsulates UI elements and interactions in individual page classes.
- Improves code readability and reusability.

### 3. **Listener Class**
- Captures test start, pass, fail, and skip events.
- Generates Extent Reports with detailed logs.

### 4. **Extent Reports**
- Beautiful and detailed HTML reports.
- Includes screenshots for failed test cases.

### 5. **Excel Utility**
- Reads input data dynamically from Excel files.
- Supports test data-driven testing.

---

## Tools and Technologies Used
- **Programming Language**: Java
- **Automation Framework**: Selenium WebDriver
- **Build Tool**: Maven
- **Test Framework**: TestNG
- **Reporting**: Extent Reports

---

## Future Enhancements
- Integration with **CI/CD tools** like Jenkins for continuous testing.
- Adding support for **API testing**.
- Implementation of parallel execution for improved efficiency.

---

## Author
Developed by **Ars2002**.


