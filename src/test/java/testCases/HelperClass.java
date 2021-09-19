package testCases;



import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import browserManager.CaptureScreenshot;
import browserManager.ChromeBrowserManager;

/**
 * <p>
 * This abstract class navigates to Intelligence Bank website. It verifies the test status, captures screenshot if the test fails.
 * All test case classes has to inherit this Helper class.
 * </p>
 * <p>
 * @author shruthi
 * </p>
 *
 */
public abstract class HelperClass
{
	private static final String intelligenceBankURL = "https://www.intelligencebank.com";
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver = ChromeBrowserManager.getBrowser(driver);
		driver.navigate().to(intelligenceBankURL);
	}
	
	//This method also takes a screenshot when test fails. The screenshot will be the page where the test failed.
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			try
			{
				CaptureScreenshot screenShotOnFailure = new CaptureScreenshot(driver);
				System.err.println("Failure Screenshot is at : " + screenShotOnFailure.takeScreenshot(result.getMethod().getMethodName()));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		driver.quit();
	}
}
