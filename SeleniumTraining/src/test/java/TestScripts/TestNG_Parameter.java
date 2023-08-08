package TestScripts;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v112.page.Page;
import org.openqa.selenium.print.PageSize;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Log.Log;
import Pages.HomePage;

public class TestNG_Parameter {

	public WebDriver driver;
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dinesh.nachimuthu\\Documents\\chromedriver.exe");
		Log.deleteAllScreenshot();
	 	driver = new ChromeDriver();
	}
	

	@Test
	public void parameter() throws FileNotFoundException, IOException {
		Log.testcaseInfo("Launching the google site on chrome browser");
		driver.get("http://www.google.com");
 		Log.message("Open the google.com",true,driver);
  	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
