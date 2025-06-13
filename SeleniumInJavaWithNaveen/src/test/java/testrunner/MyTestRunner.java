package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = {"src/test/resource/com/feature"},
	    glue = {"stepdefinitions", "apphooks"},
	    plugin = {"pretty"}
	)

public class MyTestRunner {

}