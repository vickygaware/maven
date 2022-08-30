package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

public static void takeScreenShot (WebDriver driver, String name) throws IOException {
		
		
		TakesScreenshot sc = ((TakesScreenshot)driver); // Upcasting driver to TakesScreenshot
		
		File source = sc.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("H:\\Vivek course\\ScreenShot\\"+name+".jpg");
		
		FileHandler.copy(source, destination);
	}
}
