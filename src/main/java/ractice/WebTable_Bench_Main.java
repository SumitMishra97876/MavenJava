package ractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Bench_Main {
      
	public static void main(String[] args) {
		
		WebTable_Bench_Training w=new WebTable_Bench_Training();
		
		w.loadUrl();
		w.countRowCols();
		w.getDetails();
	}

}
