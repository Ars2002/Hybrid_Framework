package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private Workbook workbook;
	private Sheet sheet;

	// Constructor to load the Excel file and sheet
	public ExcelUtils(String fileName, String sheetName) {
		// Get the user directory (project directory)
        String projectDir = System.getProperty("user.dir");
        
        // Construct the file path dynamically based on the project directory
        String filePath = projectDir + File.separator + "src" + File.separator + "test" 
        		+ File.separator + "resources";


		String filePathString = filePath+File.separator+fileName;
		System.out.println(filePathString);
		try (FileInputStream fis = new FileInputStream(filePathString)) {
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			System.out.println(sheetName);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	// Get total row count
	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	// Get total column count for a given row
	public int getColumnCount(int rowIndex) {
		Row row = sheet.getRow(rowIndex);
		return row.getPhysicalNumberOfCells();
	}

	// Get data from a specific cell
	public String getCellData(int rowIndex, int colIndex) {
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(colIndex);

		if (cell == null) {
			return "";
		}

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				return String.valueOf(cell.getNumericCellValue());
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}
	}

	// Get all data from the sheet as a List of Lists
	public List<List<String>> getAllData() {
		List<List<String>> dataList = new ArrayList<List<String>>();

		for (int i = 0; i < getRowCount(); i++) {
			Row row = sheet.getRow(i);
			List<String> rowDataList = new ArrayList<String>();

			for (int j = 0; j < getColumnCount(i); j++) {
				rowDataList.add(getCellData(i, j));
			}
			dataList.add(rowDataList);
		}
		return dataList;
	}

	// Close the workbook
	public void closeWorkbook() {
		try {
			if (workbook != null) {
				workbook.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
