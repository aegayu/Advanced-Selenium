import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ExcelReadWrite {

	public static void main(String[] args) throws IOException
	{

		// Single line
		
		//	XSSFCell workbook=new XSSFWorkbook("C:/Users/admin/Desktop/Sample.xlsx").getSheetAt(0).getRow(0).getCell(0);
		//	System.out.println(workbook.getStringCellValue());
		
		
		//Multiple line
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Downloads\\geckodriver.exe" );
		
		XSSFWorkbook workbook=new XSSFWorkbook("C:/Users/admin/Desktop/Ticket Booking/Sample.xlsx");
		XSSFSheet sheet=workbook.getSheetAt(0);
					       		
		WebDriver driver= new FirefoxDriver();
		
		
		/*	for (int i=0;i<=sheet.getLastRowNum();i++)
        	{
        		XSSFRow row=sheet.getRow(i);     
           		XSSFCell cell1=row.getCell(0);
        		XSSFCell cell2=row.getCell(1);
        		//XSSFCell cell3=row.getCell(2);
        		driver.get("http://adactin.com/HotelApp");
        		driver.findElement(By.id("username")).sendKeys(cell1.getStringCellValue());
        		driver.findElement(By.id("password")).sendKeys(cell2.getStringCellValue());
        		driver.findElement(By.id("login")).click();
        		//driver.findElement(By.id("location")).sendKeys(cell3.getStringCellValue());
        	}
		*/
		
		for(Row row:workbook.getSheetAt(0))
		{
			driver.get("http://adactin.com/HotelApp");
    		driver.findElement(By.id("username")).sendKeys(row.getCell(0).getStringCellValue());
    		driver.findElement(By.id("password")).sendKeys(row.getCell(0).getStringCellValue());
    		driver.findElement(By.id("login")).click();
			
		}
		
		
		
		/*for ( Row row:sheet)
		{
			for(Cell cell:row)
				System.out.println(cell.getStringCellValue());
			
		}*/
            
        workbook.close();
		
	}

}
