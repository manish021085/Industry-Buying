package helperUtility;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICIT_WAIT=30;
	
	public static Object[][] excelHelper(int index) throws IOException {
		Object obj[][]=null;
		File file= new File(System.getProperty("user.dir") + "\\testData\\IBdata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(index);
		int rowCount = sheet.getLastRowNum();
		System.out.println("Total number of rows sheet :--> " +rowCount);
		int columnCount = sheet.getRow(1).getLastCellNum();
		System.out.println("Total number of column sheet :--> "+columnCount);
		obj = new Object[rowCount][columnCount];
		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				obj[i][j] = sheet.getRow(i+1).getCell(j).toString();
				System.out.println(obj[i][j]+ " ");
			}
		}
		return obj;
	}
	/*public static void main(String[] args) throws IOException {
		TestUtil.excelHelper(0);
	}
	*/
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") +"\\screenShots\\"+System.currentTimeMillis()+".png"));
		
	}

	

}
