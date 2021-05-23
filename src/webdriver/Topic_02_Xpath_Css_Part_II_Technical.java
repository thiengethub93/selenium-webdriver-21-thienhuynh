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
public class Topic_02_Xpath_Css_Part_II_Technical 
{   
	
	// Biến driver đại diện cho Selenium WebDriver
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	}

	@Test //  chi duong chay cho TESTNG "@Test"la nhung test case auto TESTNG phai chay
	public void TC_01() 
	{
		//driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("thienthien@mailinator.com");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//div[@class='footer']//a[(text()='My Account')]")).click();
		driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
	}

	@Test
	public void TC_02_Class() 
	{
		
       
	}

	@Test
	public void TC_03_Name() 
	{
		
		
	}
	@Test
	public void TC_04_TagName() 
	{
		
		
	}
	@Test
	public void TC_05_LinkTest() 
	{
		
		
	}
	@Test 
	public void TC_06_Partial_LinkTest() 
	{
		
	}
	@Test
	public void TC_08_Xpath() 
	{
		
		
	}
	@Test
	public void TC_07_Css() 
	{
		
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




