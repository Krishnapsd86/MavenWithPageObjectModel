package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public void SetUp() throws IOException {
		
		prop =new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\data.Properties");
		prop.load(fis);
		//System.out.println(prop.getProperty("browser"));
		
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\krish\\Downloads\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
			driver.get(prop.getProperty("baseUrl"));
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			driver.get(prop.getProperty("baseUrl"));
		}
		
		
	}
	
	public void tearDown() {
		driver.close();
	}

}
