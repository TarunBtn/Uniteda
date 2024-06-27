package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver Driver;
	public static Properties prop;
	
	public TestBase() {
		try {
		    prop=new Properties();
		    //FileInputStream ip=new FileInputStream("C:\\Users\\tbutani\\git\\Uniteda\\United\\src\\"
		    	//	+ "main\\java\\com\\crm\\qa\\config\\config.properties");
		    String configPath = System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.properties";
            System.out.println("Loading config from: " + configPath);
            FileInputStream ip = new FileInputStream(configPath); 
		    prop.load(ip);
		    
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public static void initialization()throws Exception {
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
			 /*String chromeDriverPath = System.getenv("chromium") != null ? System.getenv("chromium") : "/usr/bin/chromium-browser";
	         System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			
		    ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");*/
			Driver=new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.firefox.driver", "C:\\geckodriver\\geckodriver.exe");
			 /*String geckoDriverPath = System.getenv("GECKO_DRIVER") != null ? System.getenv("GECKO_DRIVER") : "path/to/default/geckodriver";
	         System.setProperty("webdriver.gecko.driver", geckoDriverPath);*/
			 Driver=new FirefoxDriver();
		}
	
		//Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		
		
	}

}


