package EXSquared.BrookfieldAppium;

import java.lang.reflect.Method;

import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BRPHelper {

	public ExtentTest test;

	public BRPHelper(Method method) {
		test = BaseTest.extent.startTest(method.getName());
	}


	//Method for adding logs passed from test cases
	public void reportLog(String message) {   

		System.out.println("Inside the report log method and message is 1 : " + message );
		// test.log(Status.INFO,"createTest() method will return the ExtentTest object");
		// test.log(Status.INFO, "I am in actual Test");
		System.out.println("Inside the report log method and message is 2 : " + message );

		System.out.println("Inside the report log method and message is 3 : " + message );

		System.out.println("Inside the report log method and message is 4 : " + message );
		test.log(LogStatus.PASS, "Passing");
		test.log(LogStatus.FAIL, "Failing");
		test.log(LogStatus.INFO, message);//For extentTest HTML report
		test.log(LogStatus.FAIL, "Failing");
		//test.INFO("Message: " + message);
		System.out.println("Inside the report log method and message is 5 : " + message + " " +  LogStatus.INFO + " " +  LogStatus.WARNING + " " +  LogStatus.PASS + " " +  LogStatus.FAIL + " " +  LogStatus.SKIP);

	//	Reporter.log(message);
		System.out.println("Inside the report log method and message is 6 : " + message );

	}


}
