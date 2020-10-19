import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteGuru99ExcelFile {

	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {
		// create object class to open the xlsx file
		File file = new File(filePath + "\\" + fileName);
		System.out.println("check created object: " + file);
		// create object of FileInputStream class to read the excel path

		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;
		// find the file extension by splitting file name in string and getting only
		// extension name
		String fileExtenstionName = fileName.substring(fileName.indexOf("."));
		System.out.println("file extenstion: " + fileExtenstionName);
		// check condition if the file extension is xlsx file
		if (fileExtenstionName.equals(".xlsx")) {
			// if its xlsx file then create object of XSSFWorkbook class
			guru99Workbook = new XSSFWorkbook(inputStream);
		}
		// check condition if the file is xls
		if (fileExtenstionName.equals(".xlx")) {
			guru99Workbook = new HSSFWorkbook(inputStream);
		}
		// Read the excel sheet by sheet name
		Sheet sheet = guru99Workbook.getSheet(sheetName);

		// get current count of rows from sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		// get first row from sheet
		Row row = sheet.getRow(0);
		// create new row and append it to last of sheet
		Row newRow = sheet.createRow(rowCount + 1);
		// create a loop over the cells of newly created row
		for (int j = 0; j < row.getLastCellNum(); j++) {
			// fill data in row
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToWrite[j]);
		}
		// close inputStream
		inputStream.close();
	}

	public static void main(String[] args) throws IOException {

		// create array with data in same order in which you expect to be filled in
		// excel file
		String[] valueToWrite = { "Mr. F", "Noida" };
		// create object of current class
		WriteGuru99ExcelFile objExcelFile = new WriteGuru99ExcelFile();
		// prepare path for excel file
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources";
		// write the file name using filename, sheet name and data to be filled
		objExcelFile.writeExcel(filePath,"ExportExcel.xlsx", "ExcelGuru99Demo", valueToWrite);
		System.out.println();
		System.out.print("sucsesfully writen to excel");
	}
}
