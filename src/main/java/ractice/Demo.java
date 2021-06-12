package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		 WebDriverManager.chromedriver().setup();
			
			WebDriver driver=new ChromeDriver();
			Utility util=new Utility(driver);
	         driver.manage().window().maximize();
	         By addtoCart=By.id("button-cart");
	         By mess=By.xpath("//div[@class='alert alert-success alert-dismissible']");
			
			driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=41&search=imac");
			
			
			util.doClick(addtoCart);
			
			String messg=util.waitForElementPresent(mess, 10).getText();
			
			System.out.println(messg);
			
			

	}

}
