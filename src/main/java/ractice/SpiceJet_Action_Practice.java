package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet_Action_Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
     WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
	   WebElement	login=driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"));
	   
	   WebElement SpiceClubMem=driver.findElement(By.xpath("//li[@class='hide-mobile']//a[text()='SpiceClub Members']"));
	   
	   WebElement memberlogin=driver.findElement(By.xpath("//li[@class='hide-mobile']//ul//li//a[text()='Member Login']"));
	   
//	   Actions a=new Actions(driver);
//	   
//	   a.moveToElement(login).moveToElement(SpiceClubMem).build().perform();
//	   Thread.sleep(2000);
//	   
//	   memberlogin.click();
//	   
	   
	   
	   memlog(driver,login,SpiceClubMem,memberlogin);
     
		
		
	
	}
	
	public static void memlog(WebDriver driver,WebElement e1,WebElement e2,WebElement e3) throws InterruptedException

	{
		 
		   
		   Actions a=new Actions(driver);
		   
		   a.moveToElement(e1).moveToElement(e2).build().perform();
		   Thread.sleep(2000);
		   
		   e3.click();
		   
	}
}
