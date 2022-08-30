package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {

	public static String parameterization (String sheet_name,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream ("C:\\Users\\hp\\eclipse-workspace\\MavenZerodha\\src\\test\\resources\\TestData.xlsx");
		String value = WorkbookFactory.create(file).getSheet(sheet_name).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
}
