package by.belstu.framework;

import org.openqa.selenium.WebDriver;

import by.belstu.framework.driver.Driver;
import by.belstu.framework.page.MainPage;

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
	public String getHotelsCity() {
		MainPage mainPage = new MainPage(driver);
		mainPage.goToHotelsFrame();
		mainPage.goToHotels();
		String city = mainPage.getHotelsCity();
		return city;
	}
}
