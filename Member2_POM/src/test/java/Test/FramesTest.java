package Test;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.FramesPage;

public class FramesTest {

    WebDriver driver;

    @Test
    public void testFramesText() {
        // 1. Launch browser and navigate
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        FramesPage framesPage = new FramesPage(driver);

        // 2. Get text from Frame 1
        String frame1Text = framesPage.getTextFromFrame1();
        System.out.println("Text from Frame 1: " + frame1Text);
        Assert.assertEquals(frame1Text, "This is a sample page"); // DemoQA frame text

        // 3. Get text from Frame 2
        String frame2Text = framesPage.getTextFromFrame2();
        System.out.println("Text from Frame 2: " + frame2Text);
        Assert.assertEquals(frame2Text, "This is a sample page"); // DemoQA frame text

        // 4. Close browser
        driver.quit();
    }
}
