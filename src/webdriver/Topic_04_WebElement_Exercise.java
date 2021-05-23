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

public class Topic_04_WebElement_Exercise {
	WebDriver webdriver;
  @BeforeClass
  public void beforeClass() 
  {
	  
	  webdriver = new FirefoxDriver();
	  webdriver.manage().window().maximize();
	  webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  webdriver.get("http://live.demoguru99.com/");
  }
  @Test
  public void TC_01_VerifyURL()
  {
	  webdriver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  webdriver.getCurrentUrl();
	  webdriver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	  webdriver.getCurrentUrl();
	  
  }
  @Test
  public void TC_02_VerifyTitle()
  {
	  webdriver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
      webdriver.getTitle();
      webdriver.findElement(By.xpath("//a[@title='Create an Account']")).click();
      webdriver.getTitle();
  }
  @Test
  public void TC_03_NavigateFunction()
  {
	  webdriver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
      webdriver.findElement(By.xpath("//a[@title='Create an Account']")).click();
      webdriver.getCurrentUrl();
      webdriver.navigate().back();
      webdriver.getCurrentUrl();
      webdriver.navigate().forward();
      webdriver.getTitle();
      
  }
  @Test
  public void TC_04_GetPageSourceCode()
  {
	  webdriver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  Assert.assertTrue(webdriver.findElement(By.xpath("//h1[contains(text(),'Login or Create an Account')]")).isDisplayed());
	  webdriver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	  webdriver.getPageSource();
	  Assert.assertTrue(webdriver.findElement(By.xpath("//h1[contains(text(),'Create an Account')]")).isDisplayed());
	  
  }
  @AfterClass
  public void afterClass() 
  {
	  webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  webdriver.quit();
  }

  

}
