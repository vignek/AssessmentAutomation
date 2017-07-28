package test;

import org.testng.Assert;
import org.testng.annotations.*;

public class AssessmentTest extends AbstractWebDriverTest	{

	@Test (priority=1)
	public void verifySearchResultGreaterThanZero()	{
		listingsCount = onSearchPage.getNumberOfListings();
		Assert.assertTrue(listingsCount > 0,"Error : Search returns 0");
	}

	@Test (priority=2)
	public void verifySearchPriceMatchesViewDetailsPrice()		{		
		priceOnSearchPage = onSearchPage.getPriceOfSecondListing();	
		onViewDetailsPage = onSearchPage.clickOnSecondListing();		
		priceOnViewDetails = onViewDetailsPage.getListingPrice();
		Assert.assertEquals(priceOnViewDetails, priceOnSearchPage ,  "Error : Listing price mismatch between Search Page and View Details Page"); 	
	}

}