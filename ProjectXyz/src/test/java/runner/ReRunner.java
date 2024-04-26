package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"@target/rerun.txt"},
        glue = {"stepdef","hookspack"},
        plugin = {"pretty",
                "html:target/test-output/report.html",
                "json:target/test-output/report.json",
                "junit:target/test-output/report.xml",
                "rerun:target/rerun.txt"
        }
)

public class ReRunner {
}
