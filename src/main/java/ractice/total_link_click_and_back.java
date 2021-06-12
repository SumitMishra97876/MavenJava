package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class total_link_click_and_back {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));

		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++) {

			System.out.println(links.get(i).getText());

			links.get(i).click();

			//driver.navigate().back();

			links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		}

	}

//		WebElement login =driver.findElement(By.id("username"));
//		login.sendKeys("Sumit");
//		
//		driver.navigate().refresh();
//		
//		 login =driver.findElement(By.id("username"));
//		login.sendKeys("Sumit");

}
