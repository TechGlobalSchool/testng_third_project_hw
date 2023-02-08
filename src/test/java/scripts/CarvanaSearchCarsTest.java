package scripts;

import org.apache.commons.lang3.RegExUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaSearchCarsPage;
import utilities.ElementHandler;
import utilities.Waiter;

import java.util.regex.Pattern;

public class CarvanaSearchCarsTest extends CarvanaBase {
    @BeforeMethod
    public void setPage() {
        ElementHandler.handleStaleElementException(carvanaBasePage.headerItems.get(0));
        carvanaSearchCarsPage = new CarvanaSearchCarsPage();
    }

    /*
        Test Case 5: Test name = Validate the search filter options and search button
        Test priority = 5
        Given user is on "https://www.carvana.com/"
        When user clicks on "SEARCH CARS" link
        Then user should be routed to "https://www.carvana.com/cars"
        And user should see filter options
     */
    @Test(priority = 1, description = "Validate the search filter options and search button")
    public void validateFilterOptions() {
        String[] expectedData = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        for(int i = 0; i < expectedData.length; i++) {
            Assert.assertTrue(carvanaSearchCarsPage.filterButtonList.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.filterButtonList.get(i).isEnabled());
            Assert.assertEquals(carvanaSearchCarsPage.filterButtonList.get(i).getText(), expectedData[i]);
        }
    }

    /*
        Test Case 6: Test name = Validate the search result tiles
        Test priority = 6
        Given user is on "https://www.carvana.com/"
        When user clicks on "SEARCH CARS" link
        Then user should be routed to "https://www.carvana.com/cars"
        When user enters "mercedes-benz" to the search input box
        And user clicks on "GO" button in the search input box
        Then user should see "mercedes-benz" in the url
        And validate each result tile
        VALIDATION OF EACH TILE INCLUDES BELOW
        Make sure each result tile is displayed with below information
        1. an image
        2. add to favorite button
        3. tile body
        ALSO VALIDATE EACH TILE BODY:
        Make sure each tile body has below information
        1. Inventory type - text should be displayed and should not be null or empty
        2. Year-Make-Model information - text should be displayed and should not be null or empty
        3. Trim-Mileage information - text should be displayed and should not be null or empty
        4. Price - Make sure that each price is more than zero
        5. Monthly Payment information - text should be displayed and should not be null or empty
        6. Down Payment information - text should be displayed and should not be null or empty
        7. Delivery chip must be displayed, and text is not null or empty
     */
    @Test(priority = 2, description = "Validate the search result tiles")
    public void validateSearchResultTiles() {
        carvanaSearchCarsPage.searchInputBox.sendKeys("mercedes-benz" + Keys.ENTER);
        Waiter.pause(3);

        for(int i = 0; i < carvanaSearchCarsPage.tileImageList.size(); i++) {
            Assert.assertTrue(carvanaSearchCarsPage.tileImageList.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.tileFavIcon.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.tileBodyList.get(i).isDisplayed());

            Assert.assertTrue(carvanaSearchCarsPage.tileInventoryType.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchCarsPage.tileInventoryType.get(i).getText());
            Assert.assertFalse(carvanaSearchCarsPage.tileInventoryType.get(i).getText().equals(""));

            Assert.assertTrue(carvanaSearchCarsPage.tileYearMakeList.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchCarsPage.tileYearMakeList.get(i).getText());
            Assert.assertFalse(carvanaSearchCarsPage.tileYearMakeList.get(i).getText().equals(""));

            Assert.assertTrue(carvanaSearchCarsPage.tileTrimMileageList.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchCarsPage.tileTrimMileageList.get(i).getText());
            Assert.assertFalse(carvanaSearchCarsPage.tileTrimMileageList.get(i).getText().equals(""));

            Assert.assertTrue(carvanaSearchCarsPage.tilePriceList.get(i).isDisplayed());
            Assert.assertTrue(Integer.parseInt(RegExUtils.removeAll(carvanaSearchCarsPage.tilePriceList.get(i).getText(), Pattern.compile("\\D"))) > 0);

            Assert.assertTrue(carvanaSearchCarsPage.tileMonthlyPmntList.get(i).isDisplayed());
            Assert.assertNotNull(RegExUtils.removeAll(carvanaSearchCarsPage.tilePriceList.get(i).getText(), Pattern.compile("\\D")));
            Assert.assertFalse(RegExUtils.removeAll(carvanaSearchCarsPage.tilePriceList.get(i).getText(), Pattern.compile("\\D")).equals(""));

            Assert.assertTrue(carvanaSearchCarsPage.tileDownPmntList.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchCarsPage.tileDownPmntList.get(i).getText());
            Assert.assertFalse(carvanaSearchCarsPage.tileDownPmntList.get(i).getText().equals(""));

            Assert.assertTrue(carvanaSearchCarsPage.tileShipList.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchCarsPage.tileShipList.get(i).getText());
            Assert.assertFalse(carvanaSearchCarsPage.tileShipList.get(i).getText().equals(""));
        }
    }
}
