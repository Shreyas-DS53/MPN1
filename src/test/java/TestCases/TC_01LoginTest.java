package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import TestBase.BaseClass;

public class TC_01LoginTest extends BaseClass {

    @Test
    public void verifyLoginWithValidCredentials() throws InterruptedException {
        logger.info("Logging into the application...");

        LoginPage lp = new LoginPage(driver);
        lp.enterUserName("MPNQATest");
        lp.enterPassword("Password@123");
        lp.clickSignIn();
        Thread.sleep(45000);
        // ✅ Replace Thread.sleep with explicit wait
      //WebElement logo= driver.findElement(By.xpath("//img[@class='logo']"));
         boolean logoResult =lp.validateLogo();
         Assert.assertTrue(logoResult, "❌ Login failed: Logo was not displayed after login");
         logger.info("✅ Login successful: Logo is visible");
    }
}
