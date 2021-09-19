package browserManager;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


/**
 * <p>
 * This method creates a "screenshots" folder (if not present) in the root directory and saves screenshots in this folder.
 * </p>
 * <p>
 * @author shruthi
 * </p>
 */

public class CaptureScreenshot
{	
	private WebDriver driver;

	public CaptureScreenshot(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String takeScreenshot(String testMethodName)
	{
		String fileName = testMethodName + ".png";
		String directory = System.getProperty("user.dir") + "//screenshots//";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileLocation = System.getProperty("user.dir") + "\\screenshots\\" + fileName;
		try
		{
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		return fileLocation;
	}
 }

