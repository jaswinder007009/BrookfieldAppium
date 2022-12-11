package EXSquared.BrookfieldAppium.pages;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import EXSquared.BrookfieldAppium.BRPHelper;
import EXSquared.BrookfieldAppium.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
public class AboutPage extends BaseTest {
	
	
//	BRPHelper brpH;
//	
//	@BeforeMethod
//	public void beforeMethod(Method m) {
//		System.out.println("Before obj creation");
//		System.out.println("After obj creation");
//      System.out.println(m.getName());
//		brpH = new BRPHelper(m);
//		//	System.out.println("After BRP obj creation");
//
//	}
	//class LoginPageElements {
//	@AndroidFindBy(xpath = "com.android.chrome:id/username")
//	public MobileElement userName;
//
//	@AndroidFindBy(xpath = "com.android.chrome:id/password")
//	public MobileElement password;
//
//	@AndroidFindBy(xpath = "android:id/button1")
//	public MobileElement signInButton;
//	
	@CacheLookup												
	@FindBy(css = "button#onetrust-accept-btn-handler")
	public WebElement allowCookies;

	@CacheLookup
	@FindBy(xpath = "//input[@id='fyhSearchTextBox']")
	public WebElement searchButton;

	@FindBy(xpath = "//input[@tabindex='-1']")
	public WebElement searchFieldInput;

	@FindBy(xpath = "//div/div//div//div//div//div//div//div//div[2]//button[contains(@class,'ftr-box-border')]")
	public WebElement filtersBtn;

	@FindBy(xpath = "//h4[@class='ftr-t-base-500 ftr-mb-6']")
	public WebElement priceRange;

	@FindBy(xpath = "//h4[@class='ftr-t-base-500 ftr-mb-4']")
	public WebElement homeType;

	@FindBy(xpath = "//h4[@class='ftr-t-base-500']")
	public WebElement buildStatus;

	@FindBy(xpath = "//h4[@class='ftr-t-base-500 ftr-mb-4' and text()='Beds']")
	public WebElement beds;

	@FindBy(xpath = "//h4[@class='ftr-t-base-500 ftr-mb-4' and text()='Baths']")
	public WebElement baths;

	@FindBy(xpath = "//h4[@class='ftr-t-base-500 ftr-mb-6' and text()='Square Feet']")
	public WebElement squareFeet;

	@FindBy(xpath = "//h4[@class='ftr-t-base-500 ftr-mb-4' and text()='Garage Parking']")
	public WebElement garageParking;

	@FindBy(xpath = "//h4[@class='ftr-t-base-500 ftr-mb-4' and text()='Number of Stories']")
	public WebElement numberOfStories;

	@FindBy(xpath = "//h4[@class='ftr-t-base-500 ftr-mb-4' and text()='Home Tours']")
	public WebElement homeTours;
	
	@FindBy(xpath = "//button[@class='btn primary sm']")
	public WebElement done;

//}

//public class AboutPage extends BaseTest {

	String areaName = "Texas, United States";
	//LoginPageElements ele;

	public AboutPage(AndroidDriver driver) {
		super();
		this.driver = driver;

		//ele = new LoginPageElements();
		PageFactory.initElements(driver, this);
		
	}

	public AboutPage openBRPPage(String url) {
		System.out.println("In openBRPPage");

		// System.out.println(props.getProperty(""));
		driver.get(url);

		return this;
	}

	public AboutPage clickCookiesBtn() throws InterruptedException {
		System.out.println("Clicking cookies");

//		System.out.println(allowCookies);
		// System.out.println(allowCookies.getText());
//		System.out.println(allowCookies.getSize());

		// this.click(allowCookies);
		click(allowCookies);
		System.out.println("button is clicked");
	//	brpH.reportLog("This is the log");
		return this;
	}

	public AboutPage clickSearchField() throws InterruptedException {
		click(searchButton);
		return this;
	}
	
	public AboutPage clickDoneBtn() throws InterruptedException {
		click(done);
		return this;
	}

	public AboutPage clickSearchFieldInput() throws InterruptedException {
		click(searchFieldInput);
		sendKeys(searchFieldInput, areaName);
		return this;
	}

	public AboutPage verifyFilterHeadings() throws InterruptedException, IOException {

//		String priceRangeString= "Price Range";
//		String homeTypeString= "Home Type";
//		String buildStatusString= "Build Status";
//		String bedsString= "Beds";
//		String bathsString= "Baths";
//		String squareFeetString= "Square Feet";
//		String garageParkingString= "Garage Parking";
//		String numberOfStoriesString= "Number of Stories";
//		String homeToursString= "Home Tours";
		sendKeyboardKeys(searchFieldInput, Keys.ENTER);
		System.out.println("Before clicking filter");
		click(filtersBtn);
		System.out.println("After clicking filter");
		click(priceRange);
		
		DataDriven d = new DataDriven();
		ArrayList data = d.getData("Filter Types");
		System.out.println(data);
		Assert.assertEquals(data.get(1), priceRange.getText());
		Assert.assertEquals(data.get(2), homeType.getText());
		Assert.assertEquals(data.get(3), buildStatus.getText());
		Assert.assertEquals(data.get(4), beds.getText());
		Assert.assertEquals(data.get(5), baths.getText());
		Assert.assertEquals(data.get(6), squareFeet.getText());
		Assert.assertEquals(data.get(7), garageParking.getText());
		Assert.assertEquals(data.get(8), numberOfStories.getText());
		Assert.assertEquals(data.get(9), homeTours.getText());
		return this;
		
	}
	
	


//	public AboutPage enterUserEmail(String email) throws InterruptedException {
//		Thread.sleep(5000);
//		// userName.clear();
//		System.out.println(userName);
//		System.out.println("user email" + email);
//		sendKeys(userName, email);
//		System.out.println(userName);
//		return this;
//
//	}
//
//	public AboutPage enterUserPassword(String email) {
//		password.clear();
//		sendKeys(userName, email);
//		return this;
//
//	}
//
//	public AboutPage signInBtn() throws InterruptedException {
//		click(signInButton);
//		return this;
//	}

}