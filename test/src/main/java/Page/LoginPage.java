package Page;

import org.openqa.selenium.By;

import BasePage.Base;

public class LoginPage extends Base {
public static String from=".//*[@id='gosuggest_inputSrc']";
public static void login(){
	String s=pr.getProperty("Browser");
	String ss=pr.getProperty("AppURL");
	new Base(pr.getProperty("Browser"),pr.getProperty("AppURL"));
	Base.driver.findElement(By.xpath(from)).sendKeys("test");
}
}
