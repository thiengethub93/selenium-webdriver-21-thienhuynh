package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Topic_05_WebElement {
	WebDriver webdriver;
  @BeforeClass
  public void beforeClass() 
  {
	  
	  webdriver = new FirefoxDriver();
	  webdriver.manage().window().maximize();
	  webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  webdriver.get("https://automationfc.github.io/basic-form/index.html");
  }
  @Test
  public void TC_01_CheckDisplayed()
  {
	  if(webdriver.findElement(By.xpath("//input[@id='email']")).isDisplayed())
	  {
		  webdriver.findElement(By.xpath("//input[@id='email']")).sendKeys("Automation FC");
		  System.out.println("Element is Displayed");
	  }
	  else
		  System.out.println("Newbie");
	  
	  if(webdriver.findElement(By.xpath("//input[@id='under_18']")).isDisplayed())
	  {
		  
		  System.out.println("Element is Displayed");
	  }
	  else
		  System.out.println("Newbie");
	  
	  if(webdriver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed())
	  {
		  webdriver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation FC");
		  System.out.println("Element is Displayed");
	  }
	  else
		  System.out.println("Newbie");  
	  
	  if(webdriver.findElement(By.xpath("//div[@class='figcaption']/h5[text()='Name: User5']")).isDisplayed())
	  {
		  System.out.println("Element is Displayed");
	  }
	  else
		  System.out.println("Newbie");
}
  
@Test
 public void TC_02_IsEnabled()
  {
	 if(webdriver.findElement(By.xpath("//input[@id='mail']")).isEnabled())
	 {
		 System.out.println("Element is Enabled");
	 }
	 else
		 System.out.println("Element is Disabled");
	 if(webdriver.findElement(By.xpath("//input[@id='under_18']")).isEnabled())
	 {
		 System.out.println("Element is Enabled");
	 }
	 else
		 System.out.println("Element is Disabled");
	 if(webdriver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled())
	 {
		 System.out.println("Element is Enabled");
	 }
	 else
		 System.out.println("Element is Disabled");
	 if(webdriver.findElement(By.xpath("//select[@id='job1']")).isEnabled())
	 {
		 System.out.println("Element is Enabled");
		 
		 
	 }
	 else
		 System.out.println("Element is Disabled");
	 
	 if(webdriver.findElement(By.xpath("//input[@id='development']")).isEnabled())
	 {
		 System.out.println("Element is Enabled");
		  
	 }
	 else
		 System.out.println("Element is Disabled");
	
     if(webdriver.findElement(By.xpath("//input[@id='slider-1']")).isEnabled())
	 {
		 System.out.println("Element is Enabled");
		 
		 
	 }
	 else
		 System.out.println("Element is Disabled");
     
  }
   
 @Test
  public void TC_02_IsDisabled()
  {
	  if(webdriver.findElement(By.xpath("//input[@name='user_pass']")).isEnabled())
		 {
			 System.out.println("Element is Enabled");
		 }
	  else
			 System.out.println("Element is Disabled");
		 
	  
	  if(webdriver.findElement(By.xpath("//input[@id='radio-disabled']")).isEnabled())
		 {
			 System.out.println("Element is Enabled");
		 }
	  else
			 System.out.println("Element is Disabled");
		 
	  
	  if(webdriver.findElement(By.xpath("//textarea[@id='bio']")).isEnabled())
		 {
			 System.out.println("Element is Enabled");
		 }
	  else
			 System.out.println("Element is Disabled");
	  
	  if(webdriver.findElement(By.xpath("//select[@id='job3']")).isEnabled())
		 {
			 System.out.println("Element is Enabled");
		 }
	  else
		  System.out.println("Element is Disabled");
	  
	  if(webdriver.findElement(By.xpath("//input[@id='check-disbaled']")).isEnabled())
		 {
			 System.out.println("Element is Enabled");
		 }
	  else
		  System.out.println("Element is Disabled");
	  
	  if(webdriver.findElement(By.xpath("//input[@id='slider-2']")).isEnabled())
		 {
			 System.out.println("Element is Enabled");
		 }
	  else
		  System.out.println("Element is Disabled");
	  
  }
  
  @Test
  public void TC_03_IsSelected()
  {
	  
	  Assert.assertFalse(webdriver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
	  Assert.assertFalse(webdriver.findElement(By.xpath("//input[@id='java']")).isSelected());
	  System.out.println("Element is Disabled");
	  webdriver.findElement(By.xpath("//input[@id='under_18']")).click();
	  webdriver.findElement(By.xpath("//input[@id='java']")).click();
	  Assert.assertTrue(webdriver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
	  Assert.assertTrue(webdriver.findElement(By.xpath("//input[@id='java']")).isSelected());
	  System.out.println("Element is Enabled");
	  	  
  }
  @AfterClass
  public void afterClass() 
  {
	  webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  webdriver.quit();
  }

  

}
	  
  
  
    	  
    	  
    	  
      
		  
		  
		  
		  
		  
		  
	  
	
		  
		  
	  
  
	  
	 
  
  
