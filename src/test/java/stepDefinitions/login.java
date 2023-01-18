package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class login {
	
	public WebDriver driver;
	public String appurl = "https://demoqa.com/login";
	
	@Given("I opened the Chrome browser and I open application URL")
	public void i_opened_the_chrome_browser_and_i_open_application_url() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amit.kumar\\Documents\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(appurl);
	}

	@When("I entered username {string} and password {string}")
	public void i_entered_username_and_password(String username, String paswword) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(paswword);
	}

	@When("I click on Login button")
	public void i_click_on_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='login']")).click();
		Thread.sleep(3000);
	}

	
    @When("^I entered username (.+) and password (.+) and click login button$")
    public void i_entered_username_and_password_and_click_login_button(String username, String password) throws Throwable {
    	driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='login']")).click();
		Thread.sleep(2000);
    }
    
	@Then("I verified user loged in successfully")
	public void i_verified_user_loged_in_successfully() {
		boolean status = driver.findElement(By.xpath("//label[text()='newtest']")).isDisplayed();
		Assert.assertTrue(status);
	}

	
	@Then("I logout from application and close the browser")
	public void i_logout_from_application_and_close_the_browser() {
		driver.findElement(By.xpath("//button[text()='Log out']")).click();
		driver.quit();
	}
	
	
	@Then("I verified user not loged in and close the browser")
	public void I_verified_user_not_loged_in_and_close_the_browser()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='name']")).getText().equals("Invalid username or password!"));
		driver.quit();
	}
	
	
    @Then("^I verified user (.+) is displayed on home page$")
    public void i_verified_user_is_displayed_on_home_page(String username) throws Throwable {
    	String actualName = driver.findElement(By.xpath("//label[text()='"+username+"']")).getText();
    	System.out.println(actualName);
    	//Assert.assertEquals(actualName, username);
    }


    
    
}
