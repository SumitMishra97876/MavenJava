package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_Cricinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		 WebDriverManager.chromedriver().setup();
			
			WebDriver driver=new ChromeDriver();
	         driver.manage().window().maximize();
			
			driver.get("https://www.espncricinfo.com/series/ipl-2021-1249214/sunrisers-hyderabad-vs-kolkata-knight-riders-3rd-match-1254060/full-scorecard");
			
			
			List<WebElement> list=driver.findElements(By.xpath("//a[contains(text(),'Andre Russell')]//ancestor::table[@class='table batsman']//tr[7]//following-sibling::td[2]"));
			
			int size=list.size();
			
			for(int i=0;i<size;i++)
			{
				String text=list.get(i).getText();
				System.out.println(text);
			}

	}

}
