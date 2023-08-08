package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utills.GeneralUtills;

public class HomePage {

	@FindBy(css = "div.header-text")
	List<WebElement> sideNavTabs;
	
	
	public void printMessage() throws FileNotFoundException, IOException {
		GeneralUtills generalUtills = new GeneralUtills();
 	}
}
