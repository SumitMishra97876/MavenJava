package ractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_Assignment2 {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.tripadvisor.in/");
		
	WebElement search=driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
	
	    search.clear();
		
		search.sendKeys("Club Mahindra");
		
//		WebDriverWait w=new WebDriverWait(driver,20);
//		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='typeahead_results']//a/div[1]/img)[1]")));
//		Thread.sleep(1000);
//		search.sendKeys(Keys.ARROW_DOWN);
//		search.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("(//div[@id='typeahead_results']//a/div[1]/img)[1]")).click();
		
		
		driver.findElement(By.linkText("Write a review")).click();
		
		//WebElement fiveRate=driver.findElement(By.xpath("//span[@id='bubble_rating']"));
		WebElement rate=driver.findElement(By.id("bubble_rating"));
		
		WebDriverWait w=new WebDriverWait(driver,20);
		
		//WebElement oneRate=driver.findElement(By.xpath("//span[@class='ui_bubble_rating fl bubble_10']"));
		//WebElement fiveRate=driver.findElement(By.cssSelector("span[class='ui_bubble_rating fl bubble_50']"));
		
		
		w.until(ExpectedConditions.visibilityOf(rate));
		
//		Select sel=new Select(fiveRate);
//		
//		sel.selectByValue("5");
//		Actions act=new Actions(driver);
////		
//      	act.moveToElement(oneRate).build().perform();
      	//act.moveToElement(fiveRate).build().perform();
      	//fiveRate.click();
//		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
//		//WebElement ele=driver.findElement(By.id("bubble_rating"));
//		
//		//js.executeScript("document.getElementsByClassName('ui_bubble_rating ')[0].setAttribute('data-value','5')");
       	//js.executeScript("arguments[0].setAttribute('class','ui_bubble_rating f1 bubble_50');",rate);
       //rate.click();
//     	//js.executeScript("arguments[0].click()", rate);
		Actions a=new Actions(driver);
//		
		a.moveToElement(rate, 50, 40).click().build().perform();
////		
//		
		WebElement e=driver.findElement(By.xpath("//em[@id='overallRatingFlagText']"));
		System.out.println(e.getText());
		
		
		driver.findElement(By.id("ReviewTitle")).sendKeys("Great Experience");
		
		driver.findElement(By.id("ReviewText")).sendKeys("Enjoyed a lot..Nice facilities...great place..nksnkhdkshlhksfhkhbvmbvxhksdhkhkgzzkvkzdv..vskhkdhkhdkdhkvhkhvkhkhksdgkhsdkhksghgkhsdkghkdshgkhkhgkshgkhkhcvknkshgkshgkshkghkshdkhdkghksghdskdhgkshgkhskghkfgk");
		
		driver.findElement(By.xpath("//div[@id='trip_type_table']//div[2]")).click();
		
		
		
		WebElement date=driver.findElement(By.id("trip_date_month_year"));
		
		
		Select sel=new Select(date);
		sel.selectByVisibleText("May 2021");
		
		
		WebElement service=driver.findElement(By.id("qid12_bubbles"));
		
		a.moveToElement(service,-20,0).click().build().perform();
		
		
		WebElement rooms=driver.findElement(By.id("qid11_bubbles"));
		
		a.moveToElement(rooms, 30, 0).click().build().perform();
		
		
		WebElement sleep_quality=driver.findElement(By.id("qid190_bubbles"));
		a.moveToElement(sleep_quality, -40, 0).click().build().perform();
//		
		
		driver.findElement(By.id("noFraud")).click();
		
//		driver.findElement(By.xpath("//div[@id='SUBMIT']/span")).click();
		
		
	}

}
