package com.example.excelupload.controller;


import com.example.excelupload.service.*;
import com.example.excelupload.model.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api")
public class ExcelUploadController {
	
	
	private final UserService userService;
	
	@Autowired
	private ExcelUploadService excelUploadService;

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
                            String stringValue = currentCell.getStringCellValue();
                            break;
                        case NUMERIC:
                            double numericValue = currentCell.getNumericCellValue();
                            break;
                        case BOOLEAN:
                            boolean booleanValue = currentCell.getBooleanCellValue();
                            break;
                        default:
                            break;
                    }
                }
            }
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
    
    
    

    @PostMapping("/upload")
    public ResponseEntity<?> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        if (!file.getContentType().equals("application/vnd.ms-excel")) {
            return ResponseEntity.badRequest().body("Only Excel files are allowed.");
        }

        try {
            // Parse Excel file and extract data
            List<ExcelData> excelDataList = parseExcelFile(file);

            // Save data to database
            excelUploadService.saveExcelData(excelDataList);

            return ResponseEntity.ok("File uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process Excel file.");
        }
    }

    private List<ExcelData> parseExcelFile(MultipartFile file) throws IOException {
        List<ExcelData> excelDataList = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header row if needed
            // rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                ExcelData excelData = new ExcelData(null, null);

                // Assuming the structure of Excel file matches the ExcelData object
                excelData.setField1(cellIterator.next().getStringCellValue());
                excelData.setField2(cellIterator.next().getStringCellValue());
                

                excelDataList.add(excelData);
            }
        }

        return excelDataList;
    }
}
