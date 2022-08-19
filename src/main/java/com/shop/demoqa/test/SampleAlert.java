package com.shop.demoqa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.demoqa.driver.DriverSingleton;

public class SampleAlert {
	
	private WebDriver driver;
	
	public SampleAlert() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='confirmButton']")
	private WebElement clickMe;
	
	@FindBy(xpath = "//span[@id='confirmResult']")
	private WebElement txtConfirmResult;
	
	@FindBy(xpath = "//button[@id='promtButton']")
	private WebElement btnPrompt;
	
	@FindBy(xpath = "//span[@id='promptResult']")
	private WebElement txtPromptResult;
	
	public void clickMe() {
		clickMe.click();
	}
	
	public void clickPtompt() {
		btnPrompt.click();
	}
	
	public String getTxtConfirmResult() {
		return txtConfirmResult.getText();
	}
	
	public String getTxtPromptResult() {
		return txtPromptResult.getText();
	}
	
}
