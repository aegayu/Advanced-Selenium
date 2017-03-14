import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Base {
	
static WebDriver driver;
public static XSSFWorkbook workbook;

public static void initDriver() throws IOException{
	
	String excelfilepath="C:\\Users\\admin\\Desktop\\Ticket Booking\\Keyword.xlsx";
	workbook = new XSSFWorkbook(excelfilepath);
	switch(workbook.getSheet("config").getRow(0).getCell(1).getStringCellValue().toLowerCase().trim())	
	{
	case "Chrome":
	System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe" );
	driver= new ChromeDriver();
	break;
	
	case "firefox":
	System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Downloads\\geckodriver.exe" );
	driver= new FirefoxDriver();
	
	break;
	}
	driver.get(workbook.getSheet("config").getRow(1).getCell(1).getStringCellValue());
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

}