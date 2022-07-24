package reusableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.PageObjectsRepo;

public class ExtentReportMethod extends PageObjectsRepo {

	public static ExtentReports SetupExtentReport() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		String actualDate = format.format(date);
		
		
		String ReportPath = System.getProperty("user,dir")+"/Reports/ExecutionReport_"+actualDate+".html";
		ExtentSparkReporter SparkReporter = new ExtentSparkReporter(ReportPath);
		Extent = new ExtentReports();
		Extent.attachReporter(SparkReporter);
		
		SparkReporter.config().setDocumentTitle("DocumentTitle");//Tab name
		SparkReporter.config().setTheme(Theme.DARK);
		SparkReporter.config().setReportName("ReporterName");//
// Make it as Public in PageObjectRepo		
	return 	Extent;
	}
	
}
