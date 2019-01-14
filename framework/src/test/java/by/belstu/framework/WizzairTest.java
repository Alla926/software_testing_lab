package by.belstu.framework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WizzairTest {
    private Steps steps;
    @Before
    public void setUp() {
        steps = new Steps();
        steps.openBrowser();
    }
	@Test
    public void changeLanguageTest() {
		String expectedEnglishTitle = "Official Wizz Air website | Book direct for the best prices";
        String expectedPolishTitle = "Oficjalna strona Wizz Air | Rezerwuj bezpośrednio, by skorzystać z najlepszych cen";

        steps.openHomePage();

        steps.changeLanguage("English");
        Assert.assertEquals(expectedEnglishTitle, steps.getMainPageTitle());

        steps.changeLanguage("Polish");
        Assert.assertEquals(expectedPolishTitle, steps.getMainPageTitle());
	}
	
    @After
    public void closeBrowser() {
        steps.closeBrowser();
    }
}
