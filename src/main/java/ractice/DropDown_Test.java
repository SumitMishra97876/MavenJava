package ractice;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/reg/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjE4MDUwMzQ1LCJjYWxsc2l0ZV9pZCI6MzYzOTY5MDQ0ODc4OTI4fQ%3D%3D");
        
		
//		WebElement daydrop=driver.findElement(By.xpath("//select[@id='day']"));
//		WebElement monthdrop=driver.findElement(By.xpath("//select[@id='month']"));
//		WebElement yeardrop=driver.findElement(By.xpath("//select[@id='year']"));
//		String date="20-Dec-1998";
//		
//		String[] dateval=date.split("-");
//		
//		DropDown_Util.dropdown(daydrop, dateval[0]);
//		DropDown_Util.dropdown(monthdrop, dateval[1]);
//		DropDown_Util.dropdown(yeardrop, dateval[2]);
//		
//		
//		
//		
//		ArrayList<String> days=DropDown_Util.dropDownListvalues(yeardrop);
//		int n=days.size();
//		for(int i=0;i<n;i++)
//		{
//			System.out.println(days.get(i));
//		}
		
		
		String dayloc="//select[@id='day']/option";
		String dayval="18";
		
		String monthloc="//select[@id='month']/option";
		String monval="Nov";
		
		String yearloc="//select[@id='year']/option";
		String yearval="1997";
//		
		
		DropDown_Util.dropDownWithoutSelect(driver,dayloc,dayval);
		
		DropDown_Util.dropDownWithoutSelect(driver,monthloc,monval);
		DropDown_Util.dropDownWithoutSelect(driver,yearloc,yearval);
		

	}

}
