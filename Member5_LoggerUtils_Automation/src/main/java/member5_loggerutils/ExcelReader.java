package member5_loggerutils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private String filePath;

    // Constructor to set Excel file path
    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    // Method to read data from a sheet, row, and column
    public String getCellData(String sheetName, int rowNumber, int cellNumber) {
        String cellValue = "";
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNumber);
            Cell cell = row.getCell(cellNumber);

            if (cell != null) {
                cellValue = cell.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellValue;
    }
}

