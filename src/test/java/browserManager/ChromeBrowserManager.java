package browserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * <p>
 * This class initiates chrome browser with its settings.
 * </p>
 * <p>
 * @author shruthi
 *</p>
 */

public class ChromeBrowserManager {

	public static WebDriver getBrowser(WebDriver driver)
	{
		if (driver == null)
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("enable-automation");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
		}
		return driver;
	}
}

