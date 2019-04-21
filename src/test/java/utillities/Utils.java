package utillities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Utils 
{
	public static String EnvURL;
	public static WebDriver driver;
	public static Boolean driverSession= false;	
	
//To launch the browser if the session is not active already	
	public static void setDriver(){
		if(!driverSession)
		{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driverSession = true;
		}
	}	
	public static void QuitDriver(){
		driver.quit();
		driverSession=false;
		
	}
	public static void launchApp()
	{
		driver.navigate().to("http://localhost:3000/");
		driver.manage().window().maximize();
	}	
}
