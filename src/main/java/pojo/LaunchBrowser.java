package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	
	public static WebDriver launchBrowser () {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.navigate ().to("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000)); // implicit waits are universal waits
		// as it is applicable for each execution
		// it is not used more as it has disadvantage of being used where it is not required
		// it throws exception after given timeout
		return driver;
	}
}
