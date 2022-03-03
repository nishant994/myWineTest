package Reusableintity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Reusability {

	// ######### Below function is to wait for page load to get elements enabled for almost 21 seconds #######
	public static boolean waitPeriod(WebDriver driver, String objectElement) throws InterruptedException{
		boolean isElelmentpresent = true;

		int index=0;

		while (index<8) {
			try {

				boolean stsusabc=driver.findElement(By.xpath(objectElement)).isEnabled();

				break;
			} catch (Exception e) {

				if (index<7) {
					Thread.sleep(3000);
					index++; 
					continue;
				} else {
					isElelmentpresent=false;
					break;
				}


			}

		}

		return isElelmentpresent;
	}


	// ######### Below function is to click on an element #######
	public  Reusability clickElement(WebDriver driver, String element) throws InterruptedException {

		boolean isElementPresent=waitPeriod(driver,element);	//waiting for an element for 30 seconds if its present

		try {
			if (isElementPresent) {

				driver.findElement(By.xpath(element)).click(); //Click on the element

			} else {

				System.out.println("Element not present");

			}
		} catch (Exception e) {
			System.out.println("Something wired happened");


		}

		return this;

	}

	// ######### Below function is to Enter a value into a text field #######

	public  Reusability EnterValue(WebDriver driver, String element, String Value) throws InterruptedException {

		boolean isElementPresent = waitPeriod(driver,element);	//waiting for an element for 30 seconds if its present

		try {
			if (isElementPresent) {

				driver.findElement(By.xpath(element)).sendKeys(Value); //enter the value
				System.out.println("Value: "+Value+" successfully enterd");

			} else {

				System.out.println("Element not present");

			}
		} catch (Exception e) {
			System.out.println("Something wired happened");


		}

		return this;

	}	
	
	public  Reusability EnterValueandPressEnter(WebDriver driver, String element, String Value) throws InterruptedException {

		boolean isElementPresent = waitPeriod(driver,element);	//waiting for an element for 30 seconds if its present

		try {
			if (isElementPresent) {

				driver.findElement(By.xpath(element)).sendKeys(Value); //enter the value
				Thread.sleep(2000);
				driver.findElement(By.xpath(element)).sendKeys(	Keys.ENTER);
				System.out.println("Value: "+Value+" successfully enterd");

			} else {

				System.out.println("Element not present");

			}
		} catch (Exception e) {
			System.out.println("Something wired happened");


		}

		return this;

	}	

}
