package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFiles/Sellics Assement.feature"},
        glue = {"pagesStepDef", "MyHooks"},
        plugin = {"pretty"},
        publish = true
)
public class MyTestRunner {
}
