package webdriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Topic_03_WebElement 
{
	WebDriver driver;
  
  @BeforeClass
  public void beforeClass() 
  {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.get("http://live.demoguru99.com/");
	  
	  
  }
@Test
  
public void TC_01_WebElement()
 {
	  // Muốn tìm element trước thì phải khai báo element trước
	// Tìm 1 element
	//driver.findElement(By.id(""));
	//driver.findElement(By.id("small-searchterms")).sendKeys("apple");
	//Tìm nhiều element phải khai báo biến
	//driver.findElements(By.id("small-searchterms")).clear();
	//driver.findElement(By.id("small-searchterms")).sendKeys("orange");
	WebElement searchTextbox = driver.findElement(By.id("small-searchterms"));
	searchTextbox.clear();
	searchTextbox.sendKeys("apple");
	searchTextbox.getAttribute("value");
	//Đếm xem co bao nhiêu element thỏa điều kiện
	// Verify số lượng element trả về đúng như mong đợi
	List<WebElement> textboxes = driver.findElements(By.xpath("//div[@class='inputs']/input[@type!='checkbox']"));
	//Lấy số lượng . Verify có 6 cái
	Assert.assertEquals(textboxes.size(),6);
	//Textbox/TextArea/Editable Dropdown
	searchTextbox.clear();
	searchTextbox.sendKeys("");
	WebElement singleElement = driver.findElement(By.className(""));
	singleElement.sendKeys();
	singleElement.clear();
	singleElement.click();
	//Các hàm có tiền tố bắt đầu get luôn luôn trả về dữ liệu.
	//getTitle/ getCurrentUrl/ getAttributeValue/ getCssValue/ getText/
	singleElement = driver.findElement(By.xpath("//input[@id='FirstName']"));
	singleElement.getAttribute("value");
	singleElement = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
	singleElement.getAttribute("placeholder");
	
}
 @AfterClass
 public void afterClass() 
 {
	 driver.quit();
	  
 }

}
