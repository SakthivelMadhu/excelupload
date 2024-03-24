# Excelupload

This is a Spring Boot project for uploading Excel files, processing the data, and storing it in a database.

## Features

- Upload Excel file through REST API
- Process Excel file and save data to the database
- Display data in a tabular format on the UI
- User authentication and CRUD operations on data
- Pagination, sorting, and error handling

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Web
- MySQL database
- Apache POI for Excel processing
- React JS (or equivalent) for the frontend UI

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 17
- MySQL database
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse, or Spring Tool Suite)

### Installation

1. Clone the repository:

```
https://github.com/SakthivelMadhu/excelupload
```

2. Import the project into your IDE.

3. Set up your MySQL database and update the `application.properties` file with your database configurations.

4. Run the application.

## Usage

- Access the API endpoints to upload Excel files and perform CRUD operations on the data.
- Access the UI to view the data in a tabular format and perform operations like sorting, pagination, and editing.

## project structure

```

Excelupload/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── excelupload/
│   │   │               ├── controller/
│   │   │               │   └── ExcelUploadController.java
│   │   │               ├── model/
│   │   │               │   ├── ErrorResponse.java
│   │   │               │   ├── FileUploadResponse.java
│   │   │               │   └── User.java
│   │   │               ├── service/
│   │   │               │   ├── ExcelUploadService.java
│   │   │               │   └── UserService.java
│   │   │               └── ExcelUploadApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
|   |               |__ styles.css
|   |               |__ scripts.js
│   │       └── templates/
│   │               └── index.html
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── excelupload/
│                       ├── controller/
│                       │   └── ExcelUploadControllerTest.java
│                       └── service/
│                           ├── ExcelUploadServiceTest.java
│                           └── UserServiceTest.java
└── pom.xml


```