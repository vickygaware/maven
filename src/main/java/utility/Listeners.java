package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Listeners extends Base implements ITestListener {
	
	// Listener is interface which is implemented in ITestListener interface
	// ItestListener methods are as given below
	// ITestResult is passed in argument of methods as it provides result of code execution
	
	
	public void onTestStart(ITestResult result) {      // it executes when test start
		System.out.println("Test Started" +  result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {    // it executes when test is passed
		System.out.println("Test Passed" +  result.getName());
	}
	
	public void onTestFailure(ITestResult result)  {   // it executes when test is failed
		try {
			ScreenShot.takeScreenShot(driver,  result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test Failed" +  result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {    // it executes when test is skipped
		System.out.println("Test Skipped" +  result.getName());
	}
}
