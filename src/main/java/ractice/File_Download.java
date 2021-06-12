package ractice;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_Download {

	public static void main(String[] args) {
         WebDriverManager.chromedriver().setup();
         String location=System.getProperty("user.dir")+"\\downloads";

         HashMap preferences=new HashMap();
         
          preferences.put("download.default_directory", location);
          
          ChromeOptions options =new ChromeOptions();
          
          options.setExperimentalOption("prefs", preferences);
          
          
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		
		
		driver.findElement(By.xpath("(//td[@class='text-right file-link'])[2]")).click();
		
		

	}

}
