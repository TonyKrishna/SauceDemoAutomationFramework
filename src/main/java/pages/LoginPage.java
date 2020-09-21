package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy (xpath="//div[@class='login_logo']")
	WebElement loginLogo;
	
	@FindBy (id="user-name")
	WebElement username;
	
	@FindBy (id="password")
	WebElement password;
	
	@FindBy (id="login-button")
	WebElement loginButton;
	
	@FindBy (xpath="//h3[@data-test='error']")
	WebElement errMsg;
	
	public LoginPage(){	
		PageFactory.initElements(driver, this);
	}
	 
	
	public boolean getLoginPageLogoStatus() {
		//PageFactory.initElements(driver, this);
		System.out.println("Title : "+ driver.getTitle());
		return loginLogo.isDisplayed();
	}
	
	public void validLogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
	}


	public String getLoginErrorMsg() {
		
		return errMsg.getText();
	}
	

}
