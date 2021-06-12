package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeys_Actions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		WebElement email=driver.findElement(By.id("email"));
		
		WebElement pwd=driver.findElement(By.id("pass"));
		
		WebElement login=driver.findElement(By.name("login"));
		
		Actions a=new Actions(driver);
		
		
		
				sendKeys_Actions(driver,email,"Sumit");
			sendKeys_Actions(driver,pwd,"12345");
			
			
			logButton(driver,login);
			
		
		

	}
	
	public static void sendKeys_Actions(WebDriver driver,WebElement element,String val)
	{
          Actions a=new Actions(driver);
		
		
		a.sendKeys(element, val).build().perform();
		
		
		
	}
	
	public static void logButton(WebDriver driver,WebElement element)
	{
		  Actions a=new Actions(driver);
		  a.click(element).build().perform();
	}

}
