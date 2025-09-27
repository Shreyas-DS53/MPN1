package TestCases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import PageObjects.Addservices;
import TestBase.BaseClass;

public class TC_03AddServicesTest extends BaseClass {
	@Test
	public void ADT()
	{
		Addservices As=new Addservices(driver);
		As.clickLedger();
		As.clickaddservicelookup();
		As.clickclear();
		As.addingservices("97010 "+" 97014"+" 97035" + Keys.ENTER);
		As.clicksave();
	}
	

}
