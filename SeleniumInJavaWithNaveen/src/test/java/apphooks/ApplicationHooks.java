package apphooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

public class ApplicationHooks {
	private ConfigReader configReader;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browser = configReader.getBrowser();
		DriverFactory.initDriver(browser);
	}

	@After(order = 0)
	public void quitBrowser() {
		DriverFactory.removeDriver();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				WebDriver driver = DriverFactory.getDriver();
				byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath, "image/png", screenshotName);
			} catch (Exception e) {
				System.err.println("Failed to take screenshot: " + e.getMessage());
			}
		}
	}
}