package webdriver.by.belstu.testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelTest {
	@Test
	public void checkHotel() {
		System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get("http://wizzair.com/ru-ru");

		WebElement hotels = driver.findElement(By.xpath("//*[@id='flight-search']/div/div/div[1]/div/button[2]"));
		hotels.click();

		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@src='https://www.booking.com/_46f5ca3196d9?lang=en-gb']")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_destination")));
		WebElement hotelCity = driver.findElement(By.id("b_destination"));
		hotelCity.clear();
		hotelCity.sendKeys("Barcelona, Catalonia, Spain");
		driver.findElement(By.id("checkInDate")).click();
		driver.findElement(By.id("ui-datepicker-checkInDate-2019-0-31")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkOutDate")));
		driver.findElement(By.id("checkOutDate")).click();
		driver.findElement(By.id("ui-datepicker-checkOutDate-2019-1-4")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Search']")));
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		//change window to current
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='heading']//h2")));
		String city = driver.findElement(By.xpath("//div[@role='heading']//h2")).getText();
		city = city.split(":")[0];
		
		Assert.assertEquals(city, "Barcelona");

	}
}
