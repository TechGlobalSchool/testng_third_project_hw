package scripts;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;

public class CarvanaBaseTest extends CarvanaBase {
    /*
        Test Case 1: Test name = Validate Carvana home page title and url
        Test priority = 1
        Given user is on "https://www.carvana.com/"
        Then validate title equals  "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
        And validate url equals  "https://www.carvana.com/"
     */
    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateTitleAndUrl() {
        String expectedTitle = "Carvana | Buy & Finance Used Cars Online | At Home Delivery";
        String expectedUrl = "https://www.carvana.com/";

        Assert.assertEquals(driver.getTitle(), expectedTitle);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    /*
        Test Case 2: Test name = Validate the Carvana logo
        Test priority = 2
        Given user is on "https://www.carvana.com/"
        Then validate the logo of the “Carvana” is displayed
     */
    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateLogo() {
        Assert.assertTrue(carvanaBasePage.logo.isDisplayed());
    }

    /*
        Test Case 3: Test name = Validate the main navigation section items
        Test priority = 3
        Given user is on "https://www.carvana.com/"
        Then validate the navigation section items below are displayed
     */
    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateNavItems() {
        String[] expectedDate = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};

        for(int i = 0; i < expectedDate.length; i++) {
            Assert.assertTrue(carvanaBasePage.mainNavItems.get(i).isDisplayed());
            Assert.assertEquals(carvanaBasePage.mainNavItems.get(i).getText(), expectedDate[i]);
        }
    }

    /*
        Test Case 4: Test name = Validate the sign in error message
        Test priority = 4
        Given user is on "https://www.carvana.com/"
        When user clicks on “SIGN IN” button
        Then user should be navigated to “Sign in” modal
        When user enters email as johndoe@gmail.com
        And user clicks on "CONTINUE" button
        And user enters password as "abcd1234"
        And user clicks on "SIGN IN" button
        Then user should see error message as "Email address and/or password combination is incorrect.
     */
    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateSignInWithInvalidCredentials() {
        String expectedErrorMessage = "Email address and/or password combination is incorrect.";
        carvanaBasePage.signInBtn.click();

        carvanaBasePage.emailInput.sendKeys(ConfigReader.getProperty("testEmail"));
        carvanaBasePage.emailSubmit.click();

        carvanaBasePage.passwordInput.sendKeys(ConfigReader.getProperty("testPassword"));
        carvanaBasePage.passwordSubmit.click();

        Assert.assertEquals(carvanaBasePage.errorBanner.getText(), expectedErrorMessage);
    }


}
