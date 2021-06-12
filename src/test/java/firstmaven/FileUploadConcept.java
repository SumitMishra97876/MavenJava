package firstmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromiumdriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		driver.findElement(By.name("upfile")).sendKeys("D:\\DELL\\screenshotdepartDate.png");

	}

}
