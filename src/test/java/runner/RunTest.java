package runner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utillities.Utils;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:FeatureFiles"}, tags= "@Regression", monochrome = true,
		format = {"pretty","json:target/weather.json",	
				"rerun:target/HTML-Report/rerun.txt",
				"html:target/HTML-Report"}	
		)
public class RunTest extends Utils {

	@AfterClass
	public static void AfterAllTest(){
		driver.quit();
	}	
}

