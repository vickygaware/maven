package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.Parameterization;
import utility.Reports;
import utility.ScreenShot;

public class LoginPageTest {
	
	ExtentReports reports;
	ExtentTest test;
	
	WebDriver driver;
	
	@BeforeTest
	public void addReports() {
		reports = Reports.generateReport(); 
	}

	@BeforeMethod
	public void launchBrowser () {
		driver = LaunchBrowser.launchBrowser();
	}
	
	@DataProvider (name="DataForTest")
	
	public Object[] [] data () {
		return new Object [] [] {{ 5,10,"Velocity"},{40,2,"Katraj"}, {50,5,"Pune"}};
	}
	
	
	@Test (dataProvider = "DataForTest")
	public void data (int a, int b, String s) {
		test = reports.createTest("Data");
		System.out.println(a+b);
		System.out.println(s);
	}
	
	
	@Test
	
	public void ZerodhaLoginTest () throws EncryptedDocumentException, IOException, InterruptedException {
		test = reports.createTest("ZerodhaLoginTest");
		ZerodhaLoginPage zerodhaLoginpage = new ZerodhaLoginPage (driver);
		String user = Parameterization.parameterization("Sheet1", 0, 1);
		String pass = Parameterization.parameterization("Sheet1", 1, 1);
		String pin = Parameterization.parameterization("Sheet1", 2, 1);
		
		zerodhaLoginpage.enterUserName(user);
		zerodhaLoginpage.enterPassword(pass);
		zerodhaLoginpage.clickOnSubmit();
		//Thread.sleep(1000); (used explicit waits instead of thread sleep)
		zerodhaLoginpage.enterPin(pin,driver);
		zerodhaLoginpage.clickOnContinue();
		
	}
	
	@AfterMethod
	public void Screenshot () throws IOException {
		ScreenShot.takeScreenShot(driver, null);
	}
	
	@AfterTest
	public void flush () {
		reports.flush();
	}
}
