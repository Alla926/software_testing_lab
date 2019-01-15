package by.belstu.framework.page;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	private final String URL = "http://wizzair.com/ru-ru";
	private WebDriver driver;

	@FindBy(id = "search-departure-station")
	private WebElement from;

	@FindBy(id = "search-arrival-station")
	private WebElement to;

	@FindBy(xpath = "//button[@data-test='flight-search-submit']")
	private WebElement searchFlights;

	@FindBy(xpath = "//span[text()='На эту дату нет рейсов.']")
	private WebElement noFlights;

	@FindBy(xpath = "//button[@data-test='language-selector']")
	private WebElement languageSelector;

	@FindBy(xpath = "//a[@href='https://wizzair.com/en-gb/main-page']")
	private WebElement changeLanguageToEnglishButton;

	@FindBy(xpath = "//a[@href='https://wizzair.com/pl-pl/main-page']")
	private WebElement changeLanguageToPolishButton;

	@FindBy(xpath = "//*[@id='flight-search']/div/div/div[1]/div/button[2]")
	private WebElement hotels;

	@FindBy(id = "b_destination")
	private WebElement hotelCity;

	@FindBy(id = "checkInDate")
	private WebElement checkInDate;

	@FindBy(id = "ui-datepicker-checkInDate-2019-0-31")
	private WebElement January31;

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement hotelSearch;

	@FindBy(xpath = "//iframe[@src='https://www.booking.com/_46f5ca3196d9?lang=en-gb']")
	private WebElement hotelsFrame;

	@FindBy(xpath = "//div[@role='heading']//h2")
	private WebElement resultCity;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void openPage() {
		driver.navigate().to(URL);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void changeLanguage(String language) {
		languageSelector.click();
		if (language.equals("English")) {
			changeLanguageToEnglishButton.click();
		} else if (language.equals("Polish")) {
			changeLanguageToPolishButton.click();
		} else {
			throw new IllegalArgumentException("Such language doesn't exist " + language);
		}
	}

	public void goToHotelsFrame() {
		hotels.click();
		driver.switchTo().frame(hotelsFrame);
	}

	public void goToHotels(String city) {
		hotelCity.clear();
		hotelCity.sendKeys(city);
		checkInDate.click();
		January31.click();
		hotelSearch.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

	}

	public String getHotelsCity() {
		String city = resultCity.getText();
		city = city.split(":")[0];
		return city;
	}

	public void fillFlightForm(String fromCity, String toCity) {
		from.clear();
		from.sendKeys(fromCity+"\n");
		to.clear();
		to.sendKeys(toCity+"\n");
		searchFlights.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void fillFlightFormWithFromCity(String fromCity) {
		from.clear();
		from.sendKeys(fromCity+"\n");
		searchFlights.click();
	}
	
	public void fillFlightFormWithSameFromAndToCity(String city) {
		from.clear();
		from.sendKeys(city+"\n");
		to.clear();
		to.sendKeys(city+"\n");
		searchFlights.click();
	}
	
	public void fillFlightFormWithCityWithoutAirport(String fromCity, String toCity) {
		from.clear();
		from.sendKeys(fromCity+"\n");
		to.clear();
		to.sendKeys(toCity+"\n");
		searchFlights.click();
	}
	

	public boolean isNoFlights() {
		try {
			driver.findElement(By.xpath("//span[text()='На эту дату нет рейсов.']"));
			return true;
		} catch (NoSuchElementException ignored) {
			return false;
		}

	}
	
	public boolean hasValidationException() {
		try {
			driver.findElement(By.xpath("//span[@class='rf-input__error__message']"));
			return true;
		} catch (NoSuchElementException ignored) {
			return false;
		}

	}

}
