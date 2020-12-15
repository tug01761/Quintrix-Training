package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:cucumber/Features" }
,glue = { "helpers", "classpath:cucumber/stepdefs" }
,plugin = { "pretty", "json:target/cucumber/cucumber.json" })

public class RunCucumberTest {

}
