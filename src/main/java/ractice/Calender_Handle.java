package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender_Handle {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
          WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Utility util=new Utility(driver);
		
		  driver.get("https://www.ixigo.com/");
		  
		  driver.findElement(By.xpath("//span[contains(text(),'Round Trip')]")).click();
		  
		  driver.findElement(By.xpath("//input[@placeholder='Depart']")).click();
		  
		  By startmonthlabel=By.xpath("//div[@class='rd-date']/div[@class='rd-month'][1]/div[@class='rd-month-label']");
		  
		  
		  
		  
		  String text=util.waitForElementPresent(startmonthlabel, 20).getText();
		  //System.out.println(text);
		  
		  while(!text.equals("September 2021"))
		  {
			  driver.findElement(By.xpath("//div[@class='rd-date']/div[@class='rd-month'][2]//button")).click();
			  
			  text=util.waitForElementPresent(startmonthlabel, 20).getText();
		  }
		  
		  List<WebElement>day=driver.findElements(By.xpath("//div[@class='rd-date']/div[@class='rd-month'][1]//div[contains(@class,'day')]"));
		  
		  
		 for(int i=0;i<day.size();i++)
		 {
			 if(day.get(i).getText().equalsIgnoreCase("15"))
			 {
				 day.get(i).click();
				 break;
			 }
		 }
		 
		
		 driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
		 By endmonthlabel=By.xpath("(//div[@class='rd-month-label'])[4]");
		  
		 String text1=util.waitForElementPresent(endmonthlabel, 20).getText();
		  System.out.println(text);
		  
		  By button=By.xpath("(//div[@class='rd-month'])[4]/button");
		  
		  while(!text.equals("November 2021"))
		  {
			  
			  util.waitForElementPresent(button, 20).click();
			  text=util.waitForElementPresent(endmonthlabel, 20).getText();
		  }
		  
		  List<WebElement>day1=driver.findElements(By.xpath("(//div[@class='rd-month'])[4]//div[contains(@class,'day')]"));
		  
		  
		 for(int i=0;i<day1.size();i++)
		 {
			 try
			 {
			 if(day1.get(i).getText().equalsIgnoreCase("19"))
			 {
				 day1.get(i).click();
				 break;
			 }
		 }
		 catch(StaleElementReferenceException e)
			 {
			 
			 }
		  
		  
	}

}
}
