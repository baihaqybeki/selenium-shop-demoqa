package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.demoqa.driver.DriverSingleton;

public class WishListFeature {
	
	private WebDriver driver;
	SearchFeature searchFeature;

	
	public WishListFeature() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		searchFeature = new SearchFeature();
	}
	
	@FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/div[1]/div[1]/div[2]/div/a")
	private WebElement loveBtn;
	
	@FindBy(xpath = "//ul[@class='pull-right noo-topbar-right']//li[1]")
	private WebElement myWishList;
	
	@FindBy(xpath = "//div[@class='noo-product-item one noo-product-sm-4 not_featured post-1497 product type-product status-publish has-post-thumbnail product_cat-t-shirt product_tag-t-shirt product_tag-women has-featured first instock shipping-taxable purchasable product-type-variable']//div[@class='owl-item active']//img[@class='product-one-thumb']")
	private WebElement resultCard;
	
	@FindBy(xpath = "//a[normalize-space()='pink drop shoulder oversized t shirt']")
	private WebElement resultWishList;
	
	@FindBy(xpath = "/html/body/p/a")
	private WebElement ads;
	
	public void addWishList() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		searchFeature.searchItem("PINK");
		js.executeScript("window.scrollBy(0,350)","");
		actions.moveToElement(resultCard).perform();
		delay(5);
		loveBtn.click();
	}
	
	public String getWishList() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)","");
		if (driver.findElement(By.xpath("/html/body/p/a")).isDisplayed()) {
			ads.click();
		}
		myWishList.click();
		delay(3);
		myWishList.click();
		return resultWishList.getText();
		
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
