package EXSquared.BrookfieldAppium.excelTestData;

import java.io.IOException;
import java.util.ArrayList;

import EXSquared.BrookfieldAppium.pages.DataDriven;

public class DataDrivenTests {

	public static void main (String args[]) throws IOException {
		DataDriven d = new DataDriven();
		ArrayList data = d.getData("Accept cookies");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println(data.get(4));
		System.out.println(data.get(5));

	}
}
