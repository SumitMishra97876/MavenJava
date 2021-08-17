package ractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemoMyntra {

	WebDriver driver;
	Actions actions;
	ChromeOptions options;

	public ActionsDemoMyntra() {
		WebDriverManager.chromedriver().setup();

		// options=new ChromeOptions();
		// options.addArguments("--disable-notifications");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		actions = new Actions(driver);
	}

	public void loadUrl() {
		driver.get("https://www.myntra.com/");
	}

	public void performActions() {
		WebElement mens = driver.findElement(By.xpath("//a[@class='desktop-main'][normalize-space()='Men']"));

		actions.moveToElement(mens).perform();
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-reactid='173']")));
		WebElement bagPacks = driver.findElement(By.xpath("//li[@data-reactid='173']"));
		actions.moveToElement(bagPacks).click().build().perform();

	}

	public void select_bag(String... choices) throws InterruptedException {

		List<WebElement> opts = driver.findElements(By.xpath("//ul[@class='categories-list']/li/label/input"));
		System.out.println(opts.size());
		if (!choices[0].equalsIgnoreCase("All")) {
			for (int i = 0; i < opts.size(); i++) {
				System.out.println(opts.get(i).getAttribute("value"));
				String text = opts.get(i).getAttribute("value");

				for (String val : choices) {
					// if (opts.get(i).getAttribute("value").equals(str)) {
					if (text.equals(val)) {

						Thread.sleep(200);
						actions.moveToElement(opts.get(i)).click().build().perform();
						// opts.get(i).click();
						break;
					}
				}

			}
		} else {
			for (WebElement item : opts) {
				Thread.sleep(200);

				actions.moveToElement(item).click().build().perform();
				// item.click();
			}
		}
	}
}
