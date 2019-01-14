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

	    public void openHomePage() {
	        MainPage mainPage = new MainPage(driver);
	        mainPage.openPage();
	    }
	    
	    public void changeLanguage(String language) {
	       MainPage homePage = new MainPage(driver);
	        homePage.changeLanguage(language);
	    }
	    public String getMainPageTitle() {
	        MainPage mainPage = new MainPage(driver);
	        return mainPage.getPageTitle();
	    }
}
