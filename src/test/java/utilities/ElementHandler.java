package utilities;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class ElementHandler {
    public static void handleStaleElementException(WebElement element) {
        for(int i = 0; i < 2; i++) {
            try {
                element.click();
                break;
            }
            catch (StaleElementReferenceException e) {
                Driver.getDriver().navigate().refresh();
                System.out.println(e.getMessage());
            }
        }
    }
}
