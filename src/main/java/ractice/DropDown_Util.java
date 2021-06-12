package ractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown_Util {
	
	
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
	
//	public static void dropDownListvalues(WebElement element)
//	{
//		Select droplist=new Select(element);
//		List<WebElement>dropvalues=droplist.getOptions();
//		
//		int n=dropvalues.size();
//		
//		System.out.println("No of values: " +n);
//			
//		for(int i=0;i<n;i++)
//		{
//			String dropvaltext=dropvalues.get(i).getText();
//			System.out.println(dropvaltext);
//		}
//			
//		
//		
//	}
//	
	//Returning arraylist insted of printing values on console
	
	public static ArrayList<String> dropDownListvalues(WebElement element)
	{
		Select droplist=new Select(element);
		List<WebElement>dropvalues=droplist.getOptions();
		
		int n=dropvalues.size();
		
		System.out.println("No of values: " +n);
		ArrayList<String> ar=new ArrayList<String>();	
		for(int i=0;i<n;i++)
		{
			String dropvaltext=dropvalues.get(i).getText();
			ar.add(dropvaltext);
		}
			
		return ar;
		
	}
	
	//Dropdown utility without select
	
	public static void dropDownWithoutSelect(WebDriver driver,String locator,String value)
	{
		List<WebElement> dropval=driver.findElements(By.xpath(locator));
		
		for(int i=0;i<dropval.size();i++)
		{
			if(dropval.get(i).getText().equalsIgnoreCase(value))
			{
				dropval.get(i).click();
				break;
			}
		}
	}


}
