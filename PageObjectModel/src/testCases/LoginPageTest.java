package testCases;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageClasses.Base;
import pageClasses.LoginPage;
import pageClasses.SearchHotelPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginPageTest {

	
			LoginPage loginpage=new LoginPage();
			SearchHotelPage srchhotel=new SearchHotelPage();
			
		@Test
		public void  atestUsername(){
		
			loginpage.setTxtUsername("aegayathri");
			Assert.assertEquals("aegayathri",loginpage.getTxtUsername());
		}
		
		@Test
		public void  btestPassword(){
			
			loginpage.setTxtPassword("krishnar");
			Assert.assertEquals("krishnar",loginpage.getTxtPassword());
		}
		
		@Test
		public void  ctestLogin(){
			
			/*loginpage.getTxtUsername();
			loginpage.getTxtPassword();*/
			loginpage.clickBtnLogin();
			
			new WebDriverWait(Base.getDriver(),10).until(ExpectedConditions.presenceOfElementLocated(By.id("location")));
			Assert.assertEquals("AdactIn.com - Search Hotel",Base.getDriver().getTitle());
				
		}

		@Test
		public void  dtestLocation(){
		
			
			srchhotel.setLocation("Sydney");
			Assert.assertEquals("Sydney",srchhotel.getLocation());
		}
		@Test
		public void  etestHotel(){
			
			srchhotel.setHotels("Hotel Sunshine");;
			Assert.assertEquals("Hotel Sunshine",srchhotel.getHotels());
		}
		@Test
		public void  ftestRoomType(){
		
			srchhotel.setRoomType("Double");
			Assert.assertEquals("Double",srchhotel.getRoomType());
		}
		@Test
		public void gtestSearch(){
			srchhotel.clickSearch();
		}
}
