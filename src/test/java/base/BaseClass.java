package base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import util.ExtentManager;
import util.WaitUtil;

public class BaseClass {

	/*
	 * Initialise Webdriver, properties, xls ,creating db connection, generating
	 * logs
	 */

	public static Properties config = new Properties();
	public static WebDriver driver = null;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	

	@BeforeSuite()
	public static void init() throws IOException {
		if (driver == null) {
			// load Config property file
			FileInputStream fis = new FileInputStream(
			System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
		
			if (config.getProperty("browser").equals("chrome")) {				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\executables\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();

			}

			driver.get(config.getProperty("url"));
			driver.manage().window().maximize();


			// Global implicit Wait
			driver.manage().timeouts().implicitlyWait(WaitUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		}
	}
		
	@AfterSuite()
	public static void tearDown() {
		
		if(driver!=null) {
		  driver.quit();

		 	}
	}
}
