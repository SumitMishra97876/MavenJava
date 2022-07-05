package ractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadHandle {

	public static void main(String[] args) throws AWTException, IOException {
		WebDriverManager.chromedriver().setup();

		// options=new ChromeOptions();
		// options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		
		    driver.get("http://www.freepdfconvert.com/pdf-word");
		    driver.findElement(By.xpath("//*[contains(text(),'Choose PDF')]")).click();
		    
//		    WebDriverWait wait = new WebDriverWait(driver, 10);
//		    wait.until(ExpectedConditions.alertIsPresent());
//
//		    // switch to the file upload window
//		    Alert alert = driver.switchTo().alert();
//		    
//		    alert.sendKeys("D:\\Sumit\\telecom.pdf");
//		    
//		    Robot r = new Robot();
//		    r.keyPress(KeyEvent.VK_ENTER);
//		    r.keyRelease(KeyEvent.VK_ENTER);

//		    driver.switchTo()
//		            .activeElement()
//		            .sendKeys(
//		                    "/D/Sumit/ss1358_telecom basics level1.pdf");
		    
		    Runtime.getRuntime().exec("E:\\AutoIT\\FileUpload.exe");
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		   // driver.findElement(By.id("convertButton"));
	}

}
