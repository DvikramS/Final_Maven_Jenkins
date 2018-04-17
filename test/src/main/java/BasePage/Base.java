package BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Base {

	public static WebDriver driver=null;
	public static FileInputStream fis;
	public boolean isbrowserOpen=false;
	public static Properties pr;
	static{
		pr=new Properties();
		try {
			fis=new FileInputStream(".\\src\\main\\java\\Config\\config.properties");
			pr.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Base(){
		
	}
	public Base(String browser,String URL){
		if(isbrowserOpen==false||driver==null){
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
				ChromeOptions co=new ChromeOptions();
				co.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver=new ChromeDriver(co);
				driver.manage().window().maximize();
				driver.get(URL);
			}else if(browser.equalsIgnoreCase("mozilla")){
				System.setProperty("Webdriver.gecko.driver", ".\\geckodriver.exe");
				FirefoxOptions fo=new FirefoxOptions();
				fo.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver=new FirefoxDriver(fo);
				driver.manage().window().maximize();
				driver.get(URL);
			}else if(browser.equalsIgnoreCase("IE")){
				System.setProperty("Webdriver.IE.driver", ".\\IEDriverServer");
				InternetExplorerOptions io=new InternetExplorerOptions();
				io.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver=new InternetExplorerDriver(io); 
				driver.manage().window().maximize();
				driver.get(URL);
				
			}
			isbrowserOpen=true;
		}
	}
	
}
