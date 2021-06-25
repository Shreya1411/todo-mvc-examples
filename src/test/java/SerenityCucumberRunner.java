import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/automation"
        , tags = "@web and @automated and @test"
        , plugin = "pretty")
public class SerenityCucumberRunner {
}
