package com.example.excelupload.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExcelUploadServiceTest {

    @Autowired
    private ExcelUploadService excelUploadService;

    @Test
    public void testProcessExcelData() {
        byte[] fileContent = {}; // Provide sample file content for testing
        List<String> errors = excelUploadService.processExcelData(fileContent);
        // Add assertions to verify the list of errors
        assertTrue(errors.isEmpty(), "List of errors should be empty if processing is successful");
    }
}

