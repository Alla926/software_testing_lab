package by.belstu.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

	public MainPage(WebDriver driver) {
		super(driver);
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

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement hotelSearch;

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
			throw new IllegalArgumentException("Invalid language: " + language);
		}
	}

}
