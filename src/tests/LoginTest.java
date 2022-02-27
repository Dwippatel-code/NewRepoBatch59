package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
	LoginPage lp =new LoginPage();
	DataFile df= new DataFile();
 
@BeforeMethod
  public void beforeMethod() throws IOException {
	lp.openBrowser();
	lp.openLoginpage();
}
	  
//	  System.setProperty("webdriver.gecko.driver","C:\\Selenium Jars\\geckodriver.exe");
//		 driver = new FirefoxDriver();
//		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=txLZ02XTxdA&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoidHhMWjAyWFR4ZEEiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzOTMyODIxMCwiaWF0IjoxNjM5MzI3MDEwLCJqdGkiOiJkYWZiM2FjYi1jMmI0LTRlMzUtOGI2YS02MGRjZjk3ZDBiYTkiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.ohD_i4ESLoeldvufxoWemXsXEm3wNkCLCyV3BOU6BLRe2JRPgUX7S9CPLzDMC5HCm_03AtN_0UhG9n4JyRW5HjDUmsAKqhaQGkDNgCBD0oeyRPlmTyFASxjnfmszRmYu258e7i6sDxT2qmUSGsMDMkJ2SpRUg1FwvlimcqzppVrWkuT31liEMUl7t4stmBybQsVO23yKIn8R3OsojNBgjFnU159jcxrWDgFH_HxhgYhc47alblKX4QCeykQ-ngvZ6K1");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  

  @AfterMethod
  public void afterMethod() {
	 lp.closeBrowser();
  }
  
  
  @Test(priority = 1)

  public void loginwithwrongemailpass1() throws InterruptedException {
	
	//lp.login("asdf","asdf");
	lp.login(df.wrongEmail,df.wrongPassword);
	String expected = "Please check your card number / username or password and try again.";
	String actual = lp.readglobalerr();
	Assert.assertEquals(actual, expected);
	
	
  }
  
  
 @Test(priority = 2)

  public void loginWithEmptyEmailTest() throws InterruptedException {
		
		lp.login("",df.wrongPassword);
		String expected = "Please enter your username or card number.";
		String actual = lp.readglobalerr();
		Assert.assertEquals(actual, expected);
}

  @Test(priority = 3)

  public void loginWithEmptyPasswordTest() throws InterruptedException {
	 
	  	lp.login(df.wrongEmail,"");
		String expected = "Please enter your password.";
		String actual = lp.readErr();
		Assert.assertEquals(actual, expected);
}

  @Test(priority = 4)

  public void loginWithSpecialCharEmailTest() throws InterruptedException {
	  	
		lp.login(df.emailWithSpecCharErr,df.wrongPassword);
		String expected = "Please enter a username or card number without special characters.";
		String actual = lp.readErr();
		System.out.println(actual);		
		Assert.assertEquals(actual, expected);
}

}
////@Test(priority = 4)
//
//public void loginWithSpecialCharEmailTest() throws InterruptedException {
//	  	driver.findElement(By.id("usernameInput-input")).sendKeys("vdgsrgdzgesagr@#$");
//		driver.findElement(By.name("password")).sendKeys("xzgxfgsrh");
//		driver.findElement(By.id("signIn")).click();
//		
//		Thread.sleep(4000);
//		
//		String expected = "Please enter a username or card number without special characters.";
//		String actual = driver.findElement(By.className("Error__text")).getText();
//		System.out.println(actual);		
//		Assert.assertEquals(actual, expected);
//}