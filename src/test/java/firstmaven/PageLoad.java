package firstmaven;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import ractice.Utility;

public class PageLoad {

	public static void main(String[] args) {
	
		
		
		
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions  options=new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		
		WebDriver driver=new ChromeDriver(options);
		Utility util=new Utility(driver);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.reddit.com/");
		
		util.waitForPageLoad();
		
		
		
		WebElement m= driver.findElement(By.xpath("//*[local-name()='svg' and @class='_1bWuGs_1sq4Pqy099x_yy-']/*[local-name()='g']/*[local-name()='path']"));
		
//		Actions act = new Actions(driver);
//	      act.moveToElement(m).click().build().perform();
		if(m.isDisplayed())
		
		System.out.println("Displayed");
		else
			System.out.println("Not Displayed");
		
		
		

	}

}
