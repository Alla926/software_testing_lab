package by.belstu.testing;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import by.belstu.testing.page.MainPage;

public class ChangeLanguageTest {
	 private WebDriver driver;

	    @Before
	    public void begin() {
	        String url = "http://wizzair.com/ru-ru";

	        if (null == driver) {
	            System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
	            driver = new ChromeDriver();
	            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        }

	        driver.get(url);
	    }

	    @Test
	    public void testInternationalization() {
	        String expectedEnglishTitle = "Official Wizz Air website | Book direct for the best prices";
	        String expectedPolishTitle = "Oficjalna strona Wizz Air | Rezerwuj bezpośrednio, by skorzystać z najlepszych cen";
	        MainPage main = new MainPage(driver);


	        main.changeLanguage("English");
	        Assert.assertEquals(expectedEnglishTitle, main.getPageTitle());

	        main.changeLanguage("Polish");
	        Assert.assertEquals(expectedPolishTitle, main.getPageTitle());

	    }

	    @After
	    public void complete() {
	        driver.quit();
	        driver = null;
	    }
}
