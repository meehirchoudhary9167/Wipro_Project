package tests;

import AutomationProject.DriverFactory;
import helpers.FrameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class FrameTests {
    WebDriver driver;
    FrameHelper frames;

    @BeforeMethod
    public void setup() {
        DriverFactory.init();
        driver = DriverFactory.get();
        frames = new FrameHelper(driver);
    }

    @AfterMethod
    public void teardown() { DriverFactory.quit(); }

    @Test
    public void testFrames() {
        driver.get("https://demoqa.com/frames");
        frames.switchToFrame(By.id("frame1"));
        System.out.println("Frame1 Text: " + driver.findElement(By.id("sampleHeading")).getText());
        frames.switchToDefault();

        frames.switchToFrame(By.id("frame2"));
        System.out.println("Frame2 Text: " + driver.findElement(By.id("sampleHeading")).getText());
        frames.switchToDefault();
    }
}
