package webdriver.by.belstu.testing;

//4) Найти авиарейсы из одного пункта в другой с выбором пункта "в одну сторону" 
//по указанной дате
//Ожидаемый результат: отображается список рейсов в одну сторону в указанный день



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class FlightsOneWayTest {
	private WebDriver driver;

	@Before
	public void beforeTets() {
	driver = new ChromeDriver();}
	
	@Test
	public void BrowserToGoogle() {
		driver.get("https://wizzair.com/ru-ru");
		WebElement from = driver.findElement(By.xpath("//*[@id=\"search-departure-station\"]"));
		from.clear();
		from.sendKeys("Вильнюс\n");

		WebElement to = driver.findElement(By.xpath("//*[@id=\"search-arrival-station\"]"));
		to.clear();
		to.sendKeys("Барселона\n");
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"flight-search\"]/div/div/div[3]/form/div[4]/button"));
		search.submit();
		System.out.println("Page title is: " + driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

}
