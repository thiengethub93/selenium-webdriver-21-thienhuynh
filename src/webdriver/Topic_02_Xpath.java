package webdriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Topic_02_Xpath 
{   
	
	// Biến driver đại diện cho Selenium WebDriver
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}

	@Test //  chi duong chay cho TESTNG "@Test"la nhung test case auto TESTNG phai chay
	public void TC_01_ID() 
	{
		driver.findElement(By.id("FirstName")).sendKeys("automation");
		//Click on mail radio button
		driver.findElement(By.id("gender-male")).sendKeys("Male");
		SleepInSecond(3);
		
	}

	@Test
	public void TC_02_Class() 
	{
		//refresh page
		driver.navigate().refresh();
		driver.findElement(By.className("search-box-text")).sendKeys("Macbook");
		SleepInSecond(3);
        driver.findElement(By.className("search-box-button")).click();	
        SleepInSecond(3);
	}

	@Test
	public void TC_03_Name() 
	{
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.findElement(By.name("Email" )).sendKeys("autotest@gmail.com");
		SleepInSecond(3);
		driver.findElement(By.name("Newsletter")).click();
		SleepInSecond(3);
		
	}
	@Test
	public void TC_04_TagName() 
	{
		System.out.println("sum link" + driver.findElement(By.tagName("a")).getSize());
		SleepInSecond(3);
		
	}
	@Test
	public void TC_05_LinkTest() 
	{
		driver.findElement(By.linkText("Log in")).click();
		SleepInSecond(3);
		
	}
	@Test 
	public void TC_06_Partial_LinkTest() 
	{
		driver.findElement(By.partialLinkText("Recently viewed")).click();
		SleepInSecond(3);
	}
	@Test
	public void TC_08_Xpath() 
	{
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("First Name");
		SleepInSecond(3);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("newone123@mailinator.com");
		SleepInSecond(3);
		
	}
	@Test
	public void TC_07_Css() 
	{
		driver.findElement(By.cssSelector("input[class=search-box-text ui-autocomplete-input']")).sendKeys("Macbook");
		SleepInSecond(3);
	}
	@Test

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void SleepInSecond(long timeoutinSecond )
	{
		try
		{
		Thread.sleep(timeoutinSecond * 1000);
		}
		catch (InterruptedException e )
		{
			e.printStackTrace();
		}
		
	}

}




