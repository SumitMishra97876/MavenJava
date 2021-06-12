package ractice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenExcel {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		
		
		WebElement initialDeposit=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		WebElement length=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		WebElement interestRate=driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		WebElement compoundDropDown=driver.findElement(By.xpath("//div[@id='mat-select-value-1']"));
		
		
		WebElement button=driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));
		
		
		WebElement actValue=driver.findElement(By.xpath("//span[@id='displayTotalValue']"));
		
		String path="D:\\Sumit\\calData.xlsx";
		
		int rows=XLUtils.getRowCount(path, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			String inDeposit=XLUtils.getCellData(path, "Sheet1",i, 0);
			
			String initRate=XLUtils.getCellData(path, "Sheet1", i, 1);
			
			String initLength=XLUtils.getCellData(path, "Sheet1", i, 2);
			
			String compounding=XLUtils.getCellData(path, "Sheet1", i, 3);
			
			String expValue=XLUtils.getCellData(path, "Sheet1", i, 4);
			
			
			initialDeposit.clear();
			length.clear();
			interestRate.clear();
			
			initialDeposit.sendKeys(inDeposit);
			length.sendKeys(initLength);
			interestRate.sendKeys(initRate);
			
			
			
			compoundDropDown.click();
			
			List<WebElement> dropdownVals=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			
			for(WebElement option:dropdownVals)
			{
				if(option.getText().equalsIgnoreCase(compounding))
				{
					option.click();
					break;
				}
			}
			
			
			button.click();
			
			String actTotal=actValue.getText();
			
			if(expValue.equals(actTotal))
			{
				XLUtils.setCellData(path, "Sheet1", i, 6, "Passed");
				XLUtils.fillGreenColor(path, "Sheet1", i, 6);
			}
			else
			{
				XLUtils.setCellData(path, "Sheet1", i, 6, "Failed");
				XLUtils.fillRedColor(path, "Sheet1", i, 6);
			}
			
			
			
		}
		
		System.out.println("calculation has been completed");
		driver.close();
		
		
		
		
		
		
		
	}

}
