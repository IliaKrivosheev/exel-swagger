package com.comfort.soft.exel.web;

import com.comfort.soft.exel.exception.InvalidNthMaxException;
import com.comfort.soft.exel.service.ExcelService;
import com.comfort.soft.exel.service.MaxNumberService;
import com.comfort.soft.exel.service.MaxNumberService2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Controller for handling HTTP requests related to
 * extracting the N-th maximum number from Excel data.
 * Provides two endpoints: one uses
 * {@link MaxNumberService}, the other uses {@link MaxNumberService2}.
 */
@RestController
@RequiredArgsConstructor
public class ExcelController {
    private final ExcelService excelService;
    private final MaxNumberService maxNumberService;
    private final MaxNumberService2 maxNumberService2;

    /**
     * Retrieves the N-th maximum number from an Excel file,
     * using {@link MaxNumberService}.
     *
     * <p>Handles exceptions related to invalid
     * input data and I/O errors, returning
     * appropriate error messages.</p>
     *
     * @param filePath The path to the Excel file from which to extract data.
     * @param n The order of the maximum number to find.
     * @return ResponseEntity containing the result of the search
     *         or an error message.
     */
    @GetMapping("/nth-max")
    public ResponseEntity<?> getNthMax(@RequestParam String filePath, @RequestParam int n) {
        try {
            int[] numbers = excelService.readNumbersFromExcel(filePath);
            int result = maxNumberService.findNthMax(numbers, n);
            return ResponseEntity.ok(result);
        } catch (InvalidNthMaxException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error: Cannot open the file. Check if the path or file format is correct.");
        }
    }

    /**
     * Retrieves the N-th maximum number from an Excel file,
     * using {@link MaxNumberService2}.
     *
     * <p>Handles exceptions related to invalid
     * input data and I/O errors, returning
     * appropriate error messages.</p>
     *
     * @param filePath The path to the Excel file from which to extract data.
     * @param n The order of the maximum number to find.
     * @return ResponseEntity containing the result of the search
     *         or an error message.
     */
    @GetMapping("/nth-max2")
    public ResponseEntity<?> getNthMax2(@RequestParam String filePath, @RequestParam int n) {
        try {
            int[] numbers = excelService.readNumbersFromExcel(filePath);
            int result = maxNumberService2.findNthMax(numbers, n);
            return ResponseEntity.ok(result);
        } catch (InvalidNthMaxException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error: Cannot open the file. Check if the path or file format is correct.");
        }
    }
}
