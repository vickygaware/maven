package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports generateReport () {
		
		ExtentSparkReporter html = new ExtentSparkReporter("ProjectReport.html"); // generates report in HTML format
		ExtentReports reports = new ExtentReports(); // this class collects data required for generating report
		reports.attachReporter(html);
		reports.setSystemInfo("Test Engineer", "Vivek");
		reports.setSystemInfo("Test", "Regression");
		return reports;
		
	}
}
