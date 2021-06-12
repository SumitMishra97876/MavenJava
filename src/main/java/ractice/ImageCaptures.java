package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageCaptures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		List<WebElement> links=driver.findElements(By.tagName("img"));
		
	
		
		int n=links.size();
		System.out.println(n);
		for(int i=0;i<n;i++)
		{
			System.out.println(links.get(i).getAttribute("src"));
		}

	}

}
