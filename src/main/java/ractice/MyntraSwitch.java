package ractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraSwitch {

	public static void main(String[] args) {


		
WebDriverManager.chromedriver().setup();
       List<WebElement>links;
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		
		 links=driver.findElements(By.xpath("//div[@class='desktop-navLink']/a"));
		
		int len=links.size();
		
		for(int i=0;i<len;i++)
		{
			links.get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
			
		}
		ArrayList<String> ar=new ArrayList<>(driver.getWindowHandles());
		
		String parent=ar.get(0);
		
		for(int i=1;i<ar.size();i++)
		{
			driver.switchTo().window(ar.get(i));
			System.out.println(driver.getTitle());
			//driver.switchTo().window(parent);
			//System.out.println(driver.getTitle());
		}
		
		

	}

}
