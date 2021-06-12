package firstmaven;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromiumdriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		System.out.println(driver.getTitle());
		
		WebElement el=driver.findElement(By.name("proceed"));
		
		el.click();
		
		Alert alert=driver.switchTo().alert();
		
		String text=alert.getText();
		
		
		if(text.equals("Please enter a valid user name"))
		{
			System.out.println("Correct error message");
		}
		else
		{
		System.out.println("Alert message incorrect");
		}
		alert.accept();
		

	}

}
