package Dataproviders;


import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "FormDataFromExcel")
    public Object[][] getFormData() throws Exception {
        String filePath = "C:\\Users\\SRIRAMPRAVEEN\\OneDrive\\Documents\\ProjectMember6.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
        workbook.close();
        return data;
    }
}

