package ractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Email_Pass_Login_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		Utility util=new Utility(driver);
		
		By email=By.id("email");
		
		By passwd=By.id("pass");
		
		By logBtn=By.name("login");
		
		
		util.doSendKeys(email, "Sumit");
		util.doSendKeys(passwd, "12345");
		util.doClick(logBtn);

	}

}
