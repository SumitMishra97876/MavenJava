package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllOptions_Utility {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		  driver.get("https://www.salesforce.com/eu/form/signup/freetrial-sales-pe/");
		  
		  
		  By country=By.id("CompanyCountry-04rQ");
		  
		List<String> lists=  Select_Dropdown_Generic_Utility.getAllOptions(driver, country);

		for(int i=0;i<lists.size();i++)
		{
			System.out.println(lists.get(i));
		}

	}

}
