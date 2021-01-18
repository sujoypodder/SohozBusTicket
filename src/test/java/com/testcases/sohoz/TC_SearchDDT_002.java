package com.testcases.sohoz;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageobjects.sohoz.SearchPage;
import com.utilities.sohoz.XLextra;

public class TC_SearchDDT_002 extends BaseClass {

	@Test(dataProvider = "SohozData")
	public void searchDDT(String fromm, String to) throws InterruptedException {

		SearchPage sp = new SearchPage(driver);
		sp.setFrom(fromm);
		Thread.sleep(1000);
		sp.setDestination(to);
		Thread.sleep(1000);
		sp.Doj();
		Thread.sleep(1000);
		sp.Dor();
		Thread.sleep(1000);
		sp.clickSubmit();
		Thread.sleep(10000);
		String expectedUrl = "https://www.shohoz.com/booking/bus/search?fromcity=Rajshahi%20&tocity=Dhaka&doj=22-11-2020&dor=25-11-2020";
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

	@DataProvider(name = "SohozData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\testdata\\sohoz\\SohozData.xlsx";
		int rownum = XLextra.getRowCount(path, "Sheet1");
		int colcount = XLextra.getCellCount(path, "Sheet1", 1);
		String searchdata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				searchdata[i - 1][j] = XLextra.getCellData(path, "Sheet1", i, j);
			}
		}
		return searchdata;
	}
}
