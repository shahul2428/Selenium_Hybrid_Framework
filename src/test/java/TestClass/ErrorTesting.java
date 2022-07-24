package TestClass;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class ErrorTesting extends TestBase {
	ExcelOperations excel1 = new ExcelOperations("General_TestCases");
@Test()
public void errorMsg_CylinderCap() {
//Open Browser and Navigate is handled in Before Method in TestBase
//Click on Motorcycle - On Homepage	
//Enter Cylinder Capacity 
//Verify Error Message
	
// I have to Create a object for HomepageObjects to access the MotorcycleCick Method So i am Creating a Separate class PageObjectsRepo
//in That i will Create Public Objects and in order to Call it here i am Extends TestBase and TestBase Extends PageObjectsRepo Class	
	test.log(Status.INFO, "Validating the Error Message in Cylinder Capacity Text Box");
	homepage.click_on_Motorcycle();
	VehiclePage.EnterTextinCylinder("2001"); 
	test.log(Status.INFO, "Value of 2001 is Passed");// inorder to Get test here Iam Extending PageobjectRepo through TestBase
	String actualErrorMsg = VehiclePage.ErrorCyclinder_isDiplay();
	String ExpectedErrorMsg = "Must be a number between 1 and 2000";
	Assert.assertEquals(actualErrorMsg, ExpectedErrorMsg,"Error Message is Not Matching on Cylinder");
}
	
@Test()
public void VerifyDropDown_Model() {
	homepage.click_on_Motorcycle();
	test.log(Status.INFO, "Verifying the Model Dropdowvalues");
	String ExpectedString = excel1.getvaluefrmcell(3, 3);
	String[] split = ExpectedString.split(",");
	List<String> ActualList = VehiclePage.DropDown__Model();
	List<String> ExpectedList = Arrays.asList(split);
	Assert.assertEquals(ActualList, ExpectedList, "This List is not Same");
}

@Test()
public void VerifyDropDown__Make() {
	homepage.click_on_Motorcycle();
	test.log(Status.INFO, "Verifying the Make Dropdowvalues");
	test.log(Status.INFO, "Deliberately Failing this Method");
	String ExpectedString = excel1.getvaluefrmcell(4, 3);
	String[] split = ExpectedString.split(",");
	List<String> ActualList = VehiclePage.DropDown__Make();
	List<String> ExpectedList = Arrays.asList(split);
	Assert.assertEquals(ActualList, ExpectedList, "This List is not Same");
}


}
