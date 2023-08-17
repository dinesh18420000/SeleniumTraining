package Log;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;


public class Log {

public static Logger log= LogManager.getLogger(Log.class.getName());
	
	public static void message(String message)
	{
		log.info(message);
		Reporter.log(message);
	}
	
	
	public static void message(String message,boolean screenshot,WebDriver driver) throws IOException
	{
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath=getScreenshotPath();
		File filePath=new File(ScreenshotPath);
		String screenshotName= ScreenshotPath.replace("test-output/Screenshots/", "");
  		FileUtils.copyFile(file, filePath);
		file.delete();
		log.info(message);
		Reporter.log(message+"<a target=\"_blank\" href=\"." + File.separator + "Screenshots" + File.separator + screenshotName + "\">[Screenshot]</a>");
	}
	
	public static String getScreenshotPath() {
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat smDateformat=new SimpleDateFormat("DD-MM-yyyy-hh-mm-ss-SSS");
		String ScreenshotPath="test-output/Screenshots/Test"+smDateformat.format(calendar.getTime())+".png";
		log.trace("Screenshot Path: "+ScreenshotPath);	
		return ScreenshotPath;
	}
	
	

	public static void testcaseInfo(String Description) {
		log.info("******************** "+Description+" "+printCurrentTimeAndDate()+" ************");
		Reporter.log("<b><strong><font size=\"4\"><center>***** "+Description+" *****</font></strong></center></b>");
 	}

	
	public static void deleteAllScreenshot() {
		log.info("Deleting the existing report screenshot");
		File filePath=new File("Screenshots");
		String absoultePath=filePath.getAbsolutePath();
		log.info("Adsolute delete path :"+absoultePath);
		deleteContents(filePath);

	}
public static void deleteContents(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteContents(file);
                }
                file.delete();
            }
        }}


    public static String printCurrentTimeAndDate() {
        // Get the current date and time
        Date currentDate = new Date();
        
        // Define the time and date formats
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy", Locale.ENGLISH);
        
        // Format the current time and date
        String formattedTime = timeFormat.format(currentDate);
        String formattedDate = dateFormat.format(currentDate);
        
        // Print the formatted time and date
        String currenTime=formattedTime+" "+formattedDate;
        return currenTime;
    }


}
 