package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Addservices extends BasePage {

	public Addservices(WebDriver driver) 
	{
		super(driver);
		
	}
	@FindBy(xpath="//div[@class='circle-image green-bg']")WebElement tabledger;
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")WebElement btnaddservicelookup;
	@FindBy(xpath="//button[normalize-space()='Clear']")WebElement btnclear;
	@FindBy(xpath="//input[@placeholder='Enter office code(s) separated by spaces']")WebElement txtaddservice;
	@FindBy(xpath="//button[normalize-space()='Save / Close']")WebElement btnsave;
	
	public void clickLedger() {
	        wait.until(ExpectedConditions.elementToBeClickable(tabledger)).click();
	    }

    public void clickaddservicelookup() {
	        wait.until(ExpectedConditions.elementToBeClickable(btnaddservicelookup)).click();
	    }
	public void clickclear()
	{
		if (btnclear.isDisplayed())btnclear.click();
	}
	public void addingservices(String servicecodes) {
	        wait.until(ExpectedConditions.visibilityOf(txtaddservice)).sendKeys(servicecodes);
	    }

	public void clicksave() {
	        wait.until(ExpectedConditions.elementToBeClickable(btnsave)).click();
	    }
}
