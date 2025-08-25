package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage {
    WebDriver driver;
    WebDriverWait wait;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By alertButton = By.id("alertButton");
    By timerAlertButton = By.id("timerAlertButton");
    By confirmButton = By.id("confirmButton");
    By promptButton = By.id("promtButton");

    // --- Click Methods ---
    public void clickSimpleAlert() {
        safeClick(alertButton);
    }

    public void clickTimerAlert() {
        safeClick(timerAlertButton);
    }

    public void clickConfirmAlert() {
        safeClick(confirmButton);
    }

    public void clickPromptAlert() {
        safeClick(promptButton);
    }

    // --- Helper Methods ---
    private void safeClick(By locator) {
        // Close ad iframe if present
        closeAdOverlayIfPresent();

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Click via JavaScript (avoids ElementClickInterceptedException)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    private void closeAdOverlayIfPresent() {
        try {
            WebElement iframe = driver.findElement(By.cssSelector("iframe[id^='google_ads_iframe']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", iframe);
        } catch (Exception e) {
            // Ignore if no ads present
        }
    }
}

