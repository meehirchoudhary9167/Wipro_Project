package tests;

import AutomationProject.DriverFactory;
import helpers.DatePickerHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.LocalDate;

public class DatePickerTests {
    WebDriver driver;
    DatePickerHelper datePicker;

    @BeforeMethod
    public void setup() {
        DriverFactory.init();
        driver = DriverFactory.get();
        datePicker = new DatePickerHelper(driver);
    }

    @AfterMethod
    public void teardown() { DriverFactory.quit(); }

    @Test
    public void testDatePicker() {
        driver.get("https://demoqa.com/date-picker");
        datePicker.selectDate(By.id("datePickerMonthYearInput"), LocalDate.of(2025, 8, 23));
    }
}
