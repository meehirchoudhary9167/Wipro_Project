package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    WebDriver driver;

    // Locators
    private By frame1 = By.id("frame1");
    private By frame2 = By.id("frame2");
    private By heading = By.id("sampleHeading");

    // Constructor
    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public String getTextFromFrame1() {
        driver.switchTo().frame(driver.findElement(frame1));
        String text = driver.findElement(heading).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public String getTextFromFrame2() {
        driver.switchTo().frame(driver.findElement(frame2));
        String text = driver.findElement(heading).getText();
        driver.switchTo().defaultContent();
        return text;
    }
}
