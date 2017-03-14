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

public class AdactinLogin {
	
static WebDriver driver;
public static XSSFWorkbook workbook;

public static void initDriver() throws IOException{
	
	String excelfilepath="C:\\Users\\admin\\Desktop\\Ticket Booking\\Sample.xlsx";
	workbook = new XSSFWorkbook(excelfilepath);
	switch(workbook.getSheet("config").getRow(0).getCell(1).getStringCellValue().toLowerCase().trim())	
	{
	case "Chrome":
	System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe" );
	driver= new ChromeDriver();
	break;
	
	case "Firefox":
	System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Downloads\\geckodriver.exe" );
	driver= new FirefoxDriver();
	break;
	}
}


public static void correctLogin()
{

	for (int i=0;i<=workbook.getSheetAt(0).getLastRowNum();i++)
	{
		XSSFRow row=workbook.getSheetAt(0).getRow(i);     
			XSSFCell cell1=row.getCell(0);
		XSSFCell cell2=row.getCell(1);
		//XSSFCell cell3=row.getCell(2);
		driver.get(workbook.getSheet("config").getRow(1).getCell(1).getStringCellValue());
		driver.findElement(By.id("username")).sendKeys(cell1.getStringCellValue());
		driver.findElement(By.id("password")).sendKeys(cell2.getStringCellValue());
		driver.findElement(By.id("login")).click();
		booking();
		
		}

}

public static void booking()
{

	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
new Select(driver.findElement(By.id("location"))).selectByValue(workbook.getSheetAt(2).getRow(1).getCell(0).getStringCellValue());
	 logout();
}

public static void logout()
{
		driver.findElement(By.id("logout")).click();
}
public static void main(String[] args) throws IOException
{
	initDriver();
	correctLogin();
}
}