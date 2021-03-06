package PageObjects;

public class PageElements {

	public static String SearchField() {

		return "//input[@aria-label='Search any wine']"	;
	}

	public static String firstResultWine() {

		return "//a[@data-cartitemsource='text-search'][1]"	;
	}

	public static String selectedWineName() {

		return "//a[@data-cartitemsource='winery-page-wine-page-header']"	;
	}

	public static String selectedWineCountry() {

		return "//a[@data-cy='breadcrumb-country"	;
	}
	
	public static String allwinesOnSearchresult() {

		return "//a[@data-cartitemsource='text-search' and @class='link-color-alt-grey']"	;
	}
	
	public static String allwinesCountrynameOnSearchresult() {

		return "//a[@data-item-type='country']"	;
	}
}

