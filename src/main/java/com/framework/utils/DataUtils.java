package com.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class DataUtils {

    private static final Map<String, XSSFSheet> sheetCache = new HashMap<>();

    private DataUtils() {}

    public static String getData(String filePath, String sheetName, int row, int col) {

        try {
            XSSFSheet sheet = sheetCache.get(sheetName);

            if (sheet == null) {
                FileInputStream fis = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheet(sheetName);
                sheetCache.put(sheetName, sheet);
            }

            return sheet.getRow(row).getCell(col).getStringCellValue();

        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file", e);
        }
    }
}