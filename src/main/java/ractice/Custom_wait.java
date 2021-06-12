package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://classic.freecrm.com/index.html");

		By email = By.name("username");
		By password = By.name("password");
		
		getElementWithWait(driver,email,1).sendKeys("Sabretooth");
		

	}
	
	public static WebElement getElementWithWait(WebDriver driver,By locator,int timeout)
	{
		WebElement element=null;
		
		for(int i=0;i<timeout;i++)
		{
			try
			{
				element=driver.findElement(locator);
				break;
			}
			catch(Exception e)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e1)
				{
					
				}
			}
		}
		return element;
	}
	
	// Modifying custom wait to return true or false if element is displayed or not.
	public static boolean isElementDisplayed(WebDriver driver,By locator,int timeout)
	{
		WebElement element=null;
		boolean flag=false;
		
		for(int i=0;i<timeout;i++)
		{
			try
			{
				element=driver.findElement(locator);
				flag=element.isDisplayed();
				break;
			}
			catch(Exception e)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e1)
				{
					
				}
			}
		}
		return flag;
	}

}
