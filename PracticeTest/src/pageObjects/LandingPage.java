package pageObjects;

import org.openqa.selenium.*;

public class LandingPage extends AbstractPage {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public SearchPage performSearch() {
		type(By.id(prop.get("searchBox")), prop.get("location") );
		type(By.id(prop.get("searchBox")),Keys.RETURN);
		return new SearchPage(driver);
	}

}