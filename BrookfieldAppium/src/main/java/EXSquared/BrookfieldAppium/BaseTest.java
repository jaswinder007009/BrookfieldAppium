package EXSquared.BrookfieldAppium;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.XmlFactoryHook.ThreadContext;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.collect.ImmutableMap;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import EXSquared.BrookfieldAppium.extentReports.ExtentReporterNG;
import EXSquared.BrookfieldAppium.pages.AboutPage;
import EXSquared.BrookfieldAppium.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {
	BRPHelper brpH;
	private static AppiumDriverLocalService server;

	public static AppiumDriver driver;
	public Properties props;
	public static InputStream inputStream;
	InputStream stringsis;
	TestUtils utils;
	public static ExtentReports extent;


	public BaseTest() {
		System.out.println("Test BaseTest");
		PageFactory.initElements(driver, this);
		//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	//@BeforeSuite
//	public static void ExtentReportsMethod() {
//		ExtentReports extent;
//		extent = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\Brookfield.html", true);
//		//System.out.println(System.getProperty("user.dir"));
//		//System.out.println(System.getProperty("user.dir") + "\\test-output\\Brookfield.html" + "this is full path" + System.getProperty("user.dir") + "//test-output//ExtentReport//ExtentReport.html");
//		extent.addSystemInfo("User Name", "Jas");
//
//		extent.loadConfig(new File(System.getProperty("user.dir") + "//extent-config.xml"));
//	}

  @BeforeSuite
	public void beforeSuite() throws Exception, Exception {
		//	ThreadContext.put("ROUTINGKEY", "ServerLogs");
		//server = getAppiumService(); // -> If using Mac, uncomment this statement and comment below statement
		server = getAppiumServerDefault(); // -> If using Windows, uncomment this statement and comment above statement
		if(!checkIfAppiumServerIsRunnning(4723)) {
			server.start();
			server.clearOutPutStreams(); // -> Comment this if you don't want to see server logs in the console
			//utils.log().info("Appium server started");
		} else {
			//	utils.log().info("Appium server already running");
		}	
		
		extent = new ExtentReports(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "ExtentReports" + File.separator + "Brookfield.html", true);
		extent.addSystemInfo("User Name", "Jas");
		extent.loadConfig(new File(System.getProperty("user.dir") + "//extent-config.xml"));
	}
  
  
//	@BeforeMethod
//	public void beforeMethod(Method m) {
//		System.out.println("Before obj creation");
//		System.out.println("After obj creation");
//      System.out.println(m.getName());
//		brpH = new BRPHelper(m);
//		//	System.out.println("After BRP obj creation");
//
//	}
//	

	public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
		boolean isAppiumServerRunning = false;
		ServerSocket socket;
		try {
			socket = new ServerSocket(port);
			socket.close();
		} catch (IOException e) {
			System.out.println("1");
			isAppiumServerRunning = true;
		} finally {
			socket = null;
		}
		return isAppiumServerRunning;
	}



	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}

	@BeforeTest
	public AppiumDriver beforeTest(@Optional String platformName, @Optional String platformVersion,
			@Optional String deviceName, @Optional String browserName) throws Exception {

		try {
			props = new Properties();
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			props.load(inputStream);

			System.out.println("test");
			System.out.println(" : " + ":" + props.getProperty("AppiumURL"));
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", props.getProperty("PlatformName"));
			desiredCapabilities.setCapability("platformVersion", props.getProperty("PlatformVersion"));
			desiredCapabilities.setCapability("deviceName", props.getProperty("DeviceName"));
			desiredCapabilities.setCapability("browserName", props.getProperty("BrowserName"));
			desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

			URL url = new URL(props.getProperty("AppiumURL"));
			System.out.println("Before Cookie check");

			desiredCapabilities.setCapability("autoAcceptAlerts", "true");
			System.out.println("After Cookie check");

			driver = new AndroidDriver(url, desiredCapabilities);
			System.out.println("OK fine");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		System.out.println("OK fine base");
		return driver;
	}

	public void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void click(WebElement generic) throws InterruptedException {
		System.out.println("trying to click button");

		System.out.println("1");
		waitForVisibility(generic);
		System.out.println("6");

		generic.click();

	}

	public void sendKeys(WebElement userName, String txt) {
		waitForVisibility(userName);
		userName.sendKeys(txt);
	}

	public void sendKeyboardKeys(WebElement userName, Keys key) {
		waitForVisibility(userName);
		userName.sendKeys(key);
	}

	public void getAttribute(WebElement e, String attribute) {
		waitForVisibility(e);
		e.sendKeys(attribute);
	}


	public static void takeScreenshotAtEndOfTest(String testCaseName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("This is : " + scrFile);
		String currentDir = System.getProperty("user.dir");
		System.out.println("This is : " + currentDir);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd.HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  

		FileUtils.copyFile(scrFile, new File(currentDir + "\\reports\\" +  testCaseName + "." + dtf.format(now) + ".png"));
	}

	//	 public void reportLog(String message) {
	//		    message = BREAK_LINE + message;
	//		    logger.info("Message: " + message);
	//		    Reporter.log(message);
	//		}





	@AfterTest
	public void afterTest() {
		// driver.quit();
	}
	
	@AfterSuite (alwaysRun = true)
	public void afterSuite() {
		if(server.isRunning()){
			server.stop();
			// utils.log().info("Appium server stopped");
		}
		
		extent.flush();
	}

}




//For avent extent
//public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
//	TakesScreenshot ts = (TakesScreenshot)driver;
//	File source = ts.getScreenshotAs(OutputType.FILE);
//	File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
//	FileUtils.copyFile(source, file);
//	System.out.println("in get ss method" );
//	System.out.println("sys prop" + System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
//	return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
//	
//}
