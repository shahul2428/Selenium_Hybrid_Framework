package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePageObjects extends TestBase {

	public HomePageObjects() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nav_automobile")
	WebElement automobile;
	
	@FindBy(id="nav_truck")
	WebElement truck;
	
	@FindBy(id="nav_motorcycle")
	WebElement motorcycle;
	
	@FindBy(id="nav_camper")
	WebElement camper;
	

public void click_on_Motorcycle() {
	motorcycle.click();
}
	
	



}
