package firstmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import ractice.Utility;

public class Window_Handle {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options =new ChromeOptions();	
	
		
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		Utility util=new Utility(driver);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/");
		
		Actions act=new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Selenium Practice']"))).build().perform();
		
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Window Handles']"))).click().build().perform();
		
		
		driver.switchTo().frame("aswift_7");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Advertisement']")));
		
		Actions act1=new Actions(driver);
		
		act1.moveToElement(driver.findElement(By.xpath("//div[@id=dismiss-button]/div/span"))).click().build().perform();
		
	}

}
