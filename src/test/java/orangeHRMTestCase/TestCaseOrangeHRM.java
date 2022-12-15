package orangeHRMTestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseLayer.BaseClass;

public class TestCaseOrangeHRM extends BaseClass

{
	
	static String empid;
	
	
	@Test
	public void setup()
	{
		BaseClass.initialization();
	}
	
	@Test(dependsOnMethods = {"setup"})
	public void loginFuntionality()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();	
	}
	
	@Test(dependsOnMethods = {"loginFuntionality"})
	public void validateHomePageLogo()
	{
		boolean actualLogo=driver.findElement(By.xpath("//img[@alt = 'client brand banner']")).isDisplayed();
		Assert.assertEquals(actualLogo, true);
	}
	
	@Test(dependsOnMethods = {"validateHomePageLogo"})
	public void clickOnPIM()
	{
	   driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}
	
	@Test(dependsOnMethods = {"clickOnPIM"})
	public void validatePimUrl()
	{
		   String actualurl = driver.getCurrentUrl();
		   Assert.assertEquals(actualurl.contains("pim"), true);
	}
	
	@Test(dependsOnMethods = {"validatePimUrl"})
	public void addNewUserInPIM()
	{
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("Vikas");
		driver.findElement(By.name("middleName")).sendKeys("Kumar");
		driver.findElement(By.name("lastName")).sendKeys("Patel");
		
		empid =driver.findElement(By.xpath("//input[@name='lastName']/following::input[1]")).getAttribute("value");
	    
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
	@Test(dependsOnMethods = {"addNewUserInPIM"})
	public void addMorePersonalDetails()
	{
		driver.findElement(By.xpath("(//input[contains(@class,'active')])[8]")).sendKeys("85745696");
		
		driver.findElement(By.xpath("(//input[contains(@class,'active')])[10]")).sendKeys("987654321");
		//driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
	}
	
	@Test(dependsOnMethods = {"addMorePersonalDetails"})
	public void validatePersonalDetails()
	{
		String personalDetails =driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-name']")).getText();
		Assert.assertEquals(personalDetails.contains("Vikas Patel"), true);
	}
	
	@Test(dependsOnMethods = {"validatePersonalDetails"})
	public void searchEmp()
	{
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
	}
	
	@Test(dependsOnMethods = {"searchEmp"})
	public void enterEmpIdAndSearch()
	{
	   driver.findElement(By.xpath("(//input[contains(@class,'active')])[2]")).sendKeys(empid);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(dependsOnMethods = {"enterEmpIdAndSearch"})
	public void deleteEmp()
	{
		driver.findElement(By.xpath("(//div[@class='oxd-checkbox-wrapper'])[1]")).click();
		
		driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
		
		driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
	}
}
