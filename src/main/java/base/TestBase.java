package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	//WebDriverWait wait = new WebDriverWait(driver, 30); // Explicit Wait

	public TestBase(){
		try {
		FileInputStream fs = new FileInputStream("C:\\Selenium Learning\\testing\\sauceProp.properties");
		prop = new Properties();
		
		prop.load(fs);
		}
		catch (FileNotFoundException e) {
		e.printStackTrace();
		} 
		catch (IOException e) {
		e.printStackTrace();
		}
		
	}
	
	
	public static void initBrowser() {
		String browserName = prop.getProperty("browser");
		String baseUrl = prop.getProperty("baseURL");
		
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Learning\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Learning\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Learning\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(baseUrl);
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
}
