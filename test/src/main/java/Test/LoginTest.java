package Test;

import org.testng.annotations.Test;

import Page.LoginPage;

public class LoginTest {
	
	@Test
	public void loginTest(){
		LoginPage.login();
		System.out.println("test");
	}

}
