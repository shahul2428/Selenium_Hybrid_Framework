package reusableComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testBase.PageObjectsRepo;

public class ListenersImplement extends PageObjectsRepo implements ITestListener {

	public void onTestStart(ITestResult result) {
		//Before Each Test Cases it will Execute
		 test = Extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "This Test Case : "+result.getMethod().getMethodName()+ " Is Passed ");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "This Test Case : "+result.getMethod().getMethodName()+ " Is failed");
		test.log(Status.FAIL, result.getThrowable());
		//capturescreenShot Cs = new capturescreenShot();
		capturescreenShot.getScreenShot();// Coming from Common Utili
		//if i Create a ScreenShot Logic Here I have to Get the Driver instance for that i have to Move Driver Instance from testBase
		//to PageobjectsRepo even i move No error Comes Bcoz TestBase Extends PageObjectsRepo So Created a Separate Class for screenshot 
		test.addScreenCaptureFromPath(capturescreenShot.getScreenShot());
	}
	

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		//setup Method Call to call iam Making that method as Static
		Extent = ExtentReportMethod.SetupExtentReport();
	}

	public void onFinish(ITestContext context) {
		//Close the Extent
		Extent.flush();
	}
	
	

}
