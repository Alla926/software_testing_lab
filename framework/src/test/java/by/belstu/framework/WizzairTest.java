package by.belstu.framework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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

		steps.openMainPage();

		steps.changeLanguage("English");
		Assert.assertEquals(expectedEnglishTitle, steps.getMainPageTitle());

		steps.changeLanguage("Polish");
		Assert.assertEquals(expectedPolishTitle, steps.getMainPageTitle());
	}

	@Test
	public void getHotelsCityTest() {
		steps.openMainPage();
		String city = steps.getHotelsCity("Barcelona, Catalonia, Spain");
		Assert.assertEquals("Barcelona", city);
	}

	@Test
	public void noFlightsTest() {
		steps.openMainPage();
		boolean result = steps.isNoFlights("Вильнюс", "Барселона");
		Assert.assertEquals(result, true);
	}

	@Test
	public void getAllFlightsTest() {
		steps.openSearchPage();
		String cost = steps.getCostOfFirstFlight("Вильнюс", "Барселона");
		Assert.assertEquals(cost, "99,99"); 
	}
	

	@Test
	public void getAllFlightsWithDiscountTest() {
		steps.openSearchPage();
		String cost = steps.getCostOfFirstFlight("Вильнюс", "Барселона");
		Assert.assertEquals(cost, "89,99"); 
	}
	

	@Test
	public void getTheSameResultTest() {
		steps.openSearchPage();
		boolean result = steps.isTheSameResultOfTwoSearches("Вильнюс", "Барселона");
		Assert.assertEquals(result, "true"); 
	}

	@Test
	public void tryToSearchFlightsOnlyFromCityTest() {
		steps.openMainPage();
		boolean result = steps.tryToSearchFlightsFromCity("Вильнюс");
		Assert.assertEquals(result, "true"); 
	}
	

	@Test
	public void tryToSearchFlightsWithSameFromAndToCityTest() {
		steps.openMainPage();
		boolean result = steps.tryToSearchFlightsWithSameFromAndToCity("Вильнюс");
		Assert.assertEquals(result, "true"); 
	}
	

	@Test
	public void tryfillFlightFormWithCityWithoutAirportTest() {
		steps.openMainPage();
		boolean result = steps.tryfillFlightFormWithCityWithoutAirport("Вильнюс", "Витебск");
		Assert.assertEquals(result, "true"); 
	}
	

	@Test
	public void compareDiscountPriceAndUsualPriceTest() {
		steps.openSearchPage();
		int difference  = steps.compareDiscountPriceAndUsualPrice("Вильнюс", "Барселона");
		Assert.assertEquals(difference, 10); 
	}
	

	@After
	public void closeBrowser() {
		steps.closeBrowser();
	}
}
