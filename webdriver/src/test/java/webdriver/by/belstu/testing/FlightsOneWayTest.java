package webdriver.by.belstu.testing;


//4) Найти авиарейсы из одного пункта в другой с выбором пункта "в одну сторону" 
//по указанной дате
//Ожидаемый результат: отображается список рейсов в одну сторону в указанный день
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsOneWayTest {

	@Test
	public void flightsList() {
		System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
		driver.get("http://wizzair.com/ru-ru");

		WebElement from = driver.findElement(By.id("search-departure-station"));
		from.clear();
		from.sendKeys("Вильнюс");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[@data-test='flight-search-panel-location-label']")));
		driver.findElement(By.xpath("//label[@data-test='flight-search-panel-location-label']")).click();

		WebElement to = driver.findElement(By.id("search-arrival-station"));
		to.clear();
		to.sendKeys("Барселона");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[@data-test='flight-search-panel-location-label']")));
		driver.findElement(By.xpath("//label[@data-test='flight-search-panel-location-label']")).click();

		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='calendar__button']/button[text()=' ОК ']")));
		WebElement duration = driver.findElement(By.xpath("//div[@class='calendar__button']/button[text()=' ОК ']"));
		duration.submit();
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='На эту дату нет рейсов.']")));
		boolean isNotCharts = driver.findElement(By.xpath("//span[text()='На эту дату нет рейсов.']")).isDisplayed();
		Assert.assertEquals(isNotCharts, true);
		
		driver.close();
		driver = null;

	}

}
