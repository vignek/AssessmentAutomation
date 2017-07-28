package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import test.AbstractWebDriverTest;

public class AbstractPage extends AbstractWebDriverTest {

	public AbstractPage(WebDriver driver) {
		AbstractWebDriverTest.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public LandingPage navigateToWebApp() {

		driver.navigate().to(prop.get("base_url"));
		driver.manage().window().maximize();

		return new LandingPage(driver);
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public void type(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	public void type(By by, Keys value) { 
		driver.findElement(by).sendKeys(value);
	}

	public void navigate(String url) {
		driver.navigate().to(url);
	}

	public String getValue(By by) {
		String result = driver.findElement(by).getText();	
		return result;
	}

	public void wait(By by, String exception) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));

		}  catch(Exception e) {
			System.err.println(exception);
		}
	}

	public void sleep() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public int toNumber(String input) {
		String temp = input.replaceAll("\\D+","");	
		int output =  Integer.parseInt(temp);
		return output;
	}

}