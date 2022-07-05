package ractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Utility util = new Utility(driver);

		List<WebElement> compList;

		boolean flag = false;

		driver.manage().window().maximize();

		driver.get("http://34.96.110.11/");

		By comps = By.xpath("//div[@class='company-item']");

		compList = util.getElements(comps);
		util.visibilityOfAllElements(compList, 20);

		int size = compList.size();
		System.out.println(size);

		for (int p = 0; p < 12; p++) {

			String page = Integer.toString(p + 1);
			if (page.equals("11") || page.equals("12")) {
				flag = true;
			}
			WebElement pages = driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='" + page + "']"));
			if (page.equals("12")) {
				size = size - 1;

			}
			for (int i = 0; i < size; i++) {
				if (Integer.parseInt(page) != 1) {
					pages = driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='" + page + "']"));
					js.executeScript("arguments[0].click()", pages);
				}
				js.executeScript("arguments[0].click()", compList.get(i));
				By header = By.xpath("//h1[@class='banktitle']");
				util.waitForElementPresent(header, 10);

				System.out.println(driver.findElement(header).getText());
				//driver.navigate().to("http://34.96.110.11/");
				driver.navigate().back();
				

				Thread.sleep(2000);

				
				if (Integer.parseInt(page) == 5) {
					for (int j = 0; j < 4; j++) {
						WebElement nextPage = driver.findElement(By.xpath("//a[@aria-label='Go to next page']"));
						js.executeScript("arguments[0].click()", nextPage);
						
					}

					pages = driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='" + page + "']"));
					js.executeScript("arguments[0].click()", pages);
				} else {
					if (Integer.parseInt(page) != 1 && Integer.parseInt(page) != 2 && Integer.parseInt(page) != 3
							&& Integer.parseInt(page) != 4 && Integer.parseInt(page) != 5) {
						for (int k = 0; k < 5; k++) {
							WebElement nextPage1 = driver.findElement(By.xpath("//a[@aria-label='Go to next page']"));
							js.executeScript("arguments[0].click()", nextPage1);
						}
					}
					if (flag) {
						for (int l = 0; l < 2; l++) {
							WebElement nextPage1 = driver.findElement(By.xpath("//a[@aria-label='Go to next page']"));
							js.executeScript("arguments[0].click()", nextPage1);
						}
					}
					pages = driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='" + page + "']"));

					js.executeScript("arguments[0].click()", pages);

					if (Integer.parseInt(page) == 10) {
						for (int k = 0; k < 2; k++) {
							WebElement nextPage2 = driver.findElement(By.xpath("//a[@aria-label='Go to next page']"));
							js.executeScript("arguments[0].click()", nextPage2);
						}
						pages = driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='" + page + "']"));

						js.executeScript("arguments[0].click()", pages);
					} else {
						if (Integer.parseInt(page) == 11 || Integer.parseInt(page) == 12) {

							for (int k = 0; k < 1; k++) {
								if (flag == true)
									break;
								WebElement nextPage3 = driver
										.findElement(By.xpath("//a[@aria-label='Go to next page']"));
								js.executeScript("arguments[0].click()", nextPage3);
							}
						}
					}
					pages = driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='" + page + "']"));

					js.executeScript("arguments[0].click()", pages);

				}

				// driver.navigate().to("http://34.96.110.11/");
				util.waitForElementPresent(comps, 20);
				compList = util.getElements(comps);
				util.visibilityOfAllElements(compList, 20);

			}

		}

	}
}
