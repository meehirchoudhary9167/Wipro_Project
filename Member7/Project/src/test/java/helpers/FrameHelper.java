package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
    private final WebDriver driver;

    public FrameHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(By frameLocator) {
        WebElement frame = driver.findElement(frameLocator);
        driver.switchTo().frame(frame);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
