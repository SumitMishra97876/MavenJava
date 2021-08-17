package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 
		
		
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		Utility util=new Utility(driver);
		
		List<WebElement> compList;
		
		driver.manage().window().maximize();
		
		driver.get("http://34.96.110.11/");
//		
//		WebElement signin=driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
//		signin.click();
//		
//		WebDriverWait w=new WebDriverWait(driver,40);
//		
//		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl01_TemplateBody_WebPartManager1_gwpciNewContactSignInCommon_ciNewContactSignInCommon_signInUserName']")));
//		
//		WebElement username=driver.findElement(By.xpath("//input[@id='ctl01_TemplateBody_WebPartManager1_gwpciNewContactSignInCommon_ciNewContactSignInCommon_signInUserName']"));
//		
//		WebElement password=driver.findElement(By.xpath("//input[@id='ctl01_TemplateBody_WebPartManager1_gwpciNewContactSignInCommon_ciNewContactSignInCommon_signInPassword']"));
//		
//		
//        WebElement login=driver.findElement(By.xpath("//input[@id='ctl01_TemplateBody_WebPartManager1_gwpciNewContactSignInCommon_ciNewContactSignInCommon_SubmitButton']"));
//		username.sendKeys("katyal2004-stafi@yahoo.com");
//		password.sendKeys("FDX2020!");
//		login.click();
//		
		
		
		
		//w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//li[@class='nav-item active']//label/input)[2]")));
//		
//		WebElement data_access_platform=driver.findElement(By.xpath("(//li[@class='nav-item active']//label/input)[2]"));
//		//WebElement data_access_platform=driver.findElement(By.xpath("(//span[contains(text(),' Data Access Platform ')])[2]//preceding-sibling::input"));
//		WebElement data_provider=driver.findElement(By.xpath("(//li[@class='nav-item active']//label/input)[3]"));
//		clickOptions(driver,data_access_platform);
//		//data_access.click();
//		clickOptions(driver,data_provider);
//		
//		WebElement australia=driver.findElement(By.xpath("(//li[@class='nav-item active']//label/input)[8]"));
//		clickOptions(driver,australia);
//		
//       
//		
//		
//		
//		WebElement canada=driver.findElement(By.xpath("(//li[@class='nav-item active']//label/input)[10]"));
//		clickOptions(driver,canada);
//		
//		
//		WebElement adCompany=driver.findElement(By.xpath("//button[normalize-space()='Add company']"));
//		adCompany.click();
//		
//		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='imisNumber']")));
//		WebElement imisPopup=driver.findElement(By.xpath("//input[@id='imisNumber']"));
//		
//		imisPopup.sendKeys("123456");
		
		By comps=By.xpath("//div[@class='company-item']");
		
		
		compList=util.getElements(comps);
		util.visibilityOfAllElements(compList, 20);
		
		
		int size=compList.size();
		System.out.println(size);
		
		for(int p=1;p<=8;p++)
		{
			
		
		for(int i=0;i<size;i++)
		{
			//String text=compList.get(i).getText();
			//System.out.println(text);
			
			js.executeScript("arguments[0].click()", compList.get(i));
			
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			By header=By.xpath("//h1[@class='banktitle']");
			util.waitForElementPresent(header, 10);
			
			System.out.println(driver.findElement(header).getText());
			
			//compList.get(i).click();
			driver.navigate().back();
			Thread.sleep(10000);
			//driver.navigate().to("http://34.96.110.11/");
			js.executeScript("window.scrollBy(0,2000)");
			Thread.sleep(5000);
			
			
			
			util.waitForElementPresent(comps, 20);
			compList=util.getElements(comps);
			util.visibilityOfAllElements(compList, 20);
			
		}
		String page=Integer.toString(p+1);
		WebElement pages=driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='"+page+"']"));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click()", pages);
		
		if(Integer.parseInt(page)==5)
		{
			for(int i=0;i<4;i++)
			{
			WebElement nextPage=driver.findElement(By.xpath("//a[@aria-label='Go to next page']"));
			js.executeScript("arguments[0].click()", nextPage);
			}
			//break;
			continue;
		}
		
		
		
		//continue;
		
		}
//		for(int p=5;p<=8;p++)
//		{
//			for(int i=0;i<size;i++)
//			{
//				//String text=compList.get(i).getText();
//				//System.out.println(text);
//				
//				js.executeScript("arguments[0].click()", compList.get(i));
//				
//				
//				//System.out.println(driver.getTitle());
//				By header=By.xpath("//h1[@class='banktitle']");
//				util.waitForElementPresent(header, 10);
//				
//				System.out.println(driver.findElement(header).getText());
//				
//				//compList.get(i).click();
//				driver.navigate().back();
//				//driver.navigate().to("http://34.96.110.11/");
//				js.executeScript("window.scrollBy(0,500)");
//				
//				
//				
//				util.waitForElementPresent(comps, 20);
//				compList=util.getElements(comps);
//				util.visibilityOfAllElements(compList, 20);
//				
//			}
//			String page=Integer.toString(p+1);
//			WebElement pages=driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='"+page+"']"));
//			js.executeScript("arguments[0].click()", pages);
//			
//		}
		
//		driver.findElement(By.xpath("//div[@class='company-item'][1]")).click();
//		
//		driver.navigate().to("https://www.google.com/");
//		driver.navigate().back();
//		//driver.navigate().back();
		
		
	}
	
	public static void clickOptions(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}

}
