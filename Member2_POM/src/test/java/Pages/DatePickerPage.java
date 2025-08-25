package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePickerPage {
    WebDriver driver;

    By datePickerInput = By.id("datePickerMonthYearInput");
    By dateTimeInput = By.id("dateAndTimePickerInput");

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
    }

    // Scroll helper
    private void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // For single date
    public void selectDate(String date) {
        WebElement input = driver.findElement(datePickerInput);
        scrollTo(input);

        // Open calendar, backspace all existing characters
        input.click();
        for (int i = 0; i < 10; i++) {
            input.sendKeys(Keys.BACK_SPACE);
        }

        // Type new date
        input.sendKeys(date);
        input.sendKeys(Keys.ENTER); // confirm selection
    }

    // For date and time
    public void selectDateTime(String dateTime) {
        WebElement input = driver.findElement(dateTimeInput);

        // Scroll to make it visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);

        // Set value via JS directly
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", input, dateTime);
    }


    public String getSelectedDate() {
        return driver.findElement(datePickerInput).getAttribute("value");
    }

    public String getSelectedDateTime() {
        return driver.findElement(dateTimeInput).getAttribute("value");
    }
}
