package helpers;

import AutomationProject.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Locale;

public class DatePickerHelper {
    private final WebDriver driver;
    private final Waits waits;

    public DatePickerHelper(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver, Duration.ofSeconds(10));
    }

    public void selectDate(By input, LocalDate target) {
        WebElement inputBox = waits.visible(input);
        inputBox.click();

        By header = By.cssSelector(".react-datepicker__current-month");
        By next = By.cssSelector(".react-datepicker__navigation--next");
        By prev = By.cssSelector(".react-datepicker__navigation--previous");
        By dayCells = By.cssSelector(".react-datepicker__day:not(.react-datepicker__day--outside-month)");

        YearMonth targetYm = YearMonth.of(target.getYear(), target.getMonth());
        while (true) {
            String text = waits.visible(header).getText(); // e.g. "August 2025"
            String[] parts = text.split(" ");
            int month = java.time.Month.valueOf(parts[0].toUpperCase(Locale.ROOT)).getValue();
            YearMonth currentYm = YearMonth.of(Integer.parseInt(parts[1]), month);

            if (currentYm.equals(targetYm)) break;
            if (currentYm.isBefore(targetYm)) driver.findElement(next).click();
            else driver.findElement(prev).click();
        }

        List<WebElement> days = driver.findElements(dayCells);
        for (WebElement d : days) {
            if (d.getText().equals(String.valueOf(target.getDayOfMonth()))) {
                d.click();
                break;
            }
        }
    }
}
