package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static final String FILE_PATH = "C:\\Users\\Admin\\Desktop\\Cucumber_Framework\\CucumberFramework\\testdata\\testdata.xlsx";

    public static String[] getTestData(String testCaseID) {
        try (FileInputStream file = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0); // Data Should be in First Sheet

            for (Row row : sheet) {
                Cell cell = row.getCell(0); // TC_ID is in column 0
                if (cell != null && cell.getStringCellValue().trim().equalsIgnoreCase(testCaseID)) {
                    String username = getCellValue(row.getCell(1));
                    String password = getCellValue(row.getCell(2));
                    return new String[]{username, password};
                }
            }
            System.out.println("Test data not found for TC_ID: " + testCaseID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //For Value From Excel
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        return cell.getCellType() == CellType.STRING ? cell.getStringCellValue().trim() : String.valueOf((int) cell.getNumericCellValue());
    }
}
