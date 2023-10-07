package com.crossjourney.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
public static FileReader fileReader;
public static Properties prop;
public static WebDriver driver;


	public TestBase() {

		try {
			fileReader = new FileReader("C:\\Software\\Branch\\Cross_Journey\\src\\main\\java\\com\\crossjourney\\config\\config.property");
			prop = new Properties();
			try {
				prop.load(fileReader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Software\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\driverexe\\gecodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.gecko.driver", "E:\\driverexe\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		try {
			Thread. sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
