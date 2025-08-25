package member5_loggerutils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

// ScreenshotUtil is used to take and save screenshots
public class ScreenshotUtil {

    // Capture screenshot and save with timestamp
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        // File path where screenshot will be saved
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timeStamp + ".png";

        try {
            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save file to destination
            FileUtils.copyFile(srcFile, new File(destination));

            System.out.println("Screenshot saved at: " + destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }
}
