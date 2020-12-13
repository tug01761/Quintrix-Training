import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:Features" }
,glue = { "helpers", "classpath:stepdefs" }
,plugin = { "pretty", "json:target/cucumber/cucumber.json" })

public class RunCucumberTest {

}
