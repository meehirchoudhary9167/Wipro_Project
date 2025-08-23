package helpers;

import AutomationProject.Waits;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHelper {
    private final WebDriver driver;
    private final Waits waits;

    public WindowHelper(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver, Duration.ofSeconds(10));
    }

    public String getCurrentHandle() {
        return driver.getWindowHandle();
    }

    public void waitForNewWindow(int expectedCount) {
        waits.until(d -> d != null && d.getWindowHandles().size() == expectedCount);
    }

    public void switchByTitle(String title) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(title)) break;
        }
    }

    public void closeAllExcept(String parentHandle) {
        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
            if (!h.equals(parentHandle)) {
                driver.switchTo().window(h).close();
            }
        }
        driver.switchTo().window(parentHandle);
    }
}
