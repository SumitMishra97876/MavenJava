package ractice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		
		WebElement principalAmount=driver.findElement(By.id("principal"));
		
		WebElement rateOfInterest=driver.findElement(By.id("interest"));
		
		WebElement period=driver.findElement(By.id("tenure"));
		
		WebElement periodDropDown=driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
		
		WebElement frequency=driver.findElement(By.xpath("//select[@id='frequency']"));
		
		//WebElement calButton=driver.findElement(By.xpath("//div[@class='PT25']//a[1]//img[1]"));
		WebElement calButton=driver.findElement(By.xpath("(//div[@class='CTR PT15']//a//img)[1]"));
		
		//WebElement clear=driver.findElement(By.xpath("//img[@class='PL5']"));
		WebElement clear=driver.findElement(By.xpath("//div[@class='CTR PT15']//a[2]//img"));
		
		WebElement actVal;
		
		String path="D:\\Sumit\\InterestRateCal.xlsx";
		
		
		int rows=XLUtils.getRowCount(path, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			String principal=XLUtils.getCellData(path, "Sheet1", i, 0);
			
			String rate=XLUtils.getCellData(path, "Sheet1", i, 1);
			
			String period1=XLUtils.getCellData(path, "Sheet1", i, 2);
			
			String period2=XLUtils.getCellData(path, "Sheet1", i, 3);
			
			String freq=XLUtils.getCellData(path, "Sheet1", i, 4);
			
			String expVal=XLUtils.getCellData(path, "Sheet1", i, 5);
			
			
			principalAmount.sendKeys(principal);
			rateOfInterest.sendKeys(rate);
			period.sendKeys(period1);
			
			Select selPeriod1=new Select(periodDropDown);
			
			selPeriod1.selectByVisibleText(period2);
			
			Select selPeriod2=new Select(frequency);
			selPeriod2.selectByVisibleText(freq);
			
			calButton.click();
			
			actVal=driver.findElement(By.xpath("//span[@id='resp_matval']//strong"));
			
			String actTotalVal=actVal.getText();
			
			if(Double.parseDouble(expVal)==Double.parseDouble(actTotalVal))
			//if(expVal.equals(actTotalVal))
			{
				XLUtils.setCellData(path, "Sheet1", i, 7, "Passed");
				XLUtils.fillGreenColor(path, "Sheet1", i, 7);
			}
			else
			{
				XLUtils.setCellData(path, "Sheet1", i, 7, "Failed");
				XLUtils.fillRedColor(path, "Sheet1", i, 7);
				
			}
			Thread.sleep(3000);
			
			clear.click();
			
			
			
	    }
		
		driver.close();
		
		
		
		
		

	}

}
