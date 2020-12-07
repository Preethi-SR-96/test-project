package commonFunctionExample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class CommonFunc {
	
	public static WebDriver driver = null;
	public static Properties properties = null;
	
	static Logger logger = Logger.getLogger(CommonFunc.class); //Factory design pattern
	
	public Properties loadPropertyFile() throws IOException {
		
		FileInputStream fileInputStream = new FileInputStream("config.properties"); //this line --> Read the file
		properties = new Properties();
		properties.load(fileInputStream);
		
		return properties;
	}
	
	@BeforeSuite()
	public void launchBrowser() throws IOException {
		
		PropertyConfigurator.configure("Log4j.properties"); //here we are congigure the log4j "we are using propertyconfigurator for .properties file"
		
		logger.info("Orange HRM Test Begins");
		logger.info("Loading the property file");
		loadPropertyFile();
		
	String browser = properties.getProperty("browser");
	String url = properties.getProperty("url");
	String driverLocation = properties.getProperty("DriverLocation");
	
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",driverLocation);
		logger.info("Launch the chrome browser");
		driver = new ChromeDriver();
	}
	else 
	
	if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver",driverLocation);
		logger.info("Launch the firefox browser");
		driver = new FirefoxDriver();
	}	
	driver.manage().window().maximize();
	logger.info("Navigating to application");
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
	
	
	@AfterSuite
	public void tearDown() {
		logger.info("Execution Done. closing the browser");
		driver.quit();
	}

}
