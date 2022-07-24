package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.TestBase;

public class capturescreenShot extends TestBase {


	public static String gettimestamp() {
		Date date =  new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		String actualdate = format.format(date);
		return actualdate;
	}
	
	public static  String  getScreenShot() {
		File Src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String	ScreenShotPath = System.getProperty("user,dir")+"/Reports/ScreenShot/"+gettimestamp()+".jpeg";
		File dest = new File (ScreenShotPath);
	String	absolutePath = dest.getAbsolutePath();
		try {
			FileUtils.copyFile(Src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return absolutePath;
	}
	
}
