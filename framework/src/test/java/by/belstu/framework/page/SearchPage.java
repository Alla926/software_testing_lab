package by.belstu.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	private final String URL = "https://wizzair.com/ru-ru/rejsy/raspisanie";
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id = "search-departure-station")
	private WebElement from;
	
	@FindBy(id = "search-arrival-station")
	private WebElement to;
	
	@FindBy(xpath = "//label[@for='fare-finder-wdc'][1]")
	private WebElement withWizzDiscountClub;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/button")
	private WebElement search;
	
	@FindBy(xpath = "//li[@class='fare-finder__calendar__days__day'][1]//div//div//p//span[1]")
	private WebElement flightDaysCost;



	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(this.driver, this);
	}

	public void openPage() {
		driver.navigate().to(URL);
	}
	
	public void fillSearchForm(String fromCity, String toCity) {
		from.clear();
		from.sendKeys(fromCity+"\n");
		
		to.clear();
		to.sendKeys(toCity+"\n");
		
		search.click();
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void fillSearchFormWithDiscount(String fromCity, String toCity) {
		from.clear();
		from.sendKeys(fromCity+"\n");
		
		to.clear();
		to.sendKeys(toCity+"\n");
		withWizzDiscountClub.click();
		search.click();
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public String getPriceOfFirstFlight() {
		return flightDaysCost.getText().split(" ")[0];
	}
	}
	

