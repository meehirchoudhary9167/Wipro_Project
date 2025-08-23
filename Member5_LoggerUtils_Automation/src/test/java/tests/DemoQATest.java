package tests;

import member5_loggerutils.ExcelReader;
import member5_loggerutils.LoggerHelper;
import member5_loggerutils.ScreenshotUtil;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DemoQATest {

    WebDriver driver;
    Logger log = LoggerHelper.getLogger(DemoQATest.class);
    ExcelReader excelReader;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        log.info("Browser launched and maximized");

        String excelPath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
        excelReader = new ExcelReader(excelPath);
        log.info("ExcelReader initialized with path: " + excelPath);
    }

    @Test
    public void fillDemoQAForm() {
        driver.get("https://demoqa.com/automation-practice-form");
        log.info("Opened DemoQA Practice Form");

        // Read data from Excel
        String fullName = excelReader.getCellData("Sheet1", 1, 0); // monika
        String email = excelReader.getCellData("Sheet1", 2, 1);    // moni@demo.com
        String phone = excelReader.getCellData("Sheet1", 3, 1);    // 1234546614

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));

        driver.findElement(By.id("firstName")).sendKeys(fullName);
        log.info("Entered First Name: " + fullName);

        driver.findElement(By.id("userEmail")).sendKeys(email);
        log.info("Entered Email: " + email);

        driver.findElement(By.id("userNumber")).sendKeys(phone);
        log.info("Entered Phone: " + phone);

        // Click gender label (e.g., 'Male') instead of input to avoid overlay issues
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//label[text()='Female']"))).click();
        log.info("Selected Gender: Female");

        // Screenshot after filling
        ScreenshotUtil.captureScreenshot(driver, "DemoQA_FilledForm");
        log.info("Screenshot captured");

        // Optional small wait
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed");
        }
    }
}
