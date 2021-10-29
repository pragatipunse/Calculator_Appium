package SELENIUM_PRACTISE.SELENIUM_PRACTISE_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class trello_Login {

	static WebDriver driver;
	
	@BeforeClass
	
	public void setup() 
		{
		
			WebDriverManager.chromedriver().setup();
			
			 driver=new ChromeDriver();
		
			driver.manage().window().maximize();
			
			driver.get("https://trello.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	@Test(description="Login to trello")
	public void atlassianLogin() throws InterruptedException
	  {
			driver.findElement(By.linkText("Log in")).click();
			driver.findElement(By.id("user")).sendKeys("pragati.punse@qapitol.com");
			driver.findElement(By.id("login")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("password")).sendKeys("Pragati@1995");
			
			driver.findElement(By.xpath("//span[text()='Log in']")).click();
			String actualTitle=driver.getTitle();
		    String expectedTitle="Log in to continue - Log in with Atlassian account";
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("Succefully Login");
			
			
	     }	
	@Test(description="Logout from Trello")
	public void logout()
	{
		driver.findElement(By.xpath("//span[@title='Pragati Punse (pragatipunse)']")).click();
		driver.findElement(By.xpath("//button[@class='_3Qtx4lodxp9J0E']/span[text()='Log out']")).click();
		driver.findElement(By.xpath("//*[@id='logout-submit']/span")).click();
		String actual=driver.getTitle();
		//System.out.println(actual);
   	   String expected="Atlassian account";
        Assert.assertEquals(actual, expected);
    	System.out.println("successfully logout");
	}
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	

}



