package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Collectors;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalPageLinks {

	public static void main(String[] args) {
		List<WebElement> links;
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		links=driver.findElements(By.tagName("a"));
		
		int n=links.size();
		System.out.println(n);
		
		for(int i=0;i<n;i++)
		{
//			String text=links.get(i).getText();
//			
//			if(!text.isEmpty())
//				
//			{
//				System.out.print(text);
//			}
			
			links.get(i).click();
			
			
			links=driver.findElements(By.tagName("a"));
		}
		
		
		}
		

	}

