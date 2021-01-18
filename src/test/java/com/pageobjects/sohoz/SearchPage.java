 package com.pageobjects.sohoz;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver ldriver;

	public SearchPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "dest_from")
	@CacheLookup
	WebElement from;

	@FindBy(name = "dest_to")
	@CacheLookup
	WebElement to;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"doj\"]")
	@CacheLookup
	WebElement doj;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"dor\"]")
	@CacheLookup
	WebElement dor;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"bussearch\"]/ul/div[5]/div[2]/button")
	@CacheLookup
	WebElement btnSrc;

	public static void SelectDateByJs(WebDriver driver, WebElement ele, String dvalue) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dvalue + "');", ele);
	}

	public void setFrom(String fname) {
		from.sendKeys(fname);
	}

	public void setDestination(String dname) {
		to.sendKeys(dname);
	}
	
	public void Doj() throws InterruptedException {
		String jour = "22-11-2020";
		SelectDateByJs(ldriver, doj, jour);
		Thread.sleep(1000);
	}

	public void Dor() throws InterruptedException {
		String ret = "25-11-2020";
		SelectDateByJs(ldriver, dor, ret);
		Thread.sleep(1000);
	}

	public void clickSubmit() {
		btnSrc.click();
	}
	
}
