package runner;

import Core.BaseTest;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.en.And;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = ".//src/test/resources/featurefiles/",
        glue = {"Stepdefinitions"},
        plugin = {"pretty", "html:target/htmlReport.html"}
       // tags = "@playback"

)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
