package com.shop.demoqa.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shop.demoqa.driver.DriverSingleton;
import com.shop.demoqa.pages.SearchFeature;

public class TestSearchFeature {

	public static WebDriver driver;
	private SearchFeature searchFeature;

	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		searchFeature = new SearchFeature();
	}

	@Test(priority = 1)
	public void itemAvailabe() {
		String item = "PINK";
		searchFeature.searchItem(item);
		String actual = searchFeature.resultGetText();
		System.out.println(actual);
		assertTrue(actual.contains(item));
	}
	
	@Test(priority = 2)
	public void itemNotAvailabe() {
		String item = "bag";
		searchFeature.searchItem(item);
		assertTrue(searchFeature.resultNull());
	}
	
	
	@AfterClass
	public void closeBrowser() {
		delay(5);
		driver.quit();
	}

	static void delay(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
