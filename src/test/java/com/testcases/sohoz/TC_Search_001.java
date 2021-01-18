package com.testcases.sohoz;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.sohoz.SearchPage;

public class TC_Search_001 extends BaseClass {

	@Test
	public void searchpage() throws InterruptedException, IOException {

//		driver.get(baseUrl);
		SearchPage sp = new SearchPage(driver);
		sp.setFrom(from);
		Thread.sleep(1000);
		sp.setDestination(destination);
		Thread.sleep(1000);
		sp.Doj();
		Thread.sleep(1000);
		sp.Dor();
		Thread.sleep(1000);
		sp.clickSubmit();
		Thread.sleep(15000);
		String expectedUrl = "https://www.shohoz.com/booking/bus/search?fromcity=Rajshahi&tocity=Dhaka&doj=22-11-2020&dor=25-11-2020";
		String currentUrl= driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (driver.getCurrentUrl().equals(expectedUrl)) {
			Assert.assertTrue(true);
			System.out.println("pass");
//			captureScreen(driver, "SearchPageTest"); 
		} else {
			Assert.assertTrue(false);
			System.out.println("fail");
		}
	}

}
