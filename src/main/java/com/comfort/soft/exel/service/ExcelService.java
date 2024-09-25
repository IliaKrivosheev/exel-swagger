package com.comfort.soft.exel.service;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for working with Excel files.
 * Provides methods for reading data from Excel files.
 */
@Service
public class ExcelService {

    /**
     * Reads integers from the specified Excel file.
     *
     * @param filePath The path to the local Excel file.
     * @return An array of integers read from the first column of the file.
     * @throws IOException If an error occurs while reading the file.
     */
    public int[] readNumbersFromExcel(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath))) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }
        }

        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
