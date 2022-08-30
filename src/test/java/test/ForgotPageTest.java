package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.ZerodhaForgotPage;
import utility.Parameterization;

public class ForgotPageTest {

	WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser () {
		driver = pojo.LaunchBrowser.launchBrowser();
	}
	
	@Test
	public void zerodhaForgotTest () throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaForgotPage zerodhaforgotpage = new ZerodhaForgotPage(driver);
		
		String user = Parameterization.parameterization("forgot", 0, 1);
		String pan = Parameterization.parameterization("forgot", 1, 1);
		String mob = Parameterization.parameterization("forgot", 2, 1);
		
		zerodhaforgotpage.clickOnForgot();
		Thread.sleep(2000);
		zerodhaforgotpage.switchForgotPage(driver);
		Thread.sleep(1000);
		zerodhaforgotpage.clickOnRememberUser();
		Thread.sleep(2000);
		zerodhaforgotpage.enterUserID(user);
		zerodhaforgotpage.enterPan(pan);
		zerodhaforgotpage.clickOnReceiveOnSMS();
		zerodhaforgotpage.enterAccountEmail(mob);
		Thread.sleep(2000);
		
		
		

	}
}
