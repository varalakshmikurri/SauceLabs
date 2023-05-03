package SauseLabsTestExecution.SauseLabsTestExecution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	
	public WebDriver initializeBrowser(String browserName)
	{
		WebDriver driver;
		DesiredCapabilities cap=new DesiredCapabilities();
		if(browserName.equals("chrome"))
		{
			cap.setBrowserName("chrome");
		}
		else if(browserName.equals("firefox"))
		{
			cap.setBrowserName("firefox");		
		}
		else if (browserName.equals("edge"))
		{
			cap.setBrowserName("MicrosoftEdge");	
		}
		else if (browserName.equals("safari"))
		{
			cap.setBrowserName("safari");	
		} 
		URL url = null;
		try {
			url = new URL("http://localhost:4444");
			}
		catch (MalformedURLException e) 
			{
			e.printStackTrace();
			}
		driver=new RemoteWebDriver(url,cap);
		return driver;
	}
	
	
	
	

}
