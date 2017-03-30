package testAutomation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by daljeetsidhu on 27/03/2017.
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        tags = "@Delete",
        glue={"testAutomation"},
        plugin = {"pretty:target/cucumber-pretty.txt"}
)

public class runTest { }

