package org.ClearTrip.com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    private static final Logger logger =
            LogManager.getLogger(ExcelUtils.class);

    private static final String DIRECTORY = "testdata";
    private static final String FILE_PATH = "testdata/HotelNames.xlsx";
    private static final String SHEET_NAME = "Hotels";

    // ✅ WRITE to Excel
    public static void writeHotelNames(List<String> hotelNames) {

        try {
            // ✅ Create directory if it does not exist
            Path dirPath = Paths.get(DIRECTORY);
            Files.createDirectories(dirPath);

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            int rowNum = 0;
            for (String name : hotelNames) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(name);
            }

            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);

            workbook.close();
            fos.close();

            logger.info("Hotel names written to Excel: {}", FILE_PATH);

        } catch (Exception e) {
            logger.error("Failed to write hotel names to Excel", e);
        }
    }

    // ✅ READ from Excel
    public static List<String> readHotelNames() {

        List<String> hotelNames = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(SHEET_NAME);

            for (Row row : sheet) {
                hotelNames.add(row.getCell(0).getStringCellValue());
            }

            workbook.close();
            fis.close();

            logger.info("Hotel names read from Excel successfully");

        } catch (Exception e) {
            logger.error("Failed to read hotel names from Excel", e);
        }

        return hotelNames;
    }
}