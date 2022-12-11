package EXSquared.BrookfieldAppium.dataProvider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import EXSquared.BrookfieldAppium.pages.DataProvide;

public class DataProvideTests {

	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "driveTest", dataProviderClass = DataProvide.class, description = "Verify excel class data provider stratergy")
	public void testCaseData(String salutation, String type, String i) {
		System.out.println(salutation + " : " + type + " : " + i);
	}
	
	
	
	@Test(dataProvider = "driveTest1", description = "Verify obj data provider stratergy")
	public void objectDataProvider(String salutation, String type, int i) {
		System.out.println(salutation + " : " + type + " : " + i);
	}
	
	//Data provider in object form
	@DataProvider(name = "driveTest1")
	public Object[][] getData1()
	{
		//Object is super set of all data types 
		Object [][] data ={{"hello", "text", 1},{"bye","message",143},{"solo","call",4434}};
		
	 
		return data;
	}

}