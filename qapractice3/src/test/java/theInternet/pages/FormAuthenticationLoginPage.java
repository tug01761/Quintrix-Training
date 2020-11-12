package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class FormAuthenticationLoginPage extends PageObjectBase{
	
	public FormAuthenticationLoginPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	
	
	@FindBy(id="username")
	WebElement usernameTextbox;
	
	@FindBy(id="password")
	WebElement passwordTextbox;
	
	@FindBy(className="radius")
	WebElement loginButton;
	
	String username = "tomsmith";
	String password = "SuperSecretPassword!";
	
	
	public FormAuthenticationLoginPage navigate() {
		super.navigate("/login");
		return this;
	}
	
	public FormAuthenticationSecuredPage login() {
		FormAuthenticationSecuredPage securedPage = new FormAuthenticationSecuredPage(driver, baseUrl);
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		
		loginButton.click();
		return securedPage;
	}
	
	
	


}
