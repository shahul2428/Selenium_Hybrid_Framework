package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsuranceData extends TestBase {

	public EnterInsuranceData() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstname")
	WebElement firstname;

	@FindBy(id = "lastname")
	WebElement lastname;

	@FindBy(id = "birthdate")
	WebElement birthdate;

	@FindBy(id = "opendateofbirthcalender")
	WebElement CalendarICon;

	@FindBy(xpath = "(//p[@class='group'])[1]/label")
	List<WebElement> gender;

	@FindBy(id = "streetaddress")
	WebElement Street;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "zipcode")
	WebElement zipcode;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "occupation")
	WebElement occupation;

	@FindBy(xpath = "(//p[@class='group'])[2]/label")
	List<WebElement> Hobbies;

	@FindBy(id = "website")
	WebElement website;

	@FindBy(name = "Picture")
	WebElement Picture;

	@FindBy(name = "Open")
	WebElement Open;

	@FindBy(id = "preventervehicledata")
	WebElement preventervehicledata;

	@FindBy(id = "nextenterproductdata")
	WebElement nextenterproductdata;

	public void EnterDatainInsurance(HashMap<String, String> testData) throws Exception {
		firstname.sendKeys(testData.get("Insurant_FirstName"));
		lastname.sendKeys(testData.get("Insurant_LastName"));
		birthdate.sendKeys(testData.get("Insurant_birthdate"));
		Common.SelectRadioValue(gender, testData.get("Insurant_gender"));
		Street.sendKeys(testData.get("Insurant_Street"));
		Common.selectDropDownOptions(country, testData.get("Insurant_country"));
		zipcode.sendKeys(testData.get("Insurant_zipcode"));
		city.sendKeys(testData.get("Insurant_City"));
		Common.selectDropDownOptions(occupation, testData.get("Insurant_occupation"));
		Common.SelectCheckBoxes(Hobbies, testData.get("Insurant_Hobby"));
	
	}

	public void CickNextProduct() {
		nextenterproductdata.click();
	}
}
