package tests;

import helpers.AlertHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests {
    private WebDriver driver;
    private AlertHelper alerts;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        alerts = new AlertHelper(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAlertsOnDemoQA() {
        driver.get("https://demoqa.com/alerts");

        // 1. Immediate alert
        driver.findElement(By.id("alertButton")).click();
        alerts.acceptAlert();

        // 2. Timed alert (after 5 sec)
        driver.findElement(By.id("timerAlertButton")).click();
        alerts.acceptAlert();

        // 3. Confirm alert
        driver.findElement(By.id("confirmButton")).click();
        alerts.dismissAlert();
        String confirmResult = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertTrue(confirmResult.contains("Cancel"));

        // 4. Prompt alert (NOTE: ID is 'promtButton', not 'promptButton')
        driver.findElement(By.id("promtButton")).click();
        alerts.sendKeysToAlert("TestUser");
        alerts.acceptAlert();
        String promptResult = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(promptResult.contains("TestUser"));
    }
}
