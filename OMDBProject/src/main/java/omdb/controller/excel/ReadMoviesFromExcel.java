package omdb.controller.excel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import omdb.model.excel.ExcelRead;

public class ReadMoviesFromExcel {
	private static final String FILE_NAME = "films.xlsx";
	private ExcelRead read;
	
	
	public ReadMoviesFromExcel() {
		this.read = new ExcelRead();
	}
	
	
	public List<String> getMoviesFromExcel() {
		List<String> list = new ArrayList<String>();
		
		FileInputStream excelFile = read.getExcelFile(FILE_NAME);
		Workbook workbook = read.getWorkbook(excelFile);
		Sheet datatypeSheet = read.getSheet(workbook, 0);
		
        Iterator<Row> iterator = read.getRows(datatypeSheet);
        while (iterator.hasNext()) {
        	Iterator<Cell> cells = read.getCells(iterator.next());
        	
        	while (cells.hasNext()) {
        		Cell cell = cells.next();
        		
        		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
        			list.add(cell.getStringCellValue().trim());
        		}
        	}
        }
        return list;
	}
}