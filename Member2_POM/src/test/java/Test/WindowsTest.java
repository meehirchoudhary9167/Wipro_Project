package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.WindowsPage;

public class WindowsTest {

    WebDriver driver;

    @Test
    public void testNewTabAndWindow() {
        // 1. Launch browser and navigate
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        Pages.WindowsPage windowsPage = new Pages.WindowsPage(driver);

        // 2. Test New Tab
        windowsPage.clickNewTab();
        String tabText = windowsPage.switchToNewWindowAndGetText();
        System.out.println("Text from new tab: " + tabText);
        Assert.assertEquals(tabText, "This is a sample page"); // DemoQA tab text

        // 3. Test New Window
        windowsPage.clickNewWindow();
        String windowText = windowsPage.switchToNewWindowAndGetText();
        System.out.println("Text from new window: " + windowText);
        Assert.assertEquals(windowText, "This is a sample page"); // DemoQA window text

        // 4. Close browser
        driver.quit();
    }
}

