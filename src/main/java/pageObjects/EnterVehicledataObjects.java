package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.CommonMethods;
import testBase.TestBase;

public class EnterVehicledataObjects extends TestBase {

	public EnterVehicledataObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="make")
	WebElement dd_Make;
	
	@FindBy(id="model")
	WebElement dd_model;
	
	@FindBy(id="cylindercapacity")
	WebElement cylindercapacity;
	
	@FindBy(xpath="//input[@id='cylindercapacity']/following-sibling::span[@class=\"error\"]")
	WebElement cylindercapacityError;
	
	@FindBy(id="engineperformance")
	WebElement engineperformance;
	
	@FindBy(id="dateofmanufacture")
	WebElement dateofmanufacture;
	
	@FindBy(id="opendateofmanufacturecalender")
	WebElement DateIcon;
	
	@FindBy(id="numberofseatsmotorcycle")
	WebElement dd_numberofseats;
	
	@FindBy(id="fuel")
	WebElement dd_fuel;
	
	@FindBy(id="payload")
	WebElement payload;
	
	@FindBy(id="totalweight")
	WebElement totalweight;
	
	@FindBy(id="listprice")
	WebElement listprice;
	
	@FindBy(id="licenseplatenumber")
	WebElement licenseplatenumber;
	
	@FindBy(id="annualmileage")
	WebElement annualmileage;
	
	@FindBy(id="nextenterinsurantdata")
	WebElement nextinsurance;
	
	
	public void EnterTextinCylinder(String Number) {
		cylindercapacity.sendKeys(Number);
	} 
	
	public String ErrorCyclinder_isDiplay() {
		String Error_text_Cylind = cylindercapacityError.getText();
		return Error_text_Cylind;
	}
	
	public List<String> DropDown__Model() {
		return Common.Select_list_options(dd_model);
	}
	public List<String> DropDown__Make() {
		return Common.Select_list_options(dd_Make);
	}
	
	public void EnterDatainVehicleDataInsurance(HashMap<String, String> testData) throws Exception {
		Common.selectDropDownOptions(dd_Make, testData.get("Vehicle_Make"));
		Common.selectDropDownOptions(dd_model, testData.get("Vehicle_Model"));
		cylindercapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
		engineperformance.sendKeys(testData.get("Vehicle_Enging Performance"));
		dateofmanufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
		Common.selectDropDownOptions(dd_numberofseats, testData.get("Vehicle_No of Seats_motorcycle"));
		listprice.sendKeys(testData.get("Vehicle_List Price"));
		annualmileage.sendKeys(testData.get("Vehicle_Annual Mileage"));
	}
	
	public void NextBtn() {
		nextinsurance.click();
	}
	
	
	
}
