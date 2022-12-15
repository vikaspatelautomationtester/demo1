package demo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softassert {
	

	@Test
	public void m1() {
		System.out.println("M1 method is started");
		SoftAssert soft =new SoftAssert();
		soft.assertEquals("selenium", "TestNG");
	
		System.out.println("M1 method is ended");
		
		soft.assertAll();
	}

	@Test
	public void m2() {
		System.out.println("M2 method is started");
		SoftAssert soft =new SoftAssert();
		soft.assertEquals(123, 123);
		System.out.println("M2 method is ended");
	}

}
