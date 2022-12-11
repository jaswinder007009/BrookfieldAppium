package EXSquared.BrookfieldAppium;

public class Check {
	public static void main (String args[]) {
		System.out.println("Yes");
		String path;
		String path1;
		String path2;
		String path3;
		String path4;
		
		path = System.getProperty("user.dir") + "\\reports\\index.html";
		path1 = System.getProperty("C:\\Users\\jschawla\\eclipse-workspace\\BrookfieldAppium\\reports\\index.html");

		path2 = System.getProperty("C://Users//jschawla//eclipse-workspace//BrookfieldAppium//reports//index.html");

		path3 = System.getProperty("user.dir") + "//reports//index.html";

		path4 = System.getProperty("user.dir") + "//reports//index.html";

		
		System.out.println(path);
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(path3);
		System.out.println(path4);
		

	}

}
