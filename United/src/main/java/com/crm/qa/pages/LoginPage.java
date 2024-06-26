package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page factory or Object Repository
	@FindBy(id="username")
	WebElement username;
		
	@FindBy(id="password")
	WebElement password;
		
	@FindBy(name="action")
	WebElement loginBtn;
		
	@FindBy(linkText="Sign up")
	WebElement signUpLink;
		
	@FindBy(id="prompt-logo-center")
	WebElement imageLogo;
		
	//Initialization
	public LoginPage() {
		PageFactory.initElements(Driver, this);
	}
		
	//Actions
	public String validateLoginPageTitle() {
		return Driver.getTitle();
	}
		
	public boolean validateImageLogo() {
		return imageLogo.isDisplayed();
	}
		
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();	
		return new HomePage();		
	}
		
	public HomePageFree loginHomePageFree(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
			
		return new HomePageFree();
	}
	
	public HomePageAdmin loginHomePageAdmin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePageAdmin();
	}
		
	public void enterUserName() {
		username.sendKeys("lb+acc-opdrachtgever@nowonline.nl");
	}
	public void enterPassword() {
		password.sendKeys("Tester01!");
	}
	public void clickLoginBtn() {
		loginBtn.click();
	}

}
