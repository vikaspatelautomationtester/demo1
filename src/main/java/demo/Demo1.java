package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1 {
	
	@Test(priority = 1, groups = { "login1" })
	public void login() {
		System.out.println("login method is started");
		Assert.assertEquals("TestNG", "TestNG");
		System.out.println("login method is ended");

	}

	@Test(priority = 2, groups = { "home1" },dependsOnGroups = {"login1"},alwaysRun = true)
	public void home() 
	{
		System.out.println("homepage method is started");
		Assert.assertEquals(123, 123);
		System.out.println("homepage method is ended");
	}

	@Test(priority = 3, groups = { "contact" },dependsOnGroups = {"home1"})
	public void contactpage() {
		System.out.println("contact method is started");
		Assert.assertEquals("selenium", "selenium");
		System.out.println("contact method is ended");

	}


}
