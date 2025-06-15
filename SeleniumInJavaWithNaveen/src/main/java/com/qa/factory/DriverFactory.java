package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	// ThreadLocal for parallel execution support
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initDriver(String browser) {
		System.out.println("Browser value is: " + browser);

		if (browser == null) {
			browser = "chrome"; // default browser
		}

		switch(browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver());
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver());
				break;
			default:
				System.out.println("Unsupported browser: " + browser);
				throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return driver.get();
	}

	public static void removeDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}