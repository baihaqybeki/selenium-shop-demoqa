package com.shop.demoqa.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shop.demoqa.driver.DriverSingleton;
import com.shop.demoqa.pages.WishListFeature;

public class TestWishListFeature {
	
	public static WebDriver driver;
	private WishListFeature wishList;
	
	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}
	
	@BeforeMethod
	public void pageObject() {
		wishList = new WishListFeature();
	}
	
	@Test
	public void addAndCheck() {
		wishList.addWishList();
		String actual = wishList.getWishList();
		assertTrue(actual.contains("PINK"));
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(5);
		driver.quit();
	}
	
	static void delay(int seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
