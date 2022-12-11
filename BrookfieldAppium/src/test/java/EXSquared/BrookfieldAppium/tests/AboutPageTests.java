package EXSquared.BrookfieldAppium.tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import EXSquared.BrookfieldAppium.BRPHelper;
import EXSquared.BrookfieldAppium.BaseTest;
import EXSquared.BrookfieldAppium.pages.AboutPage;
import io.appium.java_client.android.AndroidDriver;

public class AboutPageTests extends BaseTest {
	AboutPage openBRPURL;
	//public ExtentTest logger;
	//public ExtentReports report;
	BRPHelper brpH;
	

	
	@BeforeMethod
	public void beforeMethod(Method m) {
		System.out.println("Before obj creation");
		openBRPURL = new AboutPage((AndroidDriver) driver);
		System.out.println("After obj creation");
		System.out.println("Before BRP obj creation");
        System.out.println(m.getName());
		 brpH = new BRPHelper(m);
		//	System.out.println("After BRP obj creation");

	}
	
	

	@AfterMethod
	public void afterMethod() {
	}

	@Test(priority = 1)
	public void goingToLoginPage() throws InterruptedException {
		System.out.println("Before logging");
		

		System.out.println("In Test");

		System.out.println("After object initialization");
		openBRPURL.openBRPPage(props.getProperty("BrookfieldHomePage"));
		
		System.out.println("On Brookfield Residential Page");
		openBRPURL.clickCookiesBtn();
		
		openBRPURL.clickSearchField();
		openBRPURL.clickSearchFieldInput();
		System.out.println("Before log print");
		brpH.reportLog("This is the log");
		System.out.println("After log print");

		//brpH.reportLog("fdnkjnfdiffudnifun");
	}
	
//	@Test(priority = 2)
//	public void filterPageTests() throws InterruptedException, IOException {
//		openBRPURL.verifyFilterHeadings();
//		openBRPURL.clickDoneBtn();
//		DataDriven d = new DataDriven();
//		ArrayList data = d.getData("Accept Cookies");
//		System.out.println(data.get(0));
//		System.out.println(data.get(1));
//		System.out.println(data.get(2));
//		System.out.println(data.get(3));
//		System.out.println(data.get(4));
//		System.out.println(data.get(5));
//		
//	}
//	
//	@Test(priority = 3)
//	public void dataProviderTesting() throws InterruptedException, IOException {
//		System.out.println();
//		
//	}
	
	

	

//	@Test(priority = 3)
//	public void filter() throws InterruptedException, IOException {
//		openBRPURL.verifyFilterHeadings();
//		
//	
//		
//	}
	
	
	
	
//	  @Test(priority = 2)
//	  public void logInChrome() throws InterruptedException {
//		  System.out.println(props.getProperty("Username"));
//	 	  openBRPURL.enterUserEmail(props.getProperty("Username"));
//	 	  openBRPURL.enterUserPassword(props.getProperty("Password"));
//	 	  openBRPURL.signInBtn();
//	  }

	/*
	 * @Test(priority = 2) public void allowCookies() throws InterruptedException {
	 * 
	 * System.out.println("In Test"); AboutPage openBRPURL = new AboutPage();
	 * System.out.println("After object initialization"); //openBRPURL.Skip12();
	 * System.out.println("On Login Page"); }
	 */

	/*
	 * @Test(priority = 3) public void 3() throws InterruptedException {
	 * 
	 * System.out.println("In Test"); AboutPage openBRPURL = new AboutPage();
	 * System.out.println("After object initialization"); openBRPURL.Skip12();
	 * System.out.println("On Login Page"); }
	 * 
	 * @Test(priority = 4) public void 4() throws InterruptedException {
	 * 
	 * System.out.println("In Test"); AboutPage openBRPURL = new AboutPage();
	 * System.out.println("After object initialization"); openBRPURL.Skip12();
	 * System.out.println("On Login Page"); }
	 * 
	 * @Test(priority = 1) public void goingToLoginPage() throws
	 * InterruptedException {
	 * 
	 * System.out.println("In Test"); AboutPage openBRPURL = new AboutPage();
	 * System.out.println("After object initialization"); openBRPURL.Skip12();
	 * System.out.println("On Login Page"); }
	 * 
	 * @Test(priority = 1) public void goingToLoginPage() throws
	 * InterruptedException {
	 * 
	 * System.out.println("In Test"); AboutPage openBRPURL = new AboutPage();
	 * System.out.println("After object initialization"); openBRPURL.Skip12();
	 * System.out.println("On Login Page"); }
	 */
	
	//test fyh page
	
}