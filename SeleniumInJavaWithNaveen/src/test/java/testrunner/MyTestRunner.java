package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:com/features/AccountsPage.feature", // Fixed path
		glue = {"stepdefinitions", "apphooks"},
		tags = "@accounts", // Must match your feature file tag
		plugin = {
				"pretty",
				"html:target/cucumber-reports/cucumber.html",
				"json:target/cucumber-reports/cucumber.json"
		},
		monochrome = true,
		publish = false
)
public class MyTestRunner {
}