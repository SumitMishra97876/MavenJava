package ractice;



import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalPgeLinksWithoutBlankTexts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		By links=By.tagName("a");
		
		List<WebElement> linkslist=driver.findElements(links);
		
	//List<String>collectlist=	linkslist.stream().filter(ele->!ele.getText().equals("") && ele.getText().contains("Amazon")).map(ele->ele.getText()).collect(Collectors.toList());
	
	//collectlist.stream().forEach(ele->System.out.println(ele));
	
	//parallel stream
		
		List<String>collectlist=linkslist.stream().filter(ele->!ele.getText().isEmpty()).filter(ele->!ele.getText().startsWith(" ")).map(ele->ele.getText().trim()).collect(Collectors.toList());
		collectlist.stream().forEach(ele->System.out.println(ele));
	
	//collectlist.parallelStream().forEach(ele->System.out.println(ele));

	}

}
