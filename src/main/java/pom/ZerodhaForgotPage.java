package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaForgotPage {

	@FindBy (xpath = "//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy (xpath = "//input[@label='I remember my user ID']") private WebElement rememberUser;
	@FindBy (xpath = "//input[@label='I forgot my user ID']") private WebElement forgotUser;
	@FindBy (xpath = "//input[@placeholder='User ID']") private WebElement userID;
	@FindBy (xpath = "//input[@placeholder='PAN']") private WebElement pan;
	@FindBy (xpath = "//input[@label='E-mail']") private WebElement receiveOnEmail;
	@FindBy (xpath = "//input[@label='SMS']") private WebElement receiveOnSMS;
	@FindBy (xpath = "//input[@placeholder='E-mail (as on account)']") private WebElement accountEmail;
	@FindBy (xpath = "//img[contains(@src,'data:image')]") private WebElement captchaImage;
	@FindBy (xpath = "//input[@placeholder='Captcha']") private WebElement captcha;
	@FindBy (xpath = "//button[@type='submit']") private WebElement reset;
	@FindBy (xpath = "//a[@class='text-xsmall text-light reset-account-button']") private WebElement backToLogin;
	
	public ZerodhaForgotPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnForgot () {
		forgot.click();
	}
	public void clickOnRememberUser() {
		rememberUser.click();
	}
	public void clickOnForgotUser () {
		forgotUser.click();
	}
	public void enterUserID (String user) {
		userID.sendKeys(user);
	}
	public void enterPan(String panNumber) {
		pan.sendKeys(panNumber);
	}
	public void clickOnReceiveOnEmail() {
		receiveOnEmail.click();
	}
	public void clickOnReceiveOnSMS () {
		receiveOnSMS.click();
	}
	public void enterAccountEmail (String email) {
		accountEmail.sendKeys(email);
	}

	public void clickOnReset () {
		reset.click();
	}
	public void switchForgotPage (WebDriver driver) {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> i = handles.iterator();
		
		while(i.hasNext()) {
			String popUp = i.next();
			driver.switchTo().window(popUp);
			String title = driver.getTitle();
			
			if (title.equals("https://kite.zerodha.com/forgot"))
			{
				break;
			}
		}
	
	}
	}
