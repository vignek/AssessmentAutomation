package pageObjects;

import org.openqa.selenium.*;

public class SearchPage extends AbstractPage {

	int priceInSearchResult;
	WebElement anchor;

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public int getNumberOfListings() {
		wait(By.id(prop.get("searchCount")),"Error : Count of Listings in Search page not found" );				
		int searchResultCount = toNumber(getValue(By.id(prop.get("searchCount"))));				
		return searchResultCount;
	}

	public int getPriceOfSecondListing(){
		sleep();
		return priceInSearchResult =  toNumber(getValue(By.xpath(prop.get("secondItemPrice"))));
	}

	public ViewDetailsPage clickOnSecondListing() {
		click(By.xpath(prop.get("secondItemOverlay")));
		return new ViewDetailsPage(driver);
	}	

}