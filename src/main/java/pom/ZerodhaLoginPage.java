package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {

	@FindBy (xpath = "//input[@id='userid']") private WebElement userName;
	@FindBy (xpath = "//input[@id='password']") private WebElement password;
	@FindBy (xpath = "//button[@type='submit']") private WebElement submit;
	@FindBy (xpath = "//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy (xpath = "//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp;
	@FindBy (xpath = "//input[@id='pin']") private WebElement pin;
	@FindBy (xpath = "//button[@type='submit']") private WebElement submitPin;
	
	public ZerodhaLoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName (String user) {
		userName.sendKeys(user);
	}
	
	public void enterPassword (String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnSubmit() {
		submit.click();
	}
	
	public void clickOnForgot () {
		forgot.click();
	}
	
	public void signUp () {
		signUp.click();
	}
	
	public void enterPin(String pinNumber, WebDriver driver) {
		// explicit waits can be used for single element
		// it checks if element is located after every 500ms
		// it is mostly used waits
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(pin));
		
		// Fluent wait is same as explicit wait but we can decide the polling time (scan time) in fluent wait
		// after each cycle of polling time we have to handle all exception of class by ignoring it
		
//		FluentWait<WebDriver> wait1 = new FluentWait<WebDriver>(driver);
//		wait1.withTimeout(Duration.ofMillis(2000));
//		wait1.pollingEvery(Duration.ofMillis(100));
//		wait1.ignoring(Exception.class);
//		wait1.until(ExpectedConditions.visibilityOf(pin));
		
		pin.sendKeys(pinNumber);
	}
	
	public void clickOnContinue () {
		submitPin.click();
	}
	
	
		
		
		
	}

