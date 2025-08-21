package Test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.FormsPage;

public class FormsTest {
    WebDriver driver;
    FormsPage formPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        formPage = new FormsPage(driver);
    }

    @Test
    public void fillFormAndSubmit() {
        formPage.enterFirstName("Pavan");
        formPage.enterLastName("Gottavada");
        formPage.enterEmail("pavangottavada@example.com");
        formPage.selectGenderMale();
        formPage.enterMobile("1234567890");
        formPage.enterDateOfBirth("01-jul-2002");  // Improve later to select actual date
        formPage.enterSubjects("Maths");
        formPage.selectHobbiesReading();
//        formPage.uploadPicture("C:\\Users\\Pavan\\Downloads\\image.jpg");
        formPage.enterCurrentAddress("123 Main Street, City, Country");
        formPage.selectState("AP");
        formPage.selectCity("Eluru");
        formPage.clickSubmit();

        // Add assertions here to verify submission was successful (optional)
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
