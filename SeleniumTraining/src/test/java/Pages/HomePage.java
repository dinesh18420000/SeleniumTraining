package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import Utills.GeneralUtills;

public class HomePage {

	@FindBy(css = "div.header-text")
	List<WebElement> sideNavTabs;
	
	 public static String getLoadedData(WebDriver driver) {
        
       Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
       .withTimeout(Duration.ofSeconds(1))
       .pollingEvery(Duration.ofMillis(100))
       .ignoring(NoSuchElementException.class);
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("load-button")));
 WebElement button= driver.findElement(By.id("load-button"));
 button.click();;
 wait.until(ExpectedConditions.elementToBeClickable(button));
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
 WebElement Content=driver.findElement(By.id("content"));
return Content.getText();
    }
	 
}
