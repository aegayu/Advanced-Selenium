import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Keyword extends Base {
	
	
public static  void typetext(By by,String parameter)
{
	WebElement element=driver.findElement(by);
	element.sendKeys(parameter);
}
public static void click(By by)
{
	WebElement element=driver.findElement(by);
	element.click();
}
public static void listbox(By by,String parameter)
{
	WebElement element=driver.findElement(by);
	Select s= new Select(element);
	s.selectByValue(parameter);
}

public By getByObject(String locator, String locatorid){
	By byobj=null;
	switch(locator){
	case "id":
		byobj=By.id(locatorid);
		break;
	case "xpath":
		byobj=By.xpath(locatorid);
		break;
		
	}
	return byobj;
}



public void performAction(String locator, String locatorid, String keyword, String parameter)
{

	switch(keyword)
	{
	case "typetext":
		typetext(getByObject(locator,locatorid),parameter);
		break;
	case "click" :
		click(getByObject(locator,locatorid));
		break;
	case "listbox":
		listbox(getByObject(locator,locatorid), parameter);	
	}
	
}

}