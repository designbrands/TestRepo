package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class GlobalHooks {
	public WebDriver driver;
	public String appurl = "https://demoqa.com/login";
	
	@Before
	public void StartApplicationInBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amit.kumar\\Documents\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get(appurl);
	}
	
	@After
	public void CloseAllBrowsers()
	{
		driver.quit();
	}

}
