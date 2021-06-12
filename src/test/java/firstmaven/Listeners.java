package firstmaven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;





public class Listeners implements ITestListener						
{		
	String filePath = "D:\\DELL\\screenshot";
	
	
    @Override		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub
    	String methodname=result.getName().toString().trim();
		System.out.println(methodname);
		
		
		TakesScreenshot ts = (TakesScreenshot)EndToEndTest2.driver;
		  
		  File srcFile = ts.getScreenshotAs(OutputType.FILE);
		  
		  try {
			  FileUtils.copyFile(srcFile, new File(filePath +methodname+ ".png") );
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
		
		
	}
        		
    	

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub	
    	String methodname=result.getName().toString().trim();
		System.out.println(methodname);
		
		
		TakesScreenshot ts = (TakesScreenshot)EndToEndTest2.driver;
		  
		  File srcFile = ts.getScreenshotAs(OutputType.FILE);
		  
		  try {
			  FileUtils.copyFile(srcFile, new File(filePath +methodname+ ".png") );
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
		
		
	}
        		
    }		
	