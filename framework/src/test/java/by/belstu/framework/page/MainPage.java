package by.belstu.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	WebDriver driver;
	WebDriverWait wait;
	public MainPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "search-departure-station")
	private WebElement from;

	@FindBy(id = "search-arrival-station")
	private WebElement to;

	@FindBy(xpath = "//div[@class='calendar__button']/button[text()=' ОК ']")
	private WebElement duration;

	@FindBy(xpath = "//button[@data-test='language-selector']")
	private WebElement languageSelector;

	@FindBy(xpath = "//a[@href='https://wizzair.com/en-gb/main-page']")
	private WebElement changeLanguageToEnglishButton;

	@FindBy(xpath = "//a[@href='https://wizzair.com/pl-pl/main-page']")
	private WebElement changeLanguageToPolishButton;

	@FindBy(xpath = "//*[@id='flight-search']/div/div/div[1]/div/button[2]")
	private WebElement hotels;

	@FindBy(xpath = "//*[@id='flight-search']/div/div/div[1]/div/button[3]")
	private WebElement cars;

	@FindBy(id = "b_destination")
	private WebElement hotelCity;

	@FindBy(id = "checkInDate")
	private WebElement checkInDate;
	
	@FindBy(id = "ui-datepicker-checkInDate-2019-0-31")
	private WebElement January31;
	
	@FindBy(id = "checkOutDate")
	private WebElement checkOutDate;
	
	@FindBy(id = "ui-datepicker-checkOutDate-2019-1-4")
	private WebElement February4;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement hotelSearch;
	
	@FindBy(xpath = "//iframe[@src='https://www.booking.com/_46f5ca3196d9?lang=en-gb']")
	private WebElement hotelsFrame;
	
	@FindBy(xpath = "//div[@role='heading']//h2")
	private WebElement resultCity;

	@FindBy(xpath = "//input[@placeholder=\"Pick up location\"]")
	private WebElement carCity;
	
    public void openPage() {
        driver.navigate().to("http://wizzair.com/ru-ru");
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
	
	public void goToHotels() {
		hotelCity.clear();
		hotelCity.sendKeys("Barcelona, Catalonia, Spain");
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

}
