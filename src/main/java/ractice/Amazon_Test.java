package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Test {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 
		 
			
		WebDriver driver=new ChromeDriver();
		Utility util=new Utility(driver);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		By all=By.xpath("//span[@class='hm-icon-label']");
		By echoAndAlexa=By.xpath("(//div[@id='hmenu-content']//ul)[1]/li[7]//a/div");
		
		By allALexaElements=By.xpath("//div[@id='hmenu-content']//ul[2]//li//a");
		
		util.getElement(all).click();
		
		util.getElement(echoAndAlexa).click();
		
		List<WebElement> list=util.getElements(allALexaElements);
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}

	}

}
