package Appi_Package;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Appium_Calculator {

	
	//WebDriver driver;
	static AppiumDriver <MobileElement> driver;
	//AndroidDriver driver;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	 	try {
		
			openCalculator();
		}catch(Exception exp) {
			
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		

		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi Note 8 Pro");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformversion", "11 RP1A.200720.011");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url , cap);
		
		System.out.println("Application Started....");
		
		MobileElement  two = driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
		MobileElement plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s\r\n"));
		MobileElement three = driver.findElement(By.id("com.miui.calculator:id/btn_3_s"));
		MobileElement equals = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
		MobileElement result = driver.findElement(By.className("android.widget.TextView\r\n"));
		

		
		two.click();
		plus.click();
		three.click();
		equals.click();
		
		String res = result.getText();
		System.out.println("\n Result is : "+res);
		
		System.out.println("Completed.....");
		
	}
	private static void openCalculator() {
		// TODO Auto-generated method stub
		
	}

}
