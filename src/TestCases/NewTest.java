package TestCases;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObjects.PageElements;
import Reusableintity.Reusability;
import Utility.Abstract;

public class NewTest extends Abstract{
	@SuppressWarnings("static-access")
	@Test
	public void wineTest() throws InterruptedException {

		String resultwineCountry=null;
		String resultwineName = null;

		Reusability command = new Reusability();

		driver.get(URL);

		command.EnterValueandPressEnter(driver, PageElements.SearchField(),  searchKey);

		//############################# Below code is to listout the Wine name ##################################
		List<WebElement> wineelement=driver.findElements(By.xpath(PageElements.allwinesOnSearchresult()));
		System.out.println("size==========="+wineelement.size());
		List<String> winelist = new ArrayList<String>();

		for(WebElement wineelementVlaue:wineelement ) {
			winelist.add(wineelementVlaue.getText());
			System.out.println(wineelementVlaue.getText());
		}

		//##################### Below code is to listout the corresponding country name ###########################
		List<WebElement> countryelement=driver.findElements(By.xpath(PageElements.allwinesCountrynameOnSearchresult()));

		List<String> countryList = new ArrayList<String>();
		for(WebElement countryelementVlaue:countryelement ) {
			countryList.add(countryelementVlaue.getText());
			System.out.println(countryelementVlaue.getText());
		}	  


		//############### Adding wine name and corresponding country into a 2 dimentional array ###########
		String arr[][] = new String[countryelement.size()][2]; 
		for (int i = 0; i < countryList.size(); i++) { 
			arr[i][0]=winelist.get(i);
			arr[i][1]=countryList.get(i);
		} 

		//##################### Below code is to Select first result and Store name and country of the wine


		command.clickElement(driver, PageElements.firstResultWine());
		// driver.findElement(By.xpath("//a[@data-cartitemsource='text-search'][1]")).click();

		boolean iselementpresent = command.waitPeriod(driver, PageElements.selectedWineCountry());
		if (iselementpresent) {
			resultwineCountry=driver.findElement(By.xpath(PageElements.selectedWineCountry())).getText();

		} else {
			System.out.println("######No Search wine country availevale#####");
		}

		boolean iswinetryelementpresent = command.waitPeriod(driver, PageElements.selectedWineName());
		if (iswinetryelementpresent) {
			resultwineName=driver.findElement(By.xpath(PageElements.selectedWineName())).getText();
		} else {
			System.out.println("######No Search wine name availevale#####");
		}


		// ################### Below Code is to match the selected wine from the list ##########################


		for (int i = 0; i < arr.length; i++) { 
			if (arr[i][0].contentEquals(resultwineName) && arr[i][1].contains(resultwineCountry)) {

				System.out.println("¤¤¤ Congratulattion there is a search match!!!");
			} else {
				System.out.println("¤¤¤ Oops there is no search match!!!! ¤¤¤¤¤");
			} }

	}
}	
