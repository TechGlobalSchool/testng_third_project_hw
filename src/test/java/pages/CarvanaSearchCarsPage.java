package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaSearchCarsPage extends CarvanaBasePage {
    public CarvanaSearchCarsPage() {
        super();
    }

    @FindBy(css = "button[data-qa='drop-down-wrap']")
    public List<WebElement> filterButtonList;

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInputBox;

    @FindBy(css = "picture[data-qa='base-vehicle-image']")
    public List<WebElement> tileImageList;

    @FindBy(css = "svg[data-qa='favorite-icon']")
    public List<WebElement> tileFavIcon;

    @FindBy(css = "div[class='tk-frame middle-frame']")
    public List<WebElement> tileBodyList;

    @FindBy(css = "div[data-qa='base-inventory-type']")
    public List<WebElement> tileInventoryType;

    @FindBy(css = "div[class='year-make']")
    public List<WebElement> tileYearMakeList;

    @FindBy(css = "div[class='trim-mileage']")
    public List<WebElement> tileTrimMileageList;

    @FindBy(css = "div[data-qa='price']")
    public List<WebElement> tilePriceList;

    @FindBy(css = "div[data-qa='monthly-payment']")
    public List<WebElement> tileMonthlyPmntList;

    @FindBy(css = "div[class='down-payment']")
    public List<WebElement> tileDownPmntList;

    @FindBy(css = "div[data-qa='shipping-cost']")
    public List<WebElement> tileShipList;
}
