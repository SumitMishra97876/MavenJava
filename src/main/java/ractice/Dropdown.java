package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/reg/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjE4MDUwMzQ1LCJjYWxsc2l0ZV9pZCI6MzYzOTY5MDQ0ODc4OTI4fQ%3D%3D");
        
		
		WebElement daydrop=driver.findElement(By.xpath("//select[@id='day']"));
		WebElement monthdrop=driver.findElement(By.xpath("//select[@id='month']"));
		WebElement yeardrop=driver.findElement(By.xpath("//select[@id='year']"));
		
		
		
//		day.selectByValue("15");
//		
//		Select month=new Select(monthdrop);
//		month.selectByVisibleText("May");
//		
//		Select year=new Select(yeardrop);
//		year.selectByValue("1999");
//		
		
//		dropdown(daydrop,"15");
//		dropdown(monthdrop,"May");
//		dropdown(yeardrop,"1999");
		
		
//		dropdownIndex(daydrop,9);
//		dropdownIndex(monthdrop,12);
//		dropdownIndex(yeardrop,15);
		
		
		dropDownListvalues(daydrop);
		dropDownListvalues(monthdrop);
		dropDownListvalues(yeardrop);
		
	}
	
	//Generic method
	
	public static void  dropdown(WebElement element,String value)
	{
		Select select=new Select(element);
		
		select.selectByVisibleText(value);
	}
	
	public static void  dropdownIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		
		select.selectByIndex(index);
	}
	
	//generic method to get all the values from the respective dropdowns
	
	public static void dropDownListvalues(WebElement element)
	{
		Select droplist=new Select(element);
		List<WebElement>dropvalues=droplist.getOptions();
		
		int n=dropvalues.size();
		
		System.out.println("No of values: " +n);
			
		for(int i=0;i<n;i++)
		{
			String dropvaltext=dropvalues.get(i).getText();
			System.out.println(dropvaltext);
		}
			
		
		
	}


}
