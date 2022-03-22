package hms.admin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.DashboardPage;
import pages.FrontofficePage;
import pages.LoginPage;

public class FrontofficeTest extends Testbase{
	//declaring variables for 3 classes
	LoginPage objlog;
	DashboardPage objdash;
	FrontofficePage objfront;
	//declaring this class as super class using constructor
	public FrontofficeTest()
	{
		super();
		
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new LoginPage();
		objdash=objlog.adminlogin(prop.getProperty("Username"), prop.getProperty("Password"));
		objfront=objdash.clickonfrontoffice();
	}
	@Test
	public void clickvisitor()
	{
		String Expectedtabletitle="Appointment Details";
		Assert.assertEquals(objfront.gettabletitle(), Expectedtabletitle);
		objfront.clickonvisitorbook();
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
