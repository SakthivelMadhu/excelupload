# Excelupload

This is a Spring Boot project for uploading Excel files, processing the data, and storing it in a database.

## Features

- Upload Excel file through REST API
- Process Excel file and save data to the database
- Display data in a tabular format on the UI
- User authentication and CRUD operations on data
- Pagination, sorting, and error handling


## Features

### Data Validation
- File Type Validation: Only Excel files in the .xlsx format are allowed for upload.
- Field Data Type Validation: Ensure correct data types for each field in the Excel file (e.g., numeric, date).
- Error Handling: Capture and return errors for invalid data types or other issues during processing.

### UI Features
- User-friendly Interface: A clean and intuitive UI design for seamless interaction.
- Login Page: Authenticate users with login ID and password.
- CRUD Operations: Perform Create, Read, Update, and Delete operations on the data.
- Sorting: Allow users to sort data by different fields.
- Pagination: Display data in pages to improve readability and navigation.


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
│   │   │               │   ├── ExcelData.java
│   │   │               │   ├── FileUploadResponse.java
│   │   │               │   └── User.java
│   │   │               ├── service/
│   │   │               │   ├── ExcelUploadService.java
│   │   │               │   └── UserService.java
│   │   │               ├── repository/
│   │   │               │   ├── ExcelDataRepository.java
│   │   │               └── ExcelUploadApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
|   |               |__ styles.css
|   |               |__ scripts.js
│   │               └── index.html
│   │       └── templates/
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