package DataDrivenTest;

import org.testng.annotations.Test;

import Dataproviders.DBDataProvider;
import Dataproviders.ExcelDataProvider;

	public class DatadrivenTest {

	    @Test(dataProvider = "FormDataFromExcel", dataProviderClass = ExcelDataProvider.class)
	    public void fillFormWithExcel(String firstname, String lastname, String email, String gender, String mobile) {
	        System.out.println("Filling form with Excel data: " + firstname + " " + lastname);
	        // Here actual Selenium code will go (driver.findElement(...).sendKeys(...))
	    }

	    @Test(dataProvider = "FormDataFromDB", dataProviderClass = DBDataProvider.class)
	    public void fillFormWithDB(String firstname, String lastname, String email, String gender, String mobile) {
	        System.out.println("Filling form with DB data: " + firstname + " " + lastname);
	        // Selenium automation code for demoqa.com/forms
	    }
	}
