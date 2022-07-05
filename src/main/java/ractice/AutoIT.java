package ractice;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		

		

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
					
					driver.manage().window().maximize();
					String URL ="http://the-internet.herokuapp.com/basic_auth";
					//Runtime.getRuntime().exec("C:\\Users\\DELL\\OneDrive\\Desktop\\authenticate.exe");
					driver.get(URL);
				
					driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
					Thread.sleep(2000);
					Runtime.getRuntime().exec("C:\\Users\\DELL\\OneDrive\\Desktop\\authenticate.exe");
				
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					driver.close();
					
			}



	}


