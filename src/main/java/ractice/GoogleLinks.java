package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLinks {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		List<WebElement>lks=driver.findElements(By.tagName("a"));
		
		for(int i=0;i<lks.size();i++)
		{
			String text=lks.get(i).getText();
			System.out.println(text);
			if(i==10)
			{
				lks.get(i).click();
				break;
			}
		}
		

	}

}
