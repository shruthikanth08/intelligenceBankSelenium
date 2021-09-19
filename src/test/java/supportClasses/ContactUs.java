package supportClasses;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * <p>
 * This support class contains actions that can be performed on contact us page. Currently, it contains only form filling actions.
 * </p>
 * <p>
 * @author shruthi
 * </p>
 */
public class ContactUs
{	
	private JavascriptExecutor js;
	
	public ContactUs(WebDriver driver)
	{
		js = (JavascriptExecutor)driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[contains(@id,'firstname')]")
	WebElement formFirstName;
	
	@FindBy(xpath = "//input[contains(@id,'lastname')]")
	WebElement formLastName;
	
	@FindBy(xpath = "//input[contains(@id,'company')]")
	WebElement formCompanyName;
	
	@FindBy(xpath = "//select[contains(@id,'country')]")
	WebElement formCountry;
	
	@FindBy(xpath = "//input[contains(@id,'email')]")
	WebElement formEmail;
	
	@FindBy(xpath = "//input[contains(@id,'mobilephone')]")
	WebElement formMobileNumber;
	
	@FindBy(xpath = "//textarea[contains(@id,'enquiry_details')]")
	WebElement formEnquiryDetails;
	
	@FindBy(xpath = "//input[contains(@id,'i_agree_to_intelligencebank_s_terms_and_conditions')]//following-sibling::span")
	WebElement formAgreeCheckbox;
	
	@FindBy(xpath = "//input[contains(@id,'i_agree_to_intelligencebank_s_terms_and_conditions')]")
	WebElement formAgreeCheckboxStatus;
	
	/**
	 * This method fills the form. It does not click submit button.
	 */
	public void fillForm(String firstName, String lastName, String companyName, String countryName, String email, String mobileNumber, String enquiryDetails, boolean checkboxStatus)
	{
		enterDetail(formFirstName, firstName);
		enterDetail(formLastName,lastName);
		enterDetail(formCompanyName, companyName);
		selectCountryDropdown(countryName);
		enterDetail(formEmail, email);
		
		// Mobile phone number and enquiry details are not mandatory. Hence a condition has been added to type these details only if value is passed.
		// Test cases without these details can be added and tested
		if(mobileNumber != null)
		{
			enterDetail(formMobileNumber,mobileNumber);
		}
		
		if(enquiryDetails != null)
		{
			enterDetail(formEnquiryDetails, enquiryDetails);
		}
		
		//Tick the checkbox only if checkboxStatus is true
		if(checkboxStatus == true)
		{
			clickAgreeCheckbox();
		}
	}
	
	private void clickAgreeCheckbox()
	{
		js.executeScript("arguments[0].click();", formAgreeCheckbox);
		assertEquals("true", formAgreeCheckboxStatus.getAttribute("value"));
	}
	
	private void selectCountryDropdown(String countryName)
	{
		Select dropdown = new Select(formCountry);
		dropdown.selectByVisibleText(countryName);
		assertEquals(countryName, dropdown.getFirstSelectedOption().getText());
	}
	
	private void enterDetail(WebElement element, String text)
	{
		element.sendKeys(text);
		assertEquals(text, element.getAttribute("value"));
	}
}