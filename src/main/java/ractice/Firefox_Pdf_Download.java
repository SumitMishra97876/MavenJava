package ractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Firefox_Pdf_Download {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
        String location=System.getProperty("user.dir")+"\\downloads";
        
        FirefoxProfile profile=new FirefoxProfile();
        profile.setPreference("pdfjs.disabled",true);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", location);
        
        
        FirefoxOptions options=new FirefoxOptions();
        options.setProfile(profile);
        
        WebDriver driver=new FirefoxDriver(options);
        
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		
          JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,1100)");
		driver.findElement(By.xpath("(//td[@class='text-right file-link'])[1]")).click();
		
        
        

	}

}
