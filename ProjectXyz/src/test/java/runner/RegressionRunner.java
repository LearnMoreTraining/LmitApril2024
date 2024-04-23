package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/testdesign"},
        glue = {"stepdef","hookspack"},
        tags = "@amazon01",
        plugin = {"pretty",
                "html:target/test-output/report.html",
                "json:target/test-output/report.json",
                "junit:target/test-output/report.xml"}
)

public class RegressionRunner {
}
