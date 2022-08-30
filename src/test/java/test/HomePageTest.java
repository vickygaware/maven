package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Base;
import utility.Parameterization;
import utility.Reports;
@Listeners(utility.Listeners.class)

public class HomePageTest extends Base {

	ExtentReports reports;
	ExtentTest test;
	
	
	
	@BeforeTest
	public void addReports() {
		reports = Reports.generateReport(); 
	}
	
	
	@BeforeMethod
	public void launchBrowser() throws EncryptedDocumentException, IOException {
		driver = LaunchBrowser.launchBrowser();
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage (driver);
		String email = Parameterization.parameterization("Sheet1", 0, 1);
		String pass = Parameterization.parameterization("Sheet1", 1, 1);
		String pin = Parameterization.parameterization("Sheet1", 2, 1);
		zerodhaloginpage.enterUserName(email);
		zerodhaloginpage.enterPassword(pass);
		zerodhaloginpage.clickOnSubmit();
		zerodhaloginpage.enterPin(pin, driver);
		zerodhaloginpage.clickOnContinue();
	}
	
	@Test
	public void searchStock () {
		test = reports.createTest("searchStock");
		ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
		zerodhahomepage.searchStock("Reliance", driver);
		int number = zerodhahomepage.getSearchResultNumber();
		Assert.assertTrue(number > 0);
	}
	
	@Test
	public void searchStockAndClickOnBuy() {
		test = reports.createTest("searchStockAndClickOnBuy");
		ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
		zerodhahomepage.searchStock("TATA", driver);
		zerodhahomepage.searchAndSelectDesiredStock(driver, "TATAPOWER");
		zerodhahomepage.clickOnSearchResult();
		zerodhahomepage.enterQuantityOfStock("20");
		zerodhahomepage.clickOnStopLoss();
		zerodhahomepage.enterPrice("230");
		zerodhahomepage.entertriggerPrice("228", driver);
		zerodhahomepage.clickOnBuy();
	}
	
	@AfterMethod
	public void postTest (ITestResult result) {
		if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName()); // result when test is passed
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName()); // result when test is failed
		}
		else
			test.log(Status.SKIP, result.getName()); // result when test is skipped
	}
	
	@AfterTest
	public void flushReport () { // flush is used to send the collected data to ExtentSparkReporter
		reports.flush();
	}
	
}
