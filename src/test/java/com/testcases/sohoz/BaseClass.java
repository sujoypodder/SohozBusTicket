package com.testcases.sohoz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.utilities.sohoz.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseUrl = readconfig.getAppUrl();
	public String from= readconfig.getFname();
	public String destination=readconfig.getDname();
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			FirefoxOptions opt = new FirefoxOptions();
			opt.setAcceptInsecureCerts(false);
			driver = new FirefoxDriver();
		} else if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(false);
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@AfterClass
	public void teardown() throws InterruptedException {
		// driver.close();
		Thread.sleep(3000);
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/SSshots/" + name + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}

}
