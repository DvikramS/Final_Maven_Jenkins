package UitilityFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BasePage.Base;

public class Utilities {

	
	public void highlightElements(WebElement element){
		JavascriptExecutor js=(JavascriptExecutor)Base.driver;
		js.executeScript("arguments[0].setAttribute('style' 'background:yellow;border: 2px solid red;');", element);
	}

	public void dragAndDrop(WebElement element, WebElement element1){
		
		Actions ac=(Actions)Base.driver;
		ac.dragAndDrop(element, element1).build().perform();
	}
	public void doubleClick(WebElement element){
		Actions ac=(Actions)Base.driver;
		ac.doubleClick(element).perform();
	}
	public void contextClick(WebElement element){
		
		Actions ac=(Actions)Base.driver;
		ac.contextClick(element).perform();
	}
	public void scrollintoview(WebElement element){
		JavascriptExecutor js=(JavascriptExecutor)Base.driver;
		js.executeScript("arguments[0].scrollIntoView().click()", element);
	}
	public void scrollupAndDown(){
		JavascriptExecutor js=(JavascriptExecutor)Base.driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	public void resizeWindow(){
		Dimension d=new Dimension(420,540);
		Base.driver.manage().window().setSize(d);
	}
	
	public Connection dbConnection(){
		Connection con=null;
		try {
			Class.forName("mysql.jdbc.driver");
			
			 con=DriverManager.getConnection("","","");
			Statement st=con.createStatement();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public void switchFrames(){
		Base.driver.switchTo().frame("name");
		Base.driver.switchTo().defaultContent();
		//java -cp pathofsrc;bin\* org.testng.TestNG testng.xml
	}
}

