package hms.admin.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends Testbase{
	//declaring variables for Loginpage and Dashboardpage
	LoginPage objlog;
	DashboardPage objdash;
	//creating constructor to declare super class
	public DashboardTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new LoginPage();
		objdash=objlog.adminlogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	@Test
	
	public void dashtest()
	{
		objdash.clickonfrontoffice();
	}
	@AfterMethod 
	public void teardown()
	{
		driver.close();
	}
	

}
