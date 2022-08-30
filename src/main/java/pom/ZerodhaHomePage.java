package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {

	@FindBy (xpath = "//input[@type='text']") private WebElement search;
	@FindBy (xpath = "//span[@class='tradingsymbol']") private List<WebElement> searchResult;
	@FindBy (xpath = "//button[@data-balloon='Buy']") private WebElement searchBuy;
	
	@FindBy (xpath = "(//input[@type='number'])[1]") private WebElement quantity;
	@FindBy (xpath = "(//label[@class='su-radio-label'])[11]") private WebElement stopLoss;
	@FindBy (xpath = "(//input[@type='number'])[2]") private WebElement price;
	@FindBy (xpath = "(//input[@type='number'])[3]") private WebElement triggerPrice;
	@FindBy (xpath = "//button[@type='submit']") private WebElement buy;
	
	public ZerodhaHomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchStock (String stock, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(stock);
	}
	public int getSearchResultNumber () {
		int listSize = searchResult.size();
		return listSize;
	}
	
	public void searchAndSelectDesiredStock (WebDriver driver, String requiredStock) {
		
		for (int a = 0 ; a < searchResult.size(); a++) {
			WebElement s = searchResult.get(a);
			String stockName= s.getText();
			
			if (stockName.equals(requiredStock)) {
				Actions action = new Actions(driver);
				action.moveToElement(s);
				action.perform();
				break;
			}
		}
	}
	public void clickOnSearchResult () {
		searchBuy.click();
	}
	
	public void enterQuantityOfStock(String qty) {
		quantity.sendKeys(qty);
	}
	
	public void clickOnStopLoss() {
		stopLoss.click();
	}
	
	public void enterPrice(String money)  {
		price.clear();
		price.sendKeys(money);
	}
	
	public void entertriggerPrice(String triggermoney, WebDriver driver)  {
		
		Actions action = new Actions(driver);
		action.sendKeys(triggerPrice,Keys.BACK_SPACE);
		action.sendKeys(triggerPrice,Keys.BACK_SPACE);
		action.sendKeys(triggerPrice,Keys.BACK_SPACE);
		action.sendKeys(triggerPrice,Keys.BACK_SPACE);
		action.sendKeys(triggerPrice,Keys.BACK_SPACE);
		action.build().perform();

		triggerPrice.sendKeys(triggermoney);
	}
	
	public void clickOnBuy() {
		buy.click();
	}
}
