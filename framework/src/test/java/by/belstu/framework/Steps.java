package by.belstu.framework;

import org.openqa.selenium.WebDriver;

import by.belstu.framework.driver.Driver;
import by.belstu.framework.page.MainPage;
import by.belstu.framework.page.SearchPage;

public class Steps {
	private WebDriver driver;

	public void openBrowser() {
		driver = Driver.getDriver();
	}

	public void closeBrowser() {
		Driver.closeDriver();
	}

	public void openMainPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
	}

	public void changeLanguage(String language) {
		MainPage mainPage = new MainPage(driver);
		mainPage.changeLanguage(language);
	}

	public String getMainPageTitle() {
		MainPage mainPage = new MainPage(driver);
		return mainPage.getPageTitle();
	}
	public String getHotelsCity(String city) {
		MainPage mainPage = new MainPage(driver);
		mainPage.goToHotelsFrame();
		mainPage.goToHotels(city);
		String resultCity = mainPage.getHotelsCity();
		return resultCity;
	}
	public boolean isNoFlights(String fromCity, String toCity) {
		MainPage mainPage = new MainPage(driver);
		mainPage.fillFlightForm(fromCity, toCity);
		boolean result = mainPage.isNoFlights();
		return result;
		
	}
	public void openSearchPage() {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.openPage();
	}
	public String getCostOfFirstFlight(String fromCity, String toCity) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.fillSearchForm(fromCity, toCity);
		return searchPage.getPriceOfFirstFlight();
		
	}
	
	public String getCostOfFirstFlightWithDiscount(String fromCity, String toCity) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.fillSearchFormWithDiscount(fromCity, toCity);
		return searchPage.getPriceOfFirstFlight();
		
	}
	
	public boolean isTheSameResultOfTwoSearches(String fromCity, String toCity) {
		String cost1 = getCostOfFirstFlight(fromCity, toCity);
		String cost2 = getCostOfFirstFlight(fromCity, toCity);
		return cost1.equals(cost2);
	}
	
	public boolean tryToSearchFlightsFromCity(String fromCity) {
		MainPage mainPage = new MainPage(driver);
		mainPage.fillFlightFormWithFromCity(fromCity);
		return mainPage.hasValidationException();
	}
	public boolean tryToSearchFlightsWithSameFromAndToCity(String city) {
		MainPage mainPage = new MainPage(driver);
		mainPage.fillFlightFormWithSameFromAndToCity(city);
		return mainPage.hasValidationException();
	}
	
}
