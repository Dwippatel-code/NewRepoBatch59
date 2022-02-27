package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//not allow to use driver in main method
//	public WebElement email = driver.findElement(By.id("usernameInput-input"));
//	public WebElement password =driver.findElement(By.name("password"));
//	public WebElement loginButton =driver.findElement(By.id("signIn"));
//	public WebElement globalError= driver.findElement(By.id("globalError"));
//	public WebElement generalError= driver.findElement(By.className("Error__text"));

	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement loginButton;
	
	@FindBy(id = "globalError")
    public WebElement globalError;
	
	@FindBy(className = "Error__text")
    public WebElement genaralError;

	
	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream("C:\\QA traing\\testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);

		String browser1= prop.getProperty("browser");
		System.out.println(browser1);
		if(browser1.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver","C:\\QA traing\\Selenium Jars\\geckodriver.exe");
		driver = new FirefoxDriver();
		}else if (browser1.equals("Chrome")){
		System.setProperty("webdriver.chrome.driver","C:\\QA traing\\Selenium Jars\\chromedriver.exe");
		driver = new ChromeDriver();

		}
		PageFactory.initElements(driver, this);
	}
	public void openLoginpage() {
	driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=txLZ02XTxdA&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoidHhMWjAyWFR4ZEEiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzOTMyODIxMCwiaWF0IjoxNjM5MzI3MDEwLCJqdGkiOiJkYWZiM2FjYi1jMmI0LTRlMzUtOGI2YS02MGRjZjk3ZDBiYTkiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.ohD_i4ESLoeldvufxoWemXsXEm3wNkCLCyV3BOU6BLRe2JRPgUX7S9CPLzDMC5HCm_03AtN_0UhG9n4JyRW5HjDUmsAKqhaQGkDNgCBD0oeyRPlmTyFASxjnfmszRmYu258e7i6sDxT2qmUSGsMDMkJ2SpRUg1FwvlimcqzppVrWkuT31liEMUl7t4stmBybQsVO23yKIn8R3OsojNBgjFnU159jcxrWDgFH_HxhgYhc47alblKX4QCeykQ-ngvZ6K1");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	public void login(String a,String b) throws InterruptedException {
//	driver.findElement(By.id("usernameInput-input")).sendKeys(a);
//	driver.findElement(By.name("password")).sendKeys(b);
//	driver.findElement(By.id("signIn")).click();
	email.sendKeys(a);
	password.sendKeys(b);
	loginButton.click();
	Thread.sleep(2000);
	}
	public void closeBrowser() {
		driver.quit();
	}
public String readglobalerr() {
	//String actual = driver.findElement(By.id("globalError")).getText();
	String actual =globalError.getText();
	System.out.println(actual);
	return actual;
}
public String readErr() {
	//String actual = driver.findElement(By.className("Error__text")).getText();
	String actual =genaralError.getText();
	System.out.println(actual);
	return actual;		
}
}
