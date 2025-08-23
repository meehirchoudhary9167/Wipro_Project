package tests;

import AutomationProject.DriverFactory;
import helpers.WindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class WindowTests {
    WebDriver driver;
    WindowHelper windows;

    @BeforeMethod
    public void setup() {
        DriverFactory.init();
        driver = DriverFactory.get();
        windows = new WindowHelper(driver);
    }

    @AfterMethod
    public void teardown() { DriverFactory.quit(); }

    @Test
    public void testWindows() {
        driver.get("https://demoqa.com/browser-windows");
        String parent = windows.getCurrentHandle();
        driver.findElement(By.id("tabButton")).click();
        windows.waitForNewWindow(2);
        windows.switchByTitle("sample");
        windows.closeAllExcept(parent);
    }
}
