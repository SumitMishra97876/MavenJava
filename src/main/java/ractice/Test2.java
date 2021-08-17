package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Utility util = new Utility(driver);

		List<WebElement> compList;

		driver.manage().window().maximize();

		driver.get("http://34.96.110.11/");

		By comps = By.xpath("//div[@class='company-item']");

		compList = util.getElements(comps);
		util.visibilityOfAllElements(compList, 20);

		int size = compList.size();
		System.out.println(size);

		for (int p = 1; p <= 8; p++) {

			for (int i = 0; i < size; i++) {

				js.executeScript("arguments[0].click()", compList.get(i));
				By header = By.xpath("//h1[@class='banktitle']");
				util.waitForElementPresent(header, 10);

				System.out.println(driver.findElement(header).getText());

				// driver.navigate().back();
				driver.navigate().to("http://34.96.110.11/");

				util.waitForElementPresent(comps, 20);
				compList = util.getElements(comps);
				util.visibilityOfAllElements(compList, 20);

			}
			String page = Integer.toString(p + 1);
			WebElement pages = driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='" + page + "']"));
			js.executeScript("arguments[0].click()", pages);

			if (Integer.parseInt(page) == 5) {
				for (int i = 0; i < 4; i++) {
					WebElement nextPage = driver.findElement(By.xpath("//a[@aria-label='Go to next page']"));
					js.executeScript("arguments[0].click()", nextPage);
				}

				continue;
			}

		}

	}
}
