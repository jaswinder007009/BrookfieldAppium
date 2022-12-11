package EXSquared.BrookfieldAppium.extentReports;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import EXSquared.BrookfieldAppium.BaseTest;

public class ExtentReporterNG implements IReporter {
	public ExtentReports extent;
	public ExtentTest test;
	// public static ExtentTest logger;

	// logger =
	// report.startTest(this.getClass().getSimpleName()).assignCategory("Happy
	// Path"));

	// Test Case Usage: Using it at Every Step in Each Test Case
	// logger.log(LogStatus.INFO,"String Message to Log for Each Step in Test
	// Case");

	@BeforeTest
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator + "Brookfield.html", true);
		System.out.println(outputDirectory);
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				try {
					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) throws IOException {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					System.out.println("Testcase name is : " + result.getMethod().getMethodName());

					test.log(status, result.getThrowable());
					//					BaseTest.takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				extent.endTest(test);
			}
		}
	}

	//	public void onTestStart(ITestResult result) {
	//		logger.log(null, null, null);
	//			
	//	}
	//	
	//	 public void reportLog(String message) {    
	//		    logger.log(LogStatus.INFO, message);//For extentTest HTML report
	//		    logger.info("Message: " + message);
	//		    Reporter.log(message);
	//
	//		}
	//	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
//package EXSquared.BrookfieldAppium.extentReports;
//
//import java.io.File;
//
//import org.apache.poi.util.SystemOutLogger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentReporter {
//	
//	
//	public static ExtentReports getReportObject() {
//		String path = System.getProperty("user.dir") + "\\reports\\index.html";
//		System.out.println("path is okok: " + path);
//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		reporter.config().setReportName("BrookfieldAppium Automation results");
//		reporter.config().setDocumentTitle("Results");
//		ExtentReports extent = new ExtentReports();
//		
//		
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Test Engineer", "Jaswinder Singh Chawla");
//		
//		
////	-------------------------------------
//		
//		extent.setSystemInfo("OS : ", System.getProperty("os.name"));
//		extent.setSystemInfo("OS Architecture : ", System.getProperty("os.arch"));
//		extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
//		extent.setSystemInfo("User Name : ", System.getProperty("user.name"));
//		extent.setSystemInfo("Machine Name : ", System.getProperty("machine.name"));
//		extent.setSystemInfo("IP Address : ", System.getProperty("machine.address"));
//
//		System.out.println(System.getProperty("os.name"));
//		System.out.println(System.getProperty("os.arch"));
//		System.out.println(System.getProperty("java.version"));
//		System.out.println(System.getProperty("user.name"));
//		System.out.println(System.getProperty("machine.name"));
//		System.out.println(System.getProperty("os.name"));
//		
//		return extent;
//	}
//}
//package EXSquared.BrookfieldAppium.extentReports;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentReportClass {
//	
//	ExtentReports extent;
//	String path;
//	@BeforeTest
//
//	public void config() {
//		System.out.println("Wait getting path");
//		
////		path1="LL";
//		
//		 path = System.getProperty("user.dir") + "\\reports\\index.html";
//		System.out.println("path is okok: " + path);
//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		reporter.config().setReportName("BrookfieldAppium Automation results");
//		reporter.config().setDocumentTitle("Brookfield Appium Test Results");
//		
//		
//		extent = new ExtentReports();
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Software Test Engineer", "Jaswinder Singh Chawla");
//	}
//	
//	@Test
//	public void initialDemo() throws IOException {
//		
//	//	 extent.createTest(getClass().getSimpleName());
//		//System.out.println("path is this: " + path1);
//		System.out.println("path is this: " + path);
//		System.out.println("3");
//		ExtentTest test = extent.createTest("First Test Case");
//		System.out.println("4");
//
//		WebDriver driver = new ChromeDriver();
//		System.out.println("1");
//		driver.get("https://www.tesla.com");
//		System.out.println("2");
//		System.out.println(driver.getTitle());
//	test.fail("Result not match");
//	test.addScreencastFromPath(path);
//		//System.out.println("path is this: " + path1);
//		//System.out.println("path is this: " + path);
//		extent.flush();
//		
//	}
//
//}
