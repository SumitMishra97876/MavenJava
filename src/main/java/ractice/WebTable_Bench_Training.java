package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_Bench_Training {
	
	WebDriver driver;
	int rows;
	int cols;
	
	public WebTable_Bench_Training()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
	}
	
	public void loadUrl()
	{
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		
	}
	
	public void countRowCols()
	{
		cols=driver.findElements(By.xpath("//table[@class='dataTable']//thead//th")).size();
		rows=driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr")).size();
	}
	
	public void getDetails()
	{
		boolean flag=false;
		
		for(int i=1;i<rows;i++)
		{
			for(int j=1;j<cols;j++)
			{
				WebElement temp=driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+i+"]/td[1]"));
				if(temp.getText().equals("Jet Airways"))
				{
					flag=true;
					System.out.println(driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+i+"]/td["+j+"]")).getText());
				}
			}
		}
		if(flag==false)
		{
			driver.navigate().refresh();
			getDetails();
		}
	}
	
	

}
