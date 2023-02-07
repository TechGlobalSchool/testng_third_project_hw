package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaBasePage {
    public CarvanaBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper']")
    public WebElement logo;

    @FindBy(css = "div[data-qa='menu-wrapper']")
    public List<WebElement> mainNavItems;

    @FindBy(css = "div[data-qa='sign-in-wrapper']")
    public WebElement signInBtn;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(css = "button[data-qa='enter-email-submit']")
    public WebElement emailSubmit;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = "button[data-qa='sign-in-submit']")
    public WebElement passwordSubmit;

    @FindBy(id = "error-banner")
    public WebElement errorBanner;
}
