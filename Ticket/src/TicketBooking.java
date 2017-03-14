import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TicketBooking {

	public static void main(String[] args) throws IOException {
		
	/*	System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Downloads\\geckodriver.exe" );
		WebDriver w= new FirefoxDriver();
		w.get("http://adactin.com/HotelApp");
		w.findElement(By.id("username")).sendKeys("aegayathri");
		w.findElement(By.id("password")).sendKeys("krishnar");
		w.findElement(By.id("login")).click();
		*/
	
	
FileInputStream fis= new FileInputStream(new File("C:/Users/admin/Desktop/Ticket Booking/Sample.xlsx"));
XSSFWorkbook workbook=new XSSFWorkbook(fis);
fis.close();


workbook.getSheetAt(0).createRow(0).createCell(0).setCellValue("Success");
System.out.println(workbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue());
FileOutputStream fos= new FileOutputStream(new File("C:/Users/admin/Desktop/Ticket Booking/Sample.xlsx"));

workbook.write(fos);
fos.close();
workbook.close();




	}

}
