package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserManager.CaptureScreenshot;
import supportClasses.ContactUs;
import supportClasses.NavigateToMenuItem;

/**
 * <p>
 * This test case navigates to contact us page, fills the form and takes screenshot of filled-in form.
 * </p>
 * <p>
 * RUNTIME : ~6 seconds
 * </p>
 * <p>
 * @author shruthi
 * </p>
 */
public class ValidateContactUsFormTest extends HelperClass{

	@Test
	@Parameters({ "firstName", "lastName", "companyName", "countryName", "email", "mobileNumber", "enquiryDetails",
	"checkboxStatus" })
	public void validateContactUsFormTest(String firstName, String lastName, String companyName, String countryName,
			String email, @Optional String mobileNumber,
			@Optional String enquiryDetails, boolean checkboxStatus)
	{
		NavigateToMenuItem menuSupportClass = new NavigateToMenuItem(driver);
		ContactUs contactUsSupportClass = new ContactUs(driver);
		
		// Assert home page and navigate to contact us page
		menuSupportClass.assertHomePage();
		menuSupportClass.goToContactUsPage();
		
		// Fill the form
		contactUsSupportClass.fillForm(firstName, lastName, companyName, countryName, email, mobileNumber, enquiryDetails, checkboxStatus);
		
		// Take screenshots. These screenshots are saved in "screenshots" folder in root directory.
		try
		{
		CaptureScreenshot captureScreenshot = new CaptureScreenshot(driver);
		// Scroll up and down to get srceenshot of the entire form
		scrollUp();
		System.out.println("Screenshot1 is at: " + captureScreenshot.takeScreenshot("Screenshot1"));
		scrollDown();
		System.out.println("Screenshot2 is at: " + captureScreenshot.takeScreenshot("Screenshot2"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
		
		private void scrollDown()
		{
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
		}
		
		private void scrollUp()
		{
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)", "");
		}
}
