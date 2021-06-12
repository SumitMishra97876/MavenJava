package ractice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://classic.freecrm.com/index.html");

		By email = By.name("username");
		By password = By.name("password");
		fluenWaitWithDifferentSyntax(driver,email).sendKeys("Sumit");
		
		

	}
	
	
	//another way of fluent wait
	public static WebElement fluenWaitWithDifferentSyntax(WebDriver driver,By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

	   WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	   return element;

	}

     //important for interview point of view
	public static WebElement fluenWait(WebDriver driver,By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

	WebElement element=	wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(locator);
			}

		});
	return element;

	}

}
