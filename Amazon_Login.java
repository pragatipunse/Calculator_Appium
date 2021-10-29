package SELENIUM_PRACTISE.SELENIUM_PRACTISE_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Login {

	static WebDriver driver;
	public static void main(String args[]) throws InterruptedException
	{
		
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HQQ098\\eclipse-workspace\\Selenium\\src\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
//		String actualTitle=driver.getTitle();
//		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
//		Assert.assertEquals(expectedTitle, actualTitle);
//		System.out.println("link succefully open");
		WebElement account=driver.findElement(By.id("nav-link-accountList"));
		Actions action=new Actions(driver);
		action.moveToElement(account).build().perform();
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();

//		String actualTitle1=driver.getTitle();
//		String expectedTitle1="Amazon Sign In";
//		Assert.assertEquals(expectedTitle1, actualTitle1);
		
		driver.findElement(By.name("email")).sendKeys("pragatipunse47@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Pragati@1995");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		WebElement signout=driver.findElement(By.xpath("//a[@data-nav-role='signin']/div/span[@id='nav-link-accountList-nav-line-1']"));
		action.moveToElement(signout).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
	}
	}


	
	

