package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='UserId']") WebElement txtuserName;
	@FindBy(xpath="//input[@id='password']") WebElement txtpassword;
	@FindBy(xpath="//button[@id='next']") WebElement signinButton;
	@FindBy(xpath="//img[@class='logo']") WebElement logo;
	
	public void enterUserName(String user)
	{
		txtuserName.sendKeys(user);
	}
	public void enterPassword(String pass)
	{
		txtpassword.sendKeys(pass);
	}
	public void clickSignIn()
	{
		signinButton.click();
	}
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
}

