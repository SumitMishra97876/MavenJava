package TestNG_Session;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	public WebDriver driver;
	
	SoftAssert softAssert;
	
	
	public LoginTest()
	{
		
	}
	
	
	By email=By.name("email");
	
	By password=By.name("password");
	
	By login=By.xpath("//div[contains(text(),'Login')]");
	
	By signup=By.xpath("//a[contains(text(),'Sign Up')]");
	
	By forgotPassword=By.partialLinkText("Forgot your");
	By homePage =By.xpath("//span[@class='user-display']");
	
	
	
	 @BeforeMethod
	 @Parameters({"browser"})
	 public void setUp(String browserName) throws Exception
	 {
		 
		 if(browserName.equals("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		 }
		 else if(browserName.equals("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		 }
		 else
		 {
			 System.out.println("Please enter correct browser");
			 
			 throw new Exception("NoSuchBrowserException");
		 }
		 
		 
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://ui.cogmento.com/");
		 
		 softAssert=new SoftAssert();
		 
	 }
	 
	 @Test(priority=-1)
	 public void signUpLinkTest()
	 {
		 String signUpText=driver.findElement(signup).getText();
		 
		 softAssert.assertEquals(signUpText, "Sign Up1","Sign Up Text Not Correct...");
		 
		 System.out.println(signUpText);
		 softAssert.assertAll();
		 
	 }
	 
	 @Test
	 public void verifyTitleTest()
	 {
		String title= driver.getTitle();
		softAssert.assertEquals(title, "Cogmento CRM");
		 softAssert.assertAll();
	 }
	 
	 @Test 
	 public void forgotPasswordTest()
	 {
		 softAssert.assertTrue(driver.findElement(forgotPassword).isDisplayed());
		 softAssert.assertAll();
	 }
	 
	 @Test
	 public void homePageTest()
	 {
		 driver.findElement(email).sendKeys("sm97876@gmail.com");
		 
		 driver.findElement(password).sendKeys("Sabretooth");
		 
		 driver.findElement(login).click();
		 
		 String homePageHeader=driver.findElement(homePage).getText();
		 
		 softAssert.assertEquals(homePageHeader, "Sumit Mishra");
		 
		 softAssert.assertAll();
	 }
	 
	@AfterMethod
	
	public void tearDown()
	{
		
		driver.quit();
	}

}
