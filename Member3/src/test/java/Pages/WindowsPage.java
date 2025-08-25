package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Set;

public class WindowsPage {
    WebDriver driver;

    // Locators
    private By newTabButton = By.id("tabButton");
    private By newWindowButton = By.id("windowButton");
    private By message = By.id("sampleHeading");

    // Constructor
    public WindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickNewTab() {
        driver.findElement(newTabButton).click();
    }

    public void clickNewWindow() {
        driver.findElement(newWindowButton).click();
    }

    public String switchToNewWindowAndGetText() {
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String win : allWindows) {
            if (!win.equals(parentWindow)) {
                driver.switchTo().window(win);
                break;
            }
        }
        String text = driver.findElement(message).getText();
        driver.close(); // close new window
        driver.switchTo().window(parentWindow); // return to parent
        return text;
    }
}

