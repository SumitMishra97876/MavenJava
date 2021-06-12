package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Total_Text_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		//using tagname
	/*	List<WebElement> links=driver.findElements(By.tagName("input"));
		
		int n=links.size();
		System.out.println(n);*/
		
		
		//Using xpath
		/*List<WebElement> links=driver.findElements(By.xpath("//input[@type='text']"));
		
		int n=links.size();
		System.out.println(n);
		
		for(int i=0;i<n;i++)
		{
			links.get(i).sendKeys("Sumit");
		}*/
		driver.findElement(By.id("login1")).sendKeys("Sumit");
		
		String val=driver.findElement(By.id("login1")).getAttribute("value");
		System.out.println(val);
		
		
		
		

	}

}
