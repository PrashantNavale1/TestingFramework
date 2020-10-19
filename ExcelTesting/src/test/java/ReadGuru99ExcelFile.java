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

public class ReadGuru99ExcelFile {

	

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {
		//create object class to open the xlsx file
		File file = new File(filePath +"\\" +fileName);
		System.out.println("check created object: "+ file);
		//create object of FileInputStream class to read the excel path

			FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;
		// find the file extension by splitting file name in string and getting only extension name
		String fileExtenstionName = fileName.substring(fileName.indexOf("."));
		System.out.println("file extenstion: "+fileExtenstionName);
		//check condition if the file extension is xlsx file
		if (fileExtenstionName.equals(".xlsx"))
		{
		//if its xlsx file then create object of XSSFWorkbook class
			guru99Workbook = new XSSFWorkbook(inputStream);
		}
		//check condition if the file is xls
		if(fileExtenstionName.equals(".xls"))
		{
			guru99Workbook = new HSSFWorkbook(inputStream);
		}
		//Read the excel sheet by sheet name
		Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
		
		//get current count of rows from sheet
		int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
		
		//create a loop over the all the rows of the excel to read it
		for (int i = 0; i<rowCount+1; i++) {
			//fill data in row
			Row row = guru99Sheet.getRow(i);
			//create loop to print the cell value in row
			
			for (int j=0; j<row.getLastCellNum();j++) {
				//print excel data in console
				System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		//create object of ReadGuru99ExcelFile class
		ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();
		//prepare path for excel file
		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources";
		// call readfile method of the class read data
		objExcelFile.readExcel(filePath, "ExportExcel.xlsx", "ExcelGuru99Demo");
		
		
	}
		
	}
	
