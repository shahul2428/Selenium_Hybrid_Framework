package TestClass;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.SelectPricePage;
import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class EndtoEndTesting extends TestBase{
	ExcelOperations excel = new ExcelOperations("InsurancePremium");//Default Constructor Cannot Handle Exception so In Excel operation Handled with 
	//try and Catch Block
	@Test(dataProvider = "vehicledata")
public void InsuranceCalcu(Object obj1) throws Exception {
		
		HashMap <String,String> TestDataMap = (HashMap<String, String>) obj1;
		System.out.println(TestDataMap);
		test.log(Status.INFO,"Test Data used for Execution  "+TestDataMap);
		test.log(Status.INFO,"Test Data Option used for Execution  "+TestDataMap.get("SelectOption"));
		
		homepage.click_on_Motorcycle();
		VehiclePage.EnterDatainVehicleDataInsurance(TestDataMap);
		VehiclePage.NextBtn();
		InsurancePage.EnterDatainInsurance(TestDataMap);
		InsurancePage.CickNextProduct();
		ProductPage.EnterDatainproduct(TestDataMap);
		ProductPage.NextBtnSelctPrcice();
		
	//	String ExpectedPrice = "238.00";
	//	String ActualPrice = Pricepage.ToselectplanPrice("Silver");
		if(TestDataMap.get("SelectOption").equalsIgnoreCase("Silver")) {
		Assert.assertEquals(TestDataMap.get("PriceValidation_Silver"),Pricepage.ToselectplanPrice("Silver"),"This is for Silver" );
		System.out.println(TestDataMap.get("SelectOption"));
		}
		if(TestDataMap.get("SelectOption").equalsIgnoreCase("Gold")) {
		Assert.assertEquals(TestDataMap.get("PriceValidation_Gold"),Pricepage.ToselectplanPrice("Gold"),"This is for Gold" );
		System.out.println(TestDataMap.get("SelectOption"));
		}
		if(TestDataMap.get("SelectOption").equalsIgnoreCase("Ultimate")) {
		Assert.assertEquals(TestDataMap.get("PriceValidation_Ultimate"),Pricepage.ToselectplanPrice("Ultimate"),"This is for Ultimate" );
		System.out.println(TestDataMap.get("SelectOption"));
		}
		Pricepage.Toselectplancheckbox(TestDataMap.get("SelectOption"));
		Pricepage.ToclickNext();
}	 
	
	@DataProvider (name = "vehicledata")
	public Object[][] dataSupplier() throws EncryptedDocumentException, IOException{
		Object obj[][] = new Object [excel.getRowCount()][1];//Not Possible to pass 30 Columns So passing as a Hashmap of Single Column
		
		for(int i=1;i<=excel.getRowCount();i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);//getting the hashmap from exceloperation now conver it to object Array
		obj[i-1][0]=testData;//[i-1] because index starts from 0 and [0] because we passing 1 Column
		}
		return obj;
	}
	
	
	
}
