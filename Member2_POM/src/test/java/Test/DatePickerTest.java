package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DatePickerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerTest {
    WebDriver driver;

    @Test
    public void testDatePicker() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/date-picker");

        DatePickerPage datePage = new DatePickerPage(driver);

        datePage.selectDate("08/20/2025");
        Assert.assertEquals(datePage.getSelectedDate(), "08/20/2025");

        datePage.selectDateTime("August 20, 2025 10:30 PM");
        Assert.assertEquals(datePage.getSelectedDateTime(), "August 20, 2025 10:30 PM");

        driver.quit();
    }
}

