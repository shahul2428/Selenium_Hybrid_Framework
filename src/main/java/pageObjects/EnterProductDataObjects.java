package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductDataObjects extends TestBase {

	public EnterProductDataObjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "startdate")
	WebElement startdate;

	@FindBy(id = "openstartdatecalender")
	WebElement CalendarIcon;

	@FindBy(id = "insurancesum")
	WebElement insurancesum;

	@FindBy(id = "damageinsurance")
	WebElement damageinsurance;

	@FindBy(xpath = "(//p[@class='group'])[3]/label")
	List<WebElement> OptionalProducts;

	@FindBy(id = "preventerinsurancedata")
	WebElement preventerinsurancedata;

	@FindBy(id = "nextselectpriceoption")
	WebElement nextselectpriceoption;

	public void EnterDatainproduct(HashMap<String, String> testData) throws Exception {
		startdate.sendKeys(testData.get("Product_startdate"));
		Common.selectDropDownOptions(insurancesum, testData.get("Product_insurancesum"));
		Common.selectDropDownOptions(damageinsurance, testData.get("Product_damageinsurance"));
		Common.SelectCheckBoxes(OptionalProducts, testData.get("Product_OptionalProducts"));
	}

	public void NextBtnSelctPrcice() {
		nextselectpriceoption.click();
	}

}
