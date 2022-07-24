package testBase;

import java.io.IOException;
import java.net.Socket;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsuranceData;
import pageObjects.EnterProductDataObjects;
import pageObjects.EnterVehicledataObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPricePage;
import reusableComponents.PropertiesOperation;

public class TestBase extends PageObjectsRepo {

	public static WebDriver driver;
	public static WebDriver DriverSetup() throws Exception {
		String Browser = PropertiesOperation.ReadProp("Browser");
		String Url = PropertiesOperation.ReadProp("Url");
		
		if (Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(Url);
		return driver;
		
	}
	
@BeforeMethod
public void LauchBrowser() throws Exception {
	DriverSetup();
	homepage =  new HomePageObjects();
	VehiclePage = new EnterVehicledataObjects();
	ProductPage = new EnterProductDataObjects();
	InsurancePage = new EnterInsuranceData();
	Pricepage = new SelectPricePage();
}
	
@AfterMethod
public void tearDown(){
	driver.close();
	
}

}
