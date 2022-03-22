package hms.admin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.LoginPage;

public class LoginTest extends Testbase {
	//declaring the object for the LoginPage class
	LoginPage objlog;
	//Using constructor to declare LoginTest as super class
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new LoginPage();
	}
	@Test
	public void adminlogintest()
	{
		//to check the title
		String Expectedtitle="Smart Hospital : Hospital Management System";
		Assert.assertEquals(objlog.getpagetitle(), Expectedtitle);
		//to check the logo
		Assert.assertTrue(objlog.Islogodisplayed());
		//to check whether the expected text is displayed
		String Expectedtext="Admin Login";
		Assert.assertEquals(objlog.getlogintxt(), Expectedtext);
		//If the above all are correct, then login
		objlog.adminlogin(prop.getProperty("Username"), prop.getProperty("Password"));
		objlog.clickonprofile();
		String Expectedusername="Super Admin";
		Assert.assertEquals(objlog.getusername(), Expectedusername);
		objlog.applogout();
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	

}
