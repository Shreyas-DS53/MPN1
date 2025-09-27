package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public Logger logger = LogManager.getLogger(getClass());

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://ehrapp.eclipseehrcloud.net/");
        logger.info("Browser launched and application opened.");
    }

    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully.");
        }
    }

    public String captureScreenshot(String tname) {
        if (driver == null) {
            logger.error("Driver is null! Cannot take screenshot.");
            return null;
        }

        try {
            // Wait a short moment to ensure page has loaded
            Thread.sleep(500);  

            // Timestamp for unique file names
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

            // Capture screenshot as bytes to avoid corruption
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Prepare the target directory
            String targetDir = System.getProperty("user.dir") + File.separator + "screenshots";
            File dir = new File(targetDir);
            if (!dir.exists()) dir.mkdirs();

            // Prepare the file path
            String targetFilePath = targetDir + File.separator + tname + "_" + timeStamp + ".png";

            // Write the bytes to file
            FileUtils.writeByteArrayToFile(new File(targetFilePath), screenshot);

            logger.info("Screenshot saved at: " + targetFilePath);
            return targetFilePath;

        } catch (IOException e) {
            logger.error("Error while saving screenshot: " + e.getMessage());
        } catch (InterruptedException e) {
            logger.error("Thread interrupted while waiting for screenshot: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        return null;
    }
    
public String createRandomString()
{
	String randomString = RandomStringUtils.randomAlphabetic(5);
	return randomString;
	
}
public String createRandomNumber()
{
	String randomNumber = RandomStringUtils.randomNumeric(10);
	return randomNumber;
	
}
public String createRandomDOB() {
    // Define date format
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    // Set range: 18 to 90 years old
    Calendar start = Calendar.getInstance();
    start.add(Calendar.YEAR, -90);  // oldest 90 years back
    Calendar end = Calendar.getInstance();
    end.add(Calendar.YEAR, -18);    // youngest 18 years old

    // Generate random millis between start and end
    long randomMillis = ThreadLocalRandom.current()
            .nextLong(start.getTimeInMillis(), end.getTimeInMillis());

    return sdf.format(new Date(randomMillis));
}
}

	
	
	
	
	
	
	
	