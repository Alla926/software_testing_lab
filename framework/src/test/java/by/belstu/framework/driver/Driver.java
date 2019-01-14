package by.belstu.framework.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	    private static WebDriver driver;
	    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	    private static final String CHROMEDRIVER_EXE_PATH = "src/resources/driver/chromedriver.exe";
	    private static final int DEFAULT_TIMEOUT = 30; 

	    private Driver(){}

	    public static WebDriver getDriver(){
	        if (driver == null){
	            System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_EXE_PATH);
	            driver = new ChromeDriver();
	            driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
	            driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
	            driver.manage().window().maximize();
	        }

	        return driver;
	    }

	    public static void closeDriver(){
	        driver.quit();
	        driver = null;
	    }
}
