package ractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Select_Dropdown_Generic_Utility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  WebDriverManager.chromedriver().setup();
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
			
			By industry=By.id("Form_submitForm_Industry");
			
			By country=By.id("Form_submitForm_Country");
			
			
			
//			selectChoiceByText(driver,country,"India");
//			selectChoiceByText(driver,industry,"Other");
			
//			selectChoiceByIndex(driver,country,8);
//			
//			selectChoiceByIndex(driver,industry,10);
			
			
			selectDropDownValueByType(driver,country,"visible","United States");
			
}
	
	
	//One method to select by value,text or index
	
	public static void  selectDropDownValueByType(WebDriver driver,By locator,String type,String value)
	{
		Utility util=new Utility(driver);
		WebElement element=util.getElement(locator);
		
		Select select=new Select(element);
		
		switch(type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Wrong Choicce");
			break;
			
			
		}
		
	}
	
	public static void selectChoiceByText(WebDriver driver,By locator,String value)
	{
		
		Utility util=new Utility(driver);
		WebElement element=util.getElement(locator);
		Select select=new Select(element);
		
		select.selectByVisibleText(value);
		
		
	}
	
	public static void selectChoiceByIndex(WebDriver driver,By locator,int index)
	{
		
		Utility util=new Utility(driver);
		WebElement element=util.getElement(locator);
		Select select=new Select(element);
		
		select.selectByIndex(index);
		
		
	}
	public static void selectChoiceByValue(WebDriver driver,By locator,String text)
	{
		
		Utility util=new Utility(driver);
		WebElement element=util.getElement(locator);
		Select select=new Select(element);
		
		select.selectByValue(text);
		
		
	}
	
	public static ArrayList<String> getAllOptions(WebDriver driver,By locator)
	{
		ArrayList<String> list=new ArrayList<String>();
		Utility util=new Utility(driver);
		WebElement element=util.getElement(locator);
		Select select=new Select(element);
		
		List<WebElement>options=select.getOptions();
		for(int i=0;i<options.size();i++)
		{
			
			String text=options.get(i).getText();
			
			list.add(text);
			
			
		}
		return list;
		
	}
}
