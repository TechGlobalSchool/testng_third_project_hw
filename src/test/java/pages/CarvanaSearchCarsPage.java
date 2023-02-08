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
}
