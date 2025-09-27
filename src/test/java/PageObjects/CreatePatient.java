package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePatient extends BasePage {

		public CreatePatient(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(xpath="//img[@src='../img/Plus.svg']")WebElement btnlookup;
	@FindBy(xpath="//label[1]")WebElement optnnewPatient;
	@FindBy(xpath="//input[@id='m_patientInfoDTO.FirstName']")WebElement txtFirstName;
	@FindBy(xpath="//input[@id='m_patientInfoDTO.LastName']")WebElement txtLastName;
	@FindBy(xpath="(//input[contains(@id,'mask-')])[1]")WebElement txtDOB;
	@FindBy(xpath="//button[@type='submit']")WebElement btnSave;

	public void clickLookup()
	{
		btnlookup.click();
	}
	public void selectNewPatient()
	{
		optnnewPatient.click();
	}
	public void enterFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void enterLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	public void enterDOB(String dob)
	{
		txtDOB.click();
		txtDOB.sendKeys(dob);
	}
	public void clickSave()
	{
		btnSave.click();
	}
	
	

}
