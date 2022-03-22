package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonutility.Activitycapture;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	//Declaration of variables
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event;
	public static Activitycapture actcap;
	
	//Create constructor for the class
	public Testbase()
	{
		try {
			//Give the location of the appconfig file
			FileInputStream ipconfig=new FileInputStream("./src/main/java/config/appconfig.properties");
			//create obj. reference for prop
			prop=new Properties();
			//to load the appconfig file
			prop.load(ipconfig);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//constructor completed
	
	//create user-defined method 
	public static void initialization()
	{
		//Browser Selection Script	
		String Browser=prop.getProperty("Browser");
		String mode=prop.getProperty("Headless");
		
		if(Browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			if(mode.equals("true"))
				//for headless mode if it is true
			{
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--headless");
				driver=new ChromeDriver(option);
			}else//if headless mode is false then chrome browser opens
			{
			driver=new ChromeDriver();
			}
		}
		else if(Browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
		
			System.out.println("Check the Browser Name");
		}
		//Basic methods
		//Wait time to handle the page loading time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		//to write logs
		event=new EventFiringWebDriver(driver);
		actcap=new Activitycapture();
		event.register(actcap);
		driver=event;
		}
	//Explicit Wait
	public static void waitforvisibility(WebElement el)
	{
	WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(70));
	wt.until(ExpectedConditions.visibilityOf(el));
	}

}
