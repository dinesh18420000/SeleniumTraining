package Pages;
import org.openqa.selenium.WebDriver;

import Log.Log;
import Utills.ConfigReader;

public class LoginPage {
	ConfigReader configReader = ConfigReader.getInstance();
	/**Launch the login Page
	 * 
	 */
	public void launchLoginPage(WebDriver driver) {
	try {
		String url;
		 url=configReader.getProperties("BaseUrl");
		 driver.get(url);
		 Log.message("launched the URL :"+url,true,driver);
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
