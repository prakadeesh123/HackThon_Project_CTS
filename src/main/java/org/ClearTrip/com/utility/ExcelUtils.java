package org.ClearTrip.com.utility;

import org.ClearTrip.com.utility.HotelData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    private static final Logger logger = LogManager.getLogger(ExcelUtils.class);

    private static final String DIRECTORY = "testdata";
    private static final String FILE_PATH = "testdata/HotelData.xlsx";
    private static final String SHEET_NAME = "Hotels";

    // WRITE (Name + Price)
    public static void writeHotelData(List<HotelData> hotels) {
        try {
            Files.createDirectories(Paths.get(DIRECTORY));
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(SHEET_NAME);
            int rowNum = 0;
            // Header
            Row header = sheet.createRow(rowNum++);
            header.createCell(0).setCellValue("Hotel Name");
            header.createCell(1).setCellValue("Price");
            // Data
            for (HotelData hotel : hotels) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(hotel.getName());
                row.createCell(1).setCellValue(hotel.getPrice());
            }
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            workbook.close();
            fos.close();
            logger.info("Hotel data written to Excel");
        } catch (Exception e) {
            logger.error("Write failed", e);
        }
    }

    // READ (Name + Price)
    public static List<HotelData> readHotelData() {
        List<HotelData> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(SHEET_NAME);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String name = row.getCell(0).getStringCellValue();
                String price = row.getCell(1).getStringCellValue();
                list.add(new HotelData(name, price));
            }
            workbook.close();
            fis.close();
            logger.info("Excel read successful");
        } catch (Exception e) {
            logger.error("Read failed", e);
        }
        return list;
    }
}