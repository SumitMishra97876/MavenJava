package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jquery_TextBox {

	public static void main(String[] args) {
     
		WebDriverManager.chromedriver().setup();
		 
		 
		
		WebDriver driver=new ChromeDriver();
		Utility util=new Utility(driver);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Groupable-Searchable-Dual-Listbox-Transfer/");
		
		By search=By.xpath("(//input[@class='transfer-double-list-search-input'])[1]");
		
       By checkBox=By.xpath("//div[contains(@class,'tab-content-active')]//li[@style='display: block;']//label[contains(text(),'jQuery')]//preceding-sibling::input");
			
		//By checkBox=By.xpath("((//div[@class='transfer-double-list-content'])[1]//label[contains(text(),'jQuery')]//preceding-sibling::input");
		
		util.getElement(search).sendKeys("jQuery");
		
		//util.clickWhenReady(checkBox, 10);
		//util.waitForElementPresent(checkBox, 10).click();
		util.clickElementByJS(checkBox);
		
	}

}
