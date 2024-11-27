package testFile;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "src/main/java/testFile/StepDefiniationFile",
        plugin = {
                "pretty",                               // Console output
                "html:target/cucumber-reports.html",   // HTML report
                "json:target/cucumber.json"           // JSON report (for additional integrations)
        },
        monochrome = true,
        tags = "@Test_01"
)

public class CucmberTestSuite {


}
