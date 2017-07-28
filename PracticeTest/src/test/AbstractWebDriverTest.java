package test;

import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LandingPage;
import pageObjects.SearchPage;
import pageObjects.ViewDetailsPage;
import util.PropertyManager;

public class AbstractWebDriverTest {

	public static WebDriver driver;
	public static PropertyManager prop; 

	protected static LandingPage onLandingPage;
	protected static SearchPage onSearchPage;
	protected static ViewDetailsPage onViewDetailsPage;

	int listingsCount;
	int priceOnSearchPage;
	int priceOnViewDetails;

	@Parameters("browser")

	@BeforeClass
	public static void setUp(String browser) {
		prop = new PropertyManager();
		
		Set<PosixFilePermission> perms = new HashSet<>();
		perms.add(PosixFilePermission.OWNER_EXECUTE);
		File file = new File (System.getProperty("user.dir") + "//resources//geckodriver");
		File fileTwo = new File (System.getProperty("user.dir") + "//resources//geckodriver");
		try {
			Files.setPosixFilePermissions(file.toPath(), perms);
			Files.setPosixFilePermissions(fileTwo.toPath(), perms);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//resources//geckodriver");
			driver = new FirefoxDriver();
		} 

		if (browser.equalsIgnoreCase("chrome")) { 
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver");
			driver = new ChromeDriver();
		} 

		onLandingPage = new LandingPage(driver);
		onLandingPage.navigateToWebApp();
		onSearchPage = onLandingPage.performSearch();

	}

	@AfterClass
	public static void shutDown() {
		driver.close();
		driver.quit(); 
	}
}