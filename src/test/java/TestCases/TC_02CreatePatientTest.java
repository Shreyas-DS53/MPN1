package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObjects.CreatePatient;
import TestBase.BaseClass;

public class TC_02CreatePatientTest extends BaseClass {
	
	@Test
	public void CNP()
	{
		logger.info("Creating new patient");
		CreatePatient cnp=new CreatePatient(driver);
		cnp.clickLookup();
		cnp.selectNewPatient();
		String firstName = createRandomString();
        cnp.enterFirstName(firstName);
        String lastName = createRandomString();
        cnp.enterLastName(lastName);
        String DOB= createRandomDOB();
        cnp.enterDOB(DOB);
        cnp.clickSave();		
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'"+firstName+"')]")).getText());
        System.out.println("Patient Created Successfully");
	}
	
	

}
