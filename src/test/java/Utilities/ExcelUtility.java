package Utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	

	

	
	    
	    private String filePath;
	    private Workbook workbook;

	    // Constructor
	    public void ExcelUtils(String filePath) throws IOException {
	        this.filePath = filePath;
	        FileInputStream fis = new FileInputStream(filePath);
	        this.workbook = new XSSFWorkbook(fis);
	        fis.close();
	    }

	    // Get row count
	    public int getRowCount(String sheetName) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        return sheet.getPhysicalNumberOfRows();
	    }

	    // Get cell count
	    public int getCellCount(String sheetName, int rowNum) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);
	        return row.getLastCellNum();
	    }

	    // Get cell data
	    public String getCellData(String sheetName, int rowNum, int colNum) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);
	        Cell cell = row.getCell(colNum);
	        DataFormatter formatter = new DataFormatter();
	        return formatter.formatCellValue(cell);
	    }

	    // Set cell data
	    public void setCellData(String sheetName, int rowNum, int colNum, String value) throws IOException {
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);
	        if (row == null) row = sheet.createRow(rowNum);
	        Cell cell = row.getCell(colNum);
	        if (cell == null) cell = row.createCell(colNum);
	        cell.setCellValue(value);

	        FileOutputStream fos = new FileOutputStream(filePath);
	        workbook.write(fos);
	        fos.close();
	    }

	    // Save and close workbook
	    public void close() throws IOException {
	        workbook.close();
	    }
	


}
