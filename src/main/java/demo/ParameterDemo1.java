package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo1 {
	@Parameters({"username","password"})
	@Test
	public void login(String abc, String xyz) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikas patel\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("username")).sendKeys(abc);
		driver.findElement(By.name("password")).sendKeys(xyz);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

	}

}
