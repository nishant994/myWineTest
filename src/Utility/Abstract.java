package Utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import DatadrivenUtils.DataMine;
import Drivers.Managedriver;

public class Abstract {
	
	protected WebDriver driver=null;
	public String searchKey = null;
	public String URL = null;
	@BeforeSuite
	public void configbeforeTestExe() {
	
		Managedriver managedriver = new Managedriver();
		driver = managedriver.setupdriver();
		
		
		DataMine data = new DataMine();
		searchKey=data.readProperty("SearchKey");
		URL=data.readProperty("URL");
		
	}

}
