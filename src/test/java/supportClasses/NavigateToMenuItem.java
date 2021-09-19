package supportClasses;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * <p>
 * This support class has methods to navigate to different pages from <a href="https://www.intelligencebank.com">Intelligence Bank</a> home page.
 * Currently only navigation to "Contact Us" page has been added.
 * </p>
 * <p>
 * @author shruthi
 * </p>
 */

public class NavigateToMenuItem
{
	private static final String contactUsPageTitle = "Contact Us - IntelligenceBank";
	private static final String homePageTitle = "Marketing Operations Software for Enterprises - IntelligenceBank";
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public NavigateToMenuItem(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text() ='CONTACT US']")
	WebElement contactUsMenu;
	
	@FindBy(className = "AddressBox")
	WebElement addressElement;
	
	/*
	 * This method clicks contact us on the main menu, waits until address element on contact us page is loaded and asserts page title.
	 */
	public void goToContactUsPage()
	{
		contactUsMenu.click();
		wait.until(ExpectedConditions.visibilityOf(addressElement));
		assertPageTitle(contactUsPageTitle);
	}
	
	public void assertHomePage()
	{
		assertPageTitle(homePageTitle);
	}
	
	private void assertPageTitle(String expectedPageTitle)
	{
		assertEquals(expectedPageTitle, driver.getTitle());
	}
}
