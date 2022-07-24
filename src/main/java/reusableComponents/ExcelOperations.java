package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	String filepath;
	Sheet sheet;

	public ExcelOperations(String Sheetname) {
		try {
			filepath = System.getProperty("user.dir") + PropertiesOperation.ReadProp("TestDatalocation");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		File testfile = new File(filepath);
		Workbook WB = null;
		try {
			WB = WorkbookFactory.create(testfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = WB.getSheet(Sheetname);
	}

	public HashMap<String, String> getTestDataInMap(int Rownum) throws EncryptedDocumentException, IOException {
		// Location - Where Excel is
		// Open File WorkBook
		// System.out.println(filepath);

		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
			sheet.getRow(Rownum).getCell(i).setCellType(CellType.STRING);
			hm.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(Rownum).getCell(i).toString());
		}
		return hm;

	}

	public int getRowCount() {
		return sheet.getLastRowNum();
	}

	public int getColumCunt() {
		return sheet.getRow(0).getLastCellNum();
	}

	public String getvaluefrmcell(int rownum ,int cellnum) {
		return	sheet.getRow(rownum).getCell(cellnum).toString();
	}
}
