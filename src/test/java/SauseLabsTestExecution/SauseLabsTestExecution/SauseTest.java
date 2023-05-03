package SauseLabsTestExecution.SauseLabsTestExecution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauseTest extends BaseTest{
	
	public WebDriver driver;	
	
	@BeforeMethod
	public void setUp()
	{
		driver=initializeBrowser("chrome"); 
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Parameters({"browser","platform"})  
	@Test(priority=1)
	public void fireFoxTest(Method method,String browserName, String platform) throws MalformedURLException 
	{
		
		System.out.println("browser nameis: "+browserName);
		MutableCapabilities sauceOptions=new MutableCapabilities();
		sauceOptions.setCapability("build", "selenium-build-WQ28I");
		sauceOptions.setCapability("seleniumVersion","4.7.2");
		sauceOptions.setCapability("username", "oauth-varalakshmi.kurri-a5461");
		sauceOptions.setCapability("accesskey", "b061a7a4-7e76-412c-b7c5-e089bd8b0ab2");
		sauceOptions.setCapability("name", method.getName());

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOptions);
		cap.setCapability("browserVersion","latest");
		cap.setCapability("platformName", platform);
		cap.setCapability("browserName", browserName);
			
		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='inventory_item']"));
		System.out.println("list size"+list.size());
		Assert.assertTrue(list.size()==6, "the list is 6");
		List<WebElement> list2=driver.findElements(By.xpath("//button[text()='Add to cart']"));
		System.out.println("list size"+list2.size());
		Assert.assertTrue(list2.size()==6, "the list is 6");
		driver.quit();
	}
	
	@Parameters({"browser","platform"})  
	@Test(priority=2)
	public void chromeTest(Method method,String browserName,String platform) throws MalformedURLException 
	{
		
		System.out.println("browser nameis: "+browserName);
		MutableCapabilities sauceOptions=new MutableCapabilities();
		sauceOptions.setCapability("build", "selenium-build-WQ28I");
		sauceOptions.setCapability("seleniumVersion","4.7.2");
		sauceOptions.setCapability("username", "oauth-varalakshmi.kurri-a5461");
		sauceOptions.setCapability("accesskey", "b061a7a4-7e76-412c-b7c5-e089bd8b0ab2");
		sauceOptions.setCapability("name", method.getName());

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOptions);
		cap.setCapability("browserVersion","latest");
		cap.setCapability("platformName", platform);
		cap.setCapability("browserName", browserName);
	
		//browserOptions.addArguments("--remote-allow-origins=*");
		
		
		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='inventory_item']"));
		System.out.println("list size"+list.size());
		Assert.assertTrue(list.size()==6, "the list is 6");
		List<WebElement> list2=driver.findElements(By.xpath("//button[text()='Add to cart']"));
		System.out.println("list size"+list2.size());
		Assert.assertTrue(list2.size()==6, "the list is 6");
		driver.quit();
	}
	

	
		
	}

