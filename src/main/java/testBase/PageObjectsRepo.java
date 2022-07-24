package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsuranceData;
import pageObjects.EnterProductDataObjects;
import pageObjects.EnterVehicledataObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPricePage;
import reusableComponents.CommonMethods;

public class PageObjectsRepo {
	public static ExtentReports Extent;
	public static ExtentTest test;
	public static HomePageObjects homepage;
	public static  EnterVehicledataObjects VehiclePage;
	public static  EnterProductDataObjects ProductPage; 
	public static  EnterInsuranceData InsurancePage;
	public static  SelectPricePage Pricepage;
	public CommonMethods Common =  new CommonMethods();
	//I am making it as Static and Initializing here and Declaring in Before Method once driver is Initialized it gets Declred
	
}
