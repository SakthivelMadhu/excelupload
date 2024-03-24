package com.example.excelupload.controller;


import com.example.excelupload.service.*;
import com.example.excelupload.model.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class ExcelUploadController {
	
	
	private final UserService userService;

    @Autowired
    public ExcelUploadController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody User loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if (userService.authenticateUser(username, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadExcel(@RequestBody byte[] fileContent) {
        try {
            // Convert byte array to workbook
            Workbook workbook = new XSSFWorkbook(new ByteArrayInputStream(fileContent));

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row
            Iterator<Row> iterator = sheet.iterator();
            List<String> errors = new ArrayList<>();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();

                // Skip header row
                if (currentRow.getRowNum() == 0) {
                    continue;
                }

                // Process each cell in the row
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();

                    // Perform validation based on cell data type
                    switch (currentCell.getCellType()) {
                        case STRING:
                            // Handle string data type
                            String stringValue = currentCell.getStringCellValue();
                            // Perform additional validation if needed
                            break;
                        case NUMERIC:
                            // Handle numeric data type
                            double numericValue = currentCell.getNumericCellValue();
                            // Perform additional validation if needed
                            break;
                        case BOOLEAN:
                            // Handle boolean data type
                            boolean booleanValue = currentCell.getBooleanCellValue();
                            // Perform additional validation if needed
                            break;
                        default:
                            // Handle other data types if necessary
                            break;
                    }
                }
            }

            // Save data to database

            // Close the workbook
            workbook.close();

            // If no errors, return success response
            if (errors.isEmpty()) {
                return ResponseEntity.ok(new FileUploadResponse("File uploaded successfully"));
            } else {
                // If errors occurred, return error response
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Failed to process the uploaded file"));
        }
    }
}
