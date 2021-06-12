package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_Handle_Naveen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
      WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		
		int rowcount=driver.findElements(By.xpath("//table[@id='customers']/tbody//tr")).size()-1;
		
		System.out.println(rowcount);
		
		

         for(int r=2;r<=rowcount+1;r++)
         {
        	String custname= driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+r+"]/td[1]")).getText();
        	
        	System.out.println(custname);
         }

	}

}
