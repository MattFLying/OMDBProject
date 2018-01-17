package omdb.model.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public ExcelRead() {}
	
	
	public Iterator<Cell> getCells(Row currentRow) {
		return currentRow.iterator();
	}
	public Iterator<Row> getRows(Sheet sheet) {
		return sheet.iterator();
	}
	public Sheet getSheet(Workbook workbook, int sheetIndex) {
		return workbook.getSheetAt(sheetIndex);
	}
	public Workbook getWorkbook(FileInputStream excelFile) {
		try {
			return new XSSFWorkbook(excelFile);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public FileInputStream getExcelFile(String fileName) {
		try {
			return new FileInputStream(getFile(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	private File getFile(String fileName) {
		File file = null;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			URL resource = classLoader.getResource(fileName);
			file = new File(resource.toURI());
			
			return file;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return file;
		}
	}
}