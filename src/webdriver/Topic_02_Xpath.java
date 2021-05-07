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
		driver.get("http://live.demoguru99.com/");
	}

	@Test //  chi duong chay cho TESTNG "@Test"la nhung test case auto TESTNG phai chay
	public void TC_01_EmptyEmail() 
	{
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");
		//Assert.assertEqual: Là lệnh dùng cho Verify messsage
		//Assert: Lưu Xpath
		//assertEqual: Lưu text message. 
		SleepInSecond(3);

	}

	@Test
	public void TC_02_InvalidEmail() 
	{
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("email@123.123.123.123");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
		SleepInSecond(3);
	}

	@Test
	public void TC_03_IncorrectPassword() 
	{
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ryanhuynh123@mailinator.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
		
	}
	@Test
	public void TC_04_InvalidLogin() 
	{
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(),"Invalid login or password.");
		
	}
	@Test
	public void TC_05_AccountCreation() 
	{
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Thien");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Ryan");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("thienryan123@mailinator.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@class='checkbox']")).click();
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Thank you for registering with Main Website Store.");
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




