package by.belstu.framework.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
