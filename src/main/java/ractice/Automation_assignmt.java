package ractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_assignmt {

	public static void main(String[] args) {
		
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.tripadvisor.in/");
		
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.linkText("Continue with email")).click();
	}

}
