package firstmaven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class EndToEndTest2 {
	
	ExtentReports extent;

	public static  WebDriver driver;
	
	
	
	@BeforeTest

	public void config()

	{

	// ExtentReports , ExtentSparkReporter

	String path =System.getProperty("user.dir")+"\\reports\\index.html";

	ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);

	reporter.config().setReportName("Web Automation Results");

	reporter.config().setDocumentTitle("Test Results");

	extent =new ExtentReports();

	extent.attachReporter(reporter);

	extent.setSystemInfo("Tester", "Sumit Mishra");

	}

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	@Parameters({ "URL" })

	public void launch(String url) {
		 extent.createTest("Launch");
		driver.manage().window().maximize();
		driver.get(url);

	}

	@Test
	@Parameters({"trip"})

	public void selectTrip(String trip) throws InterruptedException {
		 extent.createTest("Trip");
		driver.findElement(By.xpath("//div[@id="+trip+"]")).click();
		Thread.sleep(2000);
	}

	@Test
	@Parameters({ "from", "to" })
	public void selectfromCity(String from, String to) throws InterruptedException {
		 extent.createTest("Select City");

		WebElement city1 = driver.findElement(By.xpath("//span[contains(text(),'CCU')]"));

		city1.click();

		try {

			driver.findElement(By.xpath("//input[@id='basic-url']")).sendKeys(from);

			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='val']//button/div[1]/div[1]")));

			driver.findElement(By.xpath("//div[@class='val']//button/div[1]/div[1]")).click();
		} catch (StaleElementReferenceException e) {
			System.out.println();
		}

		try {

			// driver.findElement(By.xpath("//span[contains(text(),'Fly to')]")).click();

			driver.findElement(By.xpath("//input[@placeholder='Search City']")).sendKeys(to);

			/*
			 * WebElement
			 * city2=driver.findElement(By.xpath("//span[contains(text(),'Fly to')]"));
			 * city2.click();
			 */

			// driver.findElement(By.xpath("//input[@placeholder='Search City']")).click();

			WebDriverWait w1 = new WebDriverWait(driver, 20);
			w1.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//div[@class=' destinationSide arrival_content']/div//button/div[1]/div[1]")));

			driver.findElement(By.xpath("//div[@class=' destinationSide arrival_content']/div//button/div[1]/div[1]"))
					.click();

		} catch (StaleElementReferenceException e) {
			System.out.println();
		}
		Thread.sleep(2000);

	}

	@Test(dependsOnMethods = { "selectfromCity" })
	@Parameters({"dmonth","ddate","rmonth","rdate"})
	
	public void departDate(String dmonth,String ddate,String rmonth,String rdate ) {
		 extent.createTest("Depart Date");

		driver.findElement(By.xpath("//div[@class='date-picker-date-group']/div[1]/div/div[1]")).click();

		WebElement departdate = driver
				.findElement(By.xpath("//div[@data-month-index="+dmonth+"] //div[@data-day-index="+ddate+"]/div/div"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", departdate);

		driver.findElement(By.xpath("//div[@class='to-reverse']")).click();

		WebElement returndate = driver
				.findElement(By.xpath("//div[@data-month-index="+rmonth+"] //div[@data-day-index="+rdate+"]/div/div"));

		js.executeScript("arguments[0].click();", returndate);

		driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();

	}

	@Test(dependsOnMethods = { "selectfromCity" })
	public void passengers() {
		 extent.createTest("Passengers");
		driver.findElement(By.xpath("//div[@class='show-passengers']")).click();

		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//div[@class='passenger_modal'] //div[@class='user-type-wrapper'][1]//img[2]"))
					.click();
		}

		for (int i = 0; i < 4; i++) {
			driver.findElement(By.xpath("//div[@class='passenger_modal'] //div[@class='user-type-wrapper'][2]//img[2]"))
					.click();
		}

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//div[@class='passenger_modal'] //div[@class='user-type-wrapper'][3]//img[2]"))
					.click();
		}

		driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
        extent.flush();
	}

	@AfterTest
	public void search() {
		driver.findElement(By.xpath("//img[@class='select-image']")).click();
	}
}
