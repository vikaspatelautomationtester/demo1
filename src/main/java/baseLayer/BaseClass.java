package baseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void initialization() {
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikas patel\\Drivers\\chromedriver.exe");
			
		  driver = new ChromeDriver();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.manage().window().maximize();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	
	}

}
