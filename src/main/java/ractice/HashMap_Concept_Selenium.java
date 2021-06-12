package ractice;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HashMap_Concept_Selenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
	
		doLogin(driver,getUserMap(),"cashier");
		
		
		

	}
	
	public static HashMap<String, String> getUserMap()
	{
HashMap<String,String> umap=new HashMap<String,String>();
		
		
		umap.put("admin", "admin@gmail.com_12345");
		umap.put("cashier", "ajay@gmail.com_12676");
		umap.put("nurse", "Monia@gmail.com_2!67@7876");
		umap.put("doctor", "Kelly@gmail.com_p@ggfd");
		return umap;
	}
	
	public static void doLogin(WebDriver driver,HashMap<String,String> umap,String user)
	{

		driver.findElement(By.id("email")).sendKeys(umap.get(user).split("_")[0]);
		
		
		driver.findElement(By.id("pass")).sendKeys(umap.get(user).split("_")[1]);
		
	}

}

