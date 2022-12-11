package EXSquared.BrookfieldAppium.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.ITest;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;

import EXSquared.BrookfieldAppium.BaseTest;
//import EXSquared.BrookfieldAppium.extentReports.ExtentReporter;
import io.appium.java_client.AppiumDriver;

public class Listeners extends BaseTest implements ITestListener{
    //ExtentTest test;
	//ExtentReports extent = ExtentReporter.getReportObject(); 
	public void onTestStart(ITestResult result) {
		//test = extent.createTest(result.getMethod().getMethodName());
			
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		try {
			BaseTest.takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		//test.log(Status.FAIL, "Test Failed");
//		test.fail(result.getThrowable());
//		String filePath = null;
//		try {
//			driver =  (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			System.out.println("Try 1 path: " + filePath);
//			System.out.println(filePath);
//			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
//			System.out.println("Try 2 path: " + getScreenshot(result.getMethod().getMethodName(), driver));
//
//
//			System.out.println(filePath);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	
//		try {
//			System.out.println("In try before ss method");
//			System.out.println("Try 2 path In try before ss method: " + filePath);
//			test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
//			System.out.println("In try after ss method path" + filePath);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//extent.flush();
	}


}

//
//package EXSquared.BrookfieldAppium.listeners;
//
//import java.io.IOException;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.internal.annotations.ITest;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//import EXSquared.BrookfieldAppium.BaseTest;
////import EXSquared.BrookfieldAppium.extentReports.ExtentReporter;
//import io.appium.java_client.AppiumDriver;
//
//public class Listeners extends BaseTest implements ITestListener{
//    ExtentTest test;
//	ExtentReports extent = ExtentReporter.getReportObject(); 
//	@Override
//	public void onTestStart(ITestResult result) {
//		test = extent.createTest(result.getMethod().getMethodName());
//			
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//		test.log(Status.PASS, "Test Passed");
//	}
//	
//	@Override
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		test.log(Status.FAIL, "Test Failed");
//		test.fail(result.getThrowable());
//		String filePath = null;
//		try {
//			driver =  (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			System.out.println("Try 1 path: " + filePath);
//			System.out.println(filePath);
//			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
//			System.out.println("Try 2 path: " + getScreenshot(result.getMethod().getMethodName(), driver));
//
//
//			System.out.println(filePath);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	
//		try {
//			System.out.println("In try before ss method");
//			System.out.println("Try 2 path In try before ss method: " + filePath);
//			test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
//			System.out.println("In try after ss method path" + filePath);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		// TODO Auto-generated method stub
//		//extent.flush();
//	}
//
//
//}
