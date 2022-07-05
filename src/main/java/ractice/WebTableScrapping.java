package ractice;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableScrapping {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.timeanddate.com/weather/?sort=1&low=c");
		
		String header1=driver.findElement(By.xpath("//div[@class='tb-scroll']/table//th/h3")).getText().trim();
		System.out.println(header1);
		String cities=driver.findElement(By.xpath("(//div[@class='tb-scroll']/table//th/div//label)[2]")).getText().trim();
		System.out.println(cities);
		String sortBy=driver.findElement(By.xpath("(//div[@class='tb-scroll']/table//th/div//label)[1]")).getText().trim();
		System.out.println(sortBy);
		List<WebElement> lists=driver.findElements(By.xpath("//div[@class='tb-scroll']/table//tr"));
		
		int rows=lists.size();
		
		XLUtils util=new XLUtils();
		
		String file="D:\\Sumit\\WeatherDetails.xlsx";
		XLUtils.setCellData(file, "Sheet1", 0, 0, header1);
		XLUtils.setCellData(file, "Sheet1", 0, 1, cities);
		XLUtils.setCellData(file, "Sheet1", 0, 2, sortBy);
		
		for(int r=1;r<=rows;r++)
		{
			String capitals=driver.findElement(By.xpath("//div[@class='tb-scroll']/table//tr["+r+"]/td[1]")).getText();
			String time=driver.findElement(By.xpath("//div[@class='tb-scroll']/table//tr["+r+"]/td[2]")).getText();
			
			String temperature=driver.findElement(By.xpath("//div[@class='tb-scroll']/table//tr["+r+"]/td[4]")).getText();
			
			
			XLUtils.setCellData(file, "Sheet1", r, 1, capitals);
			XLUtils.setCellData(file, "Sheet1", r, 2, time);
			XLUtils.setCellData(file, "Sheet1", r, 3, temperature);
		}
		
		

	}

}
