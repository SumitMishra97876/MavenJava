package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class listWithStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		
		By industry_options=By.xpath("//select[@id='Form_submitForm_Industry']/option");
		
		List<WebElement> indlist=driver.findElements(industry_options);
		
		//sequential stream ,lambda
		
		//indlist.stream().forEach(e->System.out.println(e.getText()));
		
		//parallel stream
		
		indlist.parallelStream().forEach(e->System.out.println(e.getText()));  //order not preserved

	}

}
