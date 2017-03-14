package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SearchHotelPage {

	@FindBy(id="location")
	WebElement lstLocation;
	
	@FindBy(id="hotels")
	WebElement lstHotel;
	
	@FindBy(id="room_type")
	WebElement lstRoomType;
	
	@FindBy(id="Submit")
	static
	WebElement btnsearch;
	
public SearchHotelPage(){
		
		PageFactory.initElements(Base.getDriver(), this);
	}
	
	public String getLocation(){
		return new Select(lstLocation).getFirstSelectedOption().getText();
		
	}
	public String getHotels(){
		return new Select(lstHotel).getFirstSelectedOption().getText();
			
	}
	public String getRoomType(){
		return new Select(lstRoomType).getFirstSelectedOption().getText();
		
	}
	
	
	public void  setLocation(String location){
		
		new Select(lstLocation).selectByVisibleText(location);
		
	}
	public void  setHotels(String hotel){
		new Select(lstHotel).selectByVisibleText(hotel);
		
	}
	public void setRoomType(String roomType){
		
		new Select(lstRoomType).selectByVisibleText(roomType);
		
	}
public  void clickSearch(){
		
		btnsearch.click();
		
	}
}
