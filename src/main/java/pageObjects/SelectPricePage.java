package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SelectPricePage extends TestBase {

	public SelectPricePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nextsendquote")WebElement Next_Btn;
	
	
	
	public String ToselectplanPrice(String Plan) {
		return driver.findElement(By.xpath("//table[@id='priceTable']//td[@data-label='"+Plan+"']/span")).getText();
	}

	public void Toselectplancheckbox(String Plan) {
		driver.findElement(By.xpath("//table[@id='priceTable']//input[@name='Select Option' and @value='"+Plan+"']/.. ")).click();
	}

	public void ToclickNext() {
		Next_Btn.click();
}
	
}
