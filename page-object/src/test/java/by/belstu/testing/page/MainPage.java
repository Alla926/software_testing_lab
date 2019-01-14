package by.belstu.testing.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	private final String MAIN_PAGE_URL = "http://wizzair.com/ru-ru";

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//button[@data-test='language-selector']")
	private WebElement languageSelector;

	@FindBy(xpath = "//a[@href='https://wizzair.com/en-gb/main-page']")
	private WebElement changeLanguageToEnglishButton;

	@FindBy(xpath = "//a[@href='https://wizzair.com/pl-pl/main-page']")
	private WebElement changeLanguageToPolishButton;

	public String getPageTitle() {
		return driver.getTitle();
	}
    public void openPage() {
        driver.navigate().to(MAIN_PAGE_URL);
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
