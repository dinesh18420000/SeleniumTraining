package Utills;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Log.Log;

public class DataUtills {
	static Map<String, String> rowValuesMap = new HashMap<>();

	public static Map<String, String> getTestData(String sheetName, String ID) throws InvalidFormatException {
		try {
 			Log.message("Fetching the Testdata from the sheet " + sheetName + " and testcase id is " + ID);
 			InputStream inputStream = DataUtills.class.getResourceAsStream("/TestData.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheet(sheetName); // Replace with the actual sheet name

			int idColumnIndex = 0; // Replace with the index of the ID column
			String targetId = ID; // Replace with the unique value you're looking for

			Row headerRow = sheet.getRow(0); // Assuming the header row is the first row

			for (Row row : sheet) {
				Cell idCell = row.getCell(idColumnIndex);
				if (idCell != null && idCell.toString().trim().equalsIgnoreCase(targetId)) {
					for (Cell cell : row) {
						Cell headerCell = headerRow.getCell(cell.getColumnIndex());
						String columnHeader = headerCell.getStringCellValue();
						rowValuesMap.put(columnHeader, cell.toString());
					}
					break; // Stop searching once the desired row is found
				}
			} 
			System.out.print("[");
			for (Map.Entry<String, String> entry : rowValuesMap.entrySet()) {
                System.out.print(" "+entry.getKey() + "=" + entry.getValue());
            }
			System.out.println("]");

			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowValuesMap;
	}

}
