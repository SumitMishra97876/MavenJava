package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation_MultiLang_Select {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");

		driver.findElement(By.xpath("//div[@id='msdd']")).click();

		//selectChoice(driver, "Polish", "Serbian", "Danish", "Hindi", "English","Urdu");
		selectChoice(driver,"All");
	}

	public static void selectChoice(WebDriver driver, String... value) {

		List<WebElement> langs = driver.findElements(By
				.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (!value[0].equalsIgnoreCase("All")) {
			for (WebElement item : langs) {
				String text = item.getText();

				for (String val : value) {
					if (text.equals(val)) {
						js.executeScript("arguments[0].click()", item);

						break;
					}
				}
			}
		} else {
			for (WebElement item : langs) {
				js.executeScript("arguments[0].click()", item);

			}
		}

	}

}
