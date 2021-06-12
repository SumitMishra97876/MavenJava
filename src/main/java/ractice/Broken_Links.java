package ractice;


import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Broken_Links {

	public static void main(String[] args) throws MalformedURLException   {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		
	    List<WebElement> links=driver.findElements(By.tagName("a"));
	    
	    int size=links.size();
	    int brokenLink=0;
	    
	    for(int i=0;i<size;i++)
	    {
	    	String url=links.get(i).getAttribute("href");
	    	
	    	if(url==null || url.isEmpty())
	    	{
	    		System.out.println("Empty URL");
	    	}
	    	
	    	URL urls=new URL(url);
	    	 
			try {
				HttpURLConnection conn = (HttpURLConnection)urls.openConnection();
				conn.connect();
				
				
			  
			   
			   if(conn.getResponseCode()>=400)
			   {
				   System.out.println(conn.getResponseCode()+"   "+"is broken link");
				   
				   brokenLink++;
			   }
			   else
			   {
				   System.out.println(conn.getResponseCode()+"   "+"is valid link");
			   }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    }
	    System.out.println("Total Broken Links" +brokenLink);
	    		

	}

}
