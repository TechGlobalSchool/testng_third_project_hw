package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaSearchCarsPage;
import utilities.ElementHandler;

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
}
