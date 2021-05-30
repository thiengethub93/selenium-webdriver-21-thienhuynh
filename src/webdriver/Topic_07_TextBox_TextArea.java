package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Topic_07_TextBox_TextArea {
	WebDriver webdriver;
	String email;
	String Loginurl;
	String UserID;
	String Password;
	String name;
	String dob;
	String addr;
	String city;
	String state;
	String pinno;
	String telephoneno;
	String emailid;
	String password;
	String CustomerID;
	String addr2;
	String newpin;
	String gender;
	String telephoneno2;
	By nameTextBody = By.name("name");
	By dobTextBody = By.name("dob");
	By addressTextBody = By.name("addr");
	By cityTextBody = By.name("city");
	By stateTextBody = By.name("state");
	By pinnoTextBody = By.name("pinno");
	By mobileTextBody = By.name("telephoneno");
	By emailidTextBody = By.name("emailid");
	By passwordTextBody = By.name("password");
	By genderTextBody = By.name("gender");
  @BeforeClass
  public void beforeClass() 
  {
	  
	  webdriver = new FirefoxDriver();
	  webdriver.manage().window().maximize();
	  webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  webdriver.get("http://demo.guru99.com/v4/");
	  email = "autothien" + generateEmail();
	  Loginurl = "http://demo.guru99.com/v4/";
	  name = "Auto Thien";
	  dob = "1993-03-01";
	  addr = "123 Building";
	  city = "San Jose";
	  state = "California";
	  pinno = "123456";
	  telephoneno ="01123456789";
	  emailid = "thientest@mailinator.com";
	  password = "123456";
	  gender = "male";
	  addr2 = "124 Building";
	  newpin = "123450";
	  telephoneno2 ="04123456784";
	  
	  
	   
  }
  @Test
  public void TC_01_Register()
  {
	  webdriver.findElement(By.xpath("//a[text()='here']")).click();
	  webdriver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
	  webdriver.findElement(By.xpath("//input[@type='submit']")).click();
	  UserID = webdriver.findElement(By.xpath("//td[contains(text(),'User ID')]/following-sibling::td")).getText();
	  Password = webdriver.findElement(By.xpath("//td[contains(text(),'Password')]/following-sibling::td")).getText();
	  
  }
  
@Test
 public void TC_02_Login()
  {
	webdriver.get(Loginurl);
	webdriver.findElement(By.xpath("//input[@name='uid']")).sendKeys(UserID);
	webdriver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
	webdriver.findElement(By.xpath("//input[@type='submit']")).click();
	Assert.assertEquals(webdriver.findElement(By.cssSelector("marquee.heading3")).getText(), "Welcome To Manager's Page of Guru99 Bank");
	    
  }
   
 @Test
  public void TC_03_Create_New_User()
  {
	 	
    webdriver.findElement(By.xpath("//a[text()='New Customer']")).click();
	Assert.assertEquals(webdriver.findElement(By.cssSelector(".heading3")).getText(),"Add New Customer");
	webdriver.findElement(nameTextBody).sendKeys(name);
	webdriver.findElement(dobTextBody).sendKeys(dob);
	webdriver.findElement(addressTextBody).sendKeys(addr);
	webdriver.findElement(cityTextBody).sendKeys(city);
	webdriver.findElement(stateTextBody).sendKeys(state);
	webdriver.findElement(pinnoTextBody).sendKeys(pinno);
	webdriver.findElement(mobileTextBody).sendKeys(telephoneno);
	webdriver.findElement(emailidTextBody).sendKeys(email);
	webdriver.findElement(passwordTextBody).sendKeys(password);
	webdriver.findElement(By.name("sub")).click();
	Assert.assertEquals(webdriver.findElement(By.cssSelector(".heading3")).getText(),"Customer Registered Successfully!!!");
	Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(),name);
	Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(),dob);
	Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),addr);
	Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(),city);
	Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),state);
	Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(),pinno);
	Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),telephoneno);
	Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),email);
	CustomerID = webdriver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
	
	
	
  }
  
  @Test
  public void TC_04_Edit_Customer()
  {
	  webdriver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
	  Assert.assertEquals(webdriver.findElement(By.cssSelector(".heading3")).getText(),"Edit Customer Form");
	  webdriver.findElement(By.xpath("//input[@type='text']")).sendKeys(CustomerID);
	  webdriver.findElement(By.xpath("//input[@type='submit']")).click();
	  Assert.assertFalse(webdriver.findElement(nameTextBody).isEnabled());
	  Assert.assertFalse(webdriver.findElement(genderTextBody).isEnabled());
	  Assert.assertFalse(webdriver.findElement(dobTextBody).isEnabled());
	  Assert.assertEquals(webdriver.findElement(nameTextBody).getAttribute("value"),name);
	  Assert.assertEquals(webdriver.findElement(genderTextBody).getAttribute("value"),gender);
	  Assert.assertEquals(webdriver.findElement(dobTextBody).getAttribute("value"),dob);
	  Assert.assertEquals(webdriver.findElement(addressTextBody).getText(),addr);
	  Assert.assertEquals(webdriver.findElement(cityTextBody).getAttribute("value"),city);
	  Assert.assertEquals(webdriver.findElement(stateTextBody).getAttribute("value"),state);
	  Assert.assertEquals(webdriver.findElement(pinnoTextBody).getAttribute("value"),pinno);
	  Assert.assertEquals(webdriver.findElement(mobileTextBody).getAttribute("value"),telephoneno);
	  Assert.assertEquals(webdriver.findElement(emailidTextBody).getAttribute("value"),email);
	  // Edit customer
	  webdriver.findElement(addressTextBody).clear();
	  webdriver.findElement(addressTextBody).sendKeys(addr2);
	  webdriver.findElement(cityTextBody).clear();
	  webdriver.findElement(cityTextBody).sendKeys(city);
	  webdriver.findElement(stateTextBody).clear();
	  webdriver.findElement(stateTextBody).sendKeys(state);
	  webdriver.findElement(pinnoTextBody).clear();
	  webdriver.findElement(pinnoTextBody).sendKeys(newpin);
	  webdriver.findElement(mobileTextBody).clear();
	  webdriver.findElement(mobileTextBody).sendKeys(telephoneno2);
	  webdriver.findElement(emailidTextBody).clear();
	  webdriver.findElement(emailidTextBody).sendKeys(email);
	  webdriver.findElement(By.xpath("//input[@name='sub']")).click();	  	 
	  Assert.assertEquals(webdriver.findElement(By.cssSelector(".heading3")).getText(),"Customer details updated Successfully!!!");
	  Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText(),CustomerID);
	  Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(),name);
	  Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(),dob);
	  Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),addr2);
	  Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(),city);
	  Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),state);
	  Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(),newpin);
	  Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),telephoneno2);
	  Assert.assertEquals(webdriver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),email);
  }
  @AfterClass
  public void afterClass() 
  {
	  webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  webdriver.quit();
  }
  public String generateEmail()
  {
	Random rand = new Random();
	return rand.nextInt(9999) + "@mailinator.com";
	  
  }

  

}
	  
  
  
    	  
    	  
    	  
      
		  
		  
		  
		  
		  
		  
	  
	
		  
		  
	  
  
	  
	 
  
  
