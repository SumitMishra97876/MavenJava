package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 WebDriverManager.chromedriver().setup();
			
			WebDriver driver=new ChromeDriver();
	         driver.manage().window().maximize();
			
			driver.get("https://www.facebook.com/");
			
			WebElement email=driver.findElement(By.id("email"));
			
			WebElement password=driver.findElement(By.id("pass"));
			
			WebElement login=driver.findElement(By.name("login"));
			
			Utility util=new Utility(driver);
			util.doActionsSendKeys(By.id("email"), "Sumit");
			util.doActionsSendKeys(By.id("pass"), "123456");
			util.doActionsClick(By.name("login"));

	}

}
