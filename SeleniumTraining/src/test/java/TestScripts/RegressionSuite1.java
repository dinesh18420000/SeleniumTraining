package TestScripts;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v112.page.Page;
import org.openqa.selenium.print.PageSize;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Utills.DataUtills;
import Log.Log;
import Pages.HomePage;
import Pages.LoginPage;

public class RegressionSuite1 {

	public WebDriver driver;
	
	@BeforeSuite
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dinesh.nachimuthu\\Documents\\chromedriver.exe");
		Log.deleteAllScreenshot();
	 	driver = new ChromeDriver();
	}
	

	@Test
	public void TestCase001() throws  IOException {
	 Log.testcaseInfo("Login Scenario");
	 LoginPage loginPage=new LoginPage();
	 loginPage.launchLoginPage(driver);
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
