package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Deemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 WebDriverManager.chromedriver().setup();
			
			WebDriver driver=new ChromeDriver();
			Utility util=new Utility(driver);
	         driver.manage().window().maximize();
	         
	         driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=41&search=Samsung");
	         
	         driver.findElement(By.xpath("//button[@id='button-cart']")).click();
	         
	 By shopcart=By.xpath("//a[contains(text(),'shopping cart')]");
	 
	 
	 util.waitForElementPresent(shopcart, 10).click();
	 
	String text= driver.findElement(By.xpath("(//a[contains(text(),'iMac')])[2]//parent::td//following-sibling::td[2]//input")).getAttribute("value");
	 System.out.println(text);
	 
       text.trim();
       
       int n=Integer.parseInt(text);
       System.out.println(n);

	}

}
