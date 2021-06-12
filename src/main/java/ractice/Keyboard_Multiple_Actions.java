package ractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyboard_Multiple_Actions {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://text-compare.com/");
		
		WebElement input1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement input2=driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		
		input1.sendKeys("My Name is Sumit");
		
		
		Actions act=new Actions(driver);
		
		act.keyDown(Keys.CONTROL).build().perform();
		act.sendKeys("A").build().perform();
		
		act.keyUp(Keys.CONTROL);
		act.keyDown(Keys.CONTROL).build().perform();
		act.sendKeys("C").build().perform();
		act.keyUp(Keys.CONTROL);
		
		
		act.sendKeys(Keys.TAB);
		
		act.keyDown(Keys.CONTROL).build().perform();
		act.sendKeys("V").build().perform();

	}

}
