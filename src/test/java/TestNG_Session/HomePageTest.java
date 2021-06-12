package TestNG_Session;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ractice.Utility;


public class HomePageTest {
	
	
	WebDriver driver;
	
	LoginTest log=new LoginTest();
	
	
	
	By email=log.email;
	By pass=log.password;
	
	By login=log.login;
	
	By deals=By.xpath("//div[contains(text(),'Deals')]");
	
	By contactsActivity=By.xpath("//div[contains(text(),'Contacts activity stream')]");
	
	By itemList=By.xpath("//span[@class='item-text']");
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String browserName) throws Exception
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://ui.cogmento.com/");
		
	}
	
	@Test(priority=-1)
	
	public void dealsTextTest()
	{
		driver.findElement(email).sendKeys("sm97876@gmail.com");
		driver.findElement(pass).sendKeys("Sabretooth");
		
		driver.findElement(login).click();
		AssertJUnit.assertTrue(driver.findElement(deals).isDisplayed());
	}
	
	@Test
	public void contactsActivityTest()
	{
		String contactsText=driver.findElement(contactsActivity).getText();
		System.out.println(contactsText);
		
		AssertJUnit.assertEquals(contactsText, "Contacts activity stream");
	}
	@Test
	public void itemsList()
	{
		List<WebElement> items=driver.findElements(itemList);
		
		items.stream().forEach(ele->System.out.println(ele.getText()));
	}
	
	@AfterTest
	
	public void tearDown()
	{
		driver.quit();
	}
	

}
