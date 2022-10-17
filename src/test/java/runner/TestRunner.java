package runner;

import Core.BaseTest;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.en.And;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = ".//src/test/resources/featurefiles/DataTables.feature",
        glue = {"Stepdefinitions"},
        plugin = {"pretty", "html:target/htmlReport.html"},
        tags = "@playback"

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
