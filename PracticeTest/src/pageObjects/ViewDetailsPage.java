package pageObjects;

import org.openqa.selenium.*;

public class ViewDetailsPage extends AbstractPage {

	int priceInViewDetails;

	public ViewDetailsPage(WebDriver driver) {
		super(driver);
	}

	public int getListingPrice() {
		priceInViewDetails =  toNumber(getValue(By.cssSelector(prop.get("listingPrice"))));
		return priceInViewDetails;
	}

}
