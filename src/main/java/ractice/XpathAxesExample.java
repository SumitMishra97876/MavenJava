package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxesExample {

	public static void main(String[] args) {


		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://en.wikipedia.org/wiki/United_States");
		
		driver.findElement(By.xpath("(//a[@title='Flag of United States'])[2]//ancestor::tr//following-sibling::tr[2]/td//div/span/a")).click();
		

	}

}
