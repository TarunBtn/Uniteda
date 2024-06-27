package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public LoginPageTest(){
		super();
	}
		
	@BeforeMethod
	public void setUp()throws Exception {
		//Driver.quit();
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
	}
	
	@Test
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Log in | Younited® platform");
	}
	
	@Test
	public void imageLogoTest() {
		boolean flag=loginPage.validateImageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void loginTest()throws Exception {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.testWaitEight();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quit();
	}

}
