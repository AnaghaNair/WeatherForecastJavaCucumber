package runner;
import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.Weather;

@SuppressWarnings("deprecation")
public class StepDef extends Weather{
	
public static WebDriverWait wait ;

@Before
public static void beforeMethod()
{
	setDriver();
}

@Given("^The Weather Forecast application is launched$")
public static void the_Weather_Forecast_application_is_launched() throws InterruptedException
{
	launchApp();
}

@Then("^I verify that page title is \"([^\"]*)\"$")
public void i_verify_that_page_title_is(String PageTitle) throws Throwable 
{	
    Assert.assertTrue(driver.getTitle().equals(PageTitle));
}

@Then("^I verify the header \"([^\"]*)\" is displayed$")
public void i_verify_the_header_is_displayed(String Header) throws Throwable 
{    
	CheckPageHeader(Header);
}

@Then("^I enter the city name as \"([^\"]*)\" and press enter$")
public void i_enter_the_city_name_as_and_press_enter(String CityName) throws Throwable
{	
	EnterCityName(CityName);
}

@Then("^I verify that five day weather forecast is displayed$")
public void i_verify_that_five_day_weather_forecast_is_displayed() throws Throwable 
{
	VerifyFiveDayData();
}

@When("^I click on day \"([^\"]*)\"$")
public void i_click_on_day(String DayNum) throws Throwable 
{
	driver.findElement(By.xpath("//span[@data-test='day-"+DayNum+"']")).click();
}

@Then("^The three hourly forecast is \"([^\"]*)\" for day \"([^\"]*)\"$")
public void the_three_hourly_forecast_is(String DisplayCOndition,String DayNum) throws Throwable 
{
	checkThreehourDetails(DisplayCOndition, DayNum);
}

@Then("^I verify the day \"([^\"]*)\" summary weather condition is same as the first three hour data$")
public void i_verify_the_day_summary_weather_condition_is_same_as_the_first_three_hour_data(String DayNum) throws Throwable 
{    
	CheckWeatherConditionSummary(DayNum);
}

@Then("^I verify the day \"([^\"]*)\" summary wind speed and direction is same as the first three hour data$")
public void i_verify_the_day_summary_wind_speed_and_direction_is_same_as_the_first_three_hour_data(String DayNum) throws Throwable {   
	checkWindspeedSummary(DayNum);
}

@Then("^I verify the day \"([^\"]*)\" maximum and minimum temperature summary is displayed correctly$")
public void i_verify_the_day_maximum_and_minimum_temperature_summary_is_displayed_correctly(String DayNum) throws Throwable {
	CheckMaxMinTemp(DayNum);	
}

@Then("^I verify the day \"([^\"]*)\" rainfall summary is the aggregate three hour data$")
public void i_verify_the_day_rainfall_summary_is_the_aggregate_three_hour_data(String DayNum) throws Throwable {   
	checkRainfallSummary(DayNum);
}

@After
public  void afterClass(Scenario scenario){
	if(scenario.isFailed()) 
	{
		try 
		{
			scenario.write("Current Page URL is " + driver.getCurrentUrl());
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} 
		catch (WebDriverException somePlatformsDontSupportScreenshots) 
		{
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		} 
		QuitDriver();
	}	
	System.out.println(scenario.getName()+" : "+scenario.getStatus());	
}
}
