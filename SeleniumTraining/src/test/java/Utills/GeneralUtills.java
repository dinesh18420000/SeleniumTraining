package Utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GeneralUtills {

	static org.apache.logging.log4j.Logger log = LogManager.getLogger(GeneralUtills.class.getName());

	public void wait(int seconds, WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void waitForElement(WebElement element, int seconds, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	public void fluentWaitForElement(WebElement element, int seconds, WebDriver driver) {
		
		 Wait driverWait=(Wait) new FluentWait<>(driver).withTimeout(Duration.ofSeconds(seconds)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(element));
	}

	

	
}
