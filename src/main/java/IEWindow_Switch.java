import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IEWindow_Switch {
	
	
public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//       // capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
//		capabilities.setCapability("nativeEvents", true);
//		capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
//		capabilities.setCapability("ignoreZoomSetting", true);
      // capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
//		
		
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_N);
		
		Thread.sleep(2000);
//		 
//		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
//		
        //driver.switchTo().window(parent);
//		
//		
//		
//		
//		
//		
		driver.manage().window().maximize();
//		
////		System.out.println(driver.getCurrentUrl());
		driver.get("http://www.facebook.com");
     	
     	driver.switchTo().window(parent);
     	driver.get("http://www.myntra.com");

}
}
}
}
