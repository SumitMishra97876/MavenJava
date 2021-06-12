package firstmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import ractice.Utility;

public class FB_Demo {

	public static void main(String[] args) {
     WebDriverManager.chromedriver().setup();
     
       ChromeOptions options=new ChromeOptions();
       
       options.addArguments("--disable-notifications");
       
       
       
		
		WebDriver driver=new ChromeDriver(options);
		Utility util=new Utility(driver);
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("snehittiwary0@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("digitalclock");
		
		driver.findElement(By.name("login")).click();
		WebDriverWait w=new WebDriverWait(driver,20);
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'on your mind')]")));
		
		
		driver.findElement(By.xpath("//span[contains(text(),'on your mind')]")).click();
		WebDriverWait w1=new WebDriverWait(driver,20);
		w1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='_1mf _1mj']")));
		
		driver.findElement(By.xpath("//div[@data-contents='true']//span")).sendKeys("Hello");
//		By hello=By.cssSelector("div[class='_1mf _1mj']");
//		
//		util.doActionsSendKeys(hello, "Hello");
	}

}
