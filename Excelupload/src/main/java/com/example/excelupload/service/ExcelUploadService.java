package com.example.excelupload.service;


import org.apache.poi.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelUploadService {

    public List<String> processExcelData(byte[] fileContent) {
        List<String> errors = new ArrayList<>();

        try {
            // Convert byte array to workbook
            Workbook workbook = new XSSFWorkbook(new ByteArrayInputStream(fileContent));

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row
            Iterator<Row> iterator = sheet.iterator();
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

        } catch (IOException e) {
            e.printStackTrace();
            errors.add("Failed to process the uploaded file");
        }

        return errors;
    }
}

