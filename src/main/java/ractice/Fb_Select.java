package ractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fb_Select {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com");
		
		
		driver.findElement(By.xpath("//a[@role='button' and @data-testid='open-registration-form-button']")).click();
		
//     	WebElement day=driver.findElement(By.xpath("//form[@id='reg']//select[@id='day']"));
//		
//		Select sel=new Select(day);
//		
//		sel.selectByVisibleText("18");
		
		
		String dob="7-Dec-1991";
        
		
		String dayOptionsXpath = "//select[@id='day']/option";
		String monthOptionsXpath = "//select[@id='month']/option";
		String yearOptionsXpath = "//select[@id='year']/option";

		String dayOptionsCSS = "select#day option";
		String monthOptionsCSS = "select#month option";
		String yearOptionsCSS = "select#year option";
		
		
		
//		doSelectValueFromDropDownWithOutSelect(driver,"xpath",dayOptionsXpath,dob.split("-")[0]);
//		doSelectValueFromDropDownWithOutSelect(driver,"xpath",monthOptionsXpath,dob.split("-")[1]);
//		doSelectValueFromDropDownWithOutSelect(driver,"xpath",yearOptionsXpath,dob.split("-")[2]);
		
		
		doSelectValueFromDropDownWithOutSelect(driver,"css",dayOptionsCSS,dob.split("-")[0]);
		doSelectValueFromDropDownWithOutSelect(driver,"css",monthOptionsCSS,dob.split("-")[1]);
		doSelectValueFromDropDownWithOutSelect(driver,"css",yearOptionsCSS,dob.split("-")[2]);
		

   }
	
	
	public static void doSelectValueFromDropDownWithOutSelect(WebDriver driver,String locator,String locValue,String value)
	{
		List<WebElement> valList=null;
		
		if(locator.equals("xpath"))
		{
			valList=driver.findElements(By.xpath(locValue));
		}
		else if(locator.equals("css"))
		{
			valList=driver.findElements(By.cssSelector(locValue));
		}
		
		System.out.println(valList.size());
		
		for(int i=0;i<valList.size();i++)
		{
			if(valList.get(i).getText().equals(value))
			{
				valList.get(i).click();
				break;
			}
		}
	}
	
	

}
