package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.AlertsPage;

public class AlertsTest {
    WebDriver driver;
    AlertsPage alertsPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        alertsPage = new AlertsPage(driver);
    }

    @Test(groups = {"smoke"})
    public void testSimpleAlert() {
        alertsPage.clickSimpleAlert();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You clicked a button");
        alert.accept();
    }

    @Test(groups = {"regression"})
    public void testConfirmAlert() {
        alertsPage.clickConfirmAlert();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
