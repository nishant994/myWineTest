package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Managedriver {
	
	public WebDriver setupdriver () {
		
		
		 System.setProperty("webdriver.chrome.driver",
				  "src\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  return driver;
		
	}

}
