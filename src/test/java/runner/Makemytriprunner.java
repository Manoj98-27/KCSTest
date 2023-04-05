package runner;
        import io.cucumber.testng.AbstractTestNGCucumberTests;
        import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/resources/features",
        glue = {"classpath:Stepdef"},
        tags = "@test",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class Makemytriprunner extends AbstractTestNGCucumberTests {


}

