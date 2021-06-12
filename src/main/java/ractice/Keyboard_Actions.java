package ractice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyboard_Actions {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://the-internet.herokuapp.com/key_presses");
		
		Actions act=new Actions(driver);
		
		act.sendKeys(Keys.SPACE).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(Keys.SHIFT).build().perform();
		
		
		
	}

}
