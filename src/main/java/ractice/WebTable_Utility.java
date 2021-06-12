package ractice;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_Utility {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/downloads/");
		
           JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,1100)");
		
		By rows=By.xpath("//table[@class='data-list']/tbody/tr");
		
		int rowcount=getRows(driver,rows);
		
		System.out.println(rowcount);
		
		
		////table[@class='data-list']/tbody/tr[3]/td[1]
		
		
		
		
//		getColdata(driver,1);
//		System.out.print("\t");
//		
//		getColdata(driver,2);
//		System.out.print("\t");
//		
//		getColdata(driver,3);
//		System.out.print("\t");
//		
//		getColdata(driver,4);
//		System.out.print("\t");
//		
//		getColdata(driver,5);
//		System.out.print("\t");
//		getColdata(driver,6);
//		System.out.println("\t");
//		
//		
//		getSpecificLangdata(driver,"Ruby",3);
//		getSpecificLangdata(driver,"Ruby",2);
//		
		getLangData(driver,rowcount,"C#");
		driver.quit();
		
	}
        public static int getRows(WebDriver driver,By locator)
        {
        	int rowcount=driver.findElements(locator).size();
        	return rowcount;
        }
        
        public static void getColdata(WebDriver driver,int colnum)
        {
        	By locator=By.xpath("//table[@class='data-list']/tbody/tr");
        	for(int r=1;r<=getRows(driver,locator);r++)
        	{
        		String colText=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td["+colnum+"]")).getText();
        		
        		System.out.print(colText);
        	}
        }
        
        public static void getSpecificLangdata(WebDriver driver,String langName,int colnum)
        {
        	String data=driver.findElement(By.xpath("//td[text()='"+langName+"']/following-sibling::td["+colnum+"]")).getText();
        	System.out.println(data);
        }
        
        public static void getLangData(WebDriver driver,int rows,String language)
        {
        	for(int r=1;r<=rows;r++)
  		  {
                  String lang=driver.findElement(By.xpath("//table[@class='data-list'] //tr["+r+"]/td[1]")).getText();
                  
                  if(lang.equals(language))
                  {
                  	 String version=driver.findElement(By.xpath("//table[@class='data-list'] //tr["+r+"]/td[2]")).getText();
                  	 
                  	 String release=driver.findElement(By.xpath("//table[@class='data-list'] //tr["+r+"]/td[3]")).getText();
                  	 
                  	 String betaVersion=driver.findElement(By.xpath("//table[@class='data-list'] //tr["+r+"]/td[4]")).getText();
                  	String betaReleaseDate=driver.findElement(By.xpath("//table[@class='data-list'] //tr["+r+"]/td[5]")).getText();
                  	String links=driver.findElement(By.xpath("//table[@class='data-list'] //tr["+r+"]/td[6]")).getText();
                  	 
                  	 System.out.println("Language is " +lang + ",version is " +version + " ,release date is :" +release + " ,beta vesrion is :" +betaVersion + " ,beta release date is :" +betaReleaseDate + " ,link is :" +links);
                  }
  		  }
        }
}

