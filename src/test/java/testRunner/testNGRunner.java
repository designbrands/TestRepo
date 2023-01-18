package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features/login.feature",
							glue = "stepDefinitions")
public class testNGRunner extends AbstractTestNGCucumberTests{

	
}
