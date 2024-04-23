package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/testdesign"},
        glue = {"stepdef","hookspack"},
        tags = "@smoketest",
        plugin = {"pretty"}
)
public class SmokeTestRuunner {
}
