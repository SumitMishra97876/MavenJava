package firstmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_Handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		
		//WebElement frame=driver.findElement(By.xpath("//frame[@name='main']"));
		
	//	driver.switchTo().frame("main"); //by name
		
		
		driver.switchTo().frame(2);  //by index
		
		
   String text=driver.findElement(By.xpath("//body/h2[1]")).getText();
   System.out.println(text);
   
   driver.switchTo().defaultContent();
   
   WebElement navframe=driver.findElement(By.xpath("//frame[@name='navbar']"));
   
   driver.switchTo().frame(navframe);
   
  
   
   String text2=driver.findElement(By.xpath("//a[text()='Home']")).getText();
   System.out.println(text2);
   
   driver.switchTo().defaultContent();
   
   System.out.println(driver.findElements(By.tagName("frame")).size());

	}

}
