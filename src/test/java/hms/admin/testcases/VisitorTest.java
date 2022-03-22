package hms.admin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Testbase;
import commonutility.ReadExcel;
import pages.DashboardPage;
import pages.FrontofficePage;
import pages.LoginPage;
import pages.VisitorPage;

public class VisitorTest extends Testbase{
	//declaring variables for 4 classes
		LoginPage objlog;
		DashboardPage objdash;
		FrontofficePage objfront;
		VisitorPage objvis;
		
		//declaring this class as super class using constructor
		public VisitorTest()
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
			objvis=objfront.clickonvisitorbook();
		}
		@DataProvider
		public Object[][] getvisdata()
		{
			Object[][] data=ReadExcel.getTestData("testdata");
			return data;
			
		}
		@Test(dataProvider="getvisdata")
		public void savevisitordetails(String vis[])
		{
			String Expectedtabletitle="Visitor List";
			Assert.assertEquals(objvis.getvistabletitle(), Expectedtabletitle);
			objvis.clickonvisbutton();
			String Expectedscreentitle="Add Visitor";
			Assert.assertEquals(objvis.getvisscreentitle(), Expectedscreentitle);
			objvis.addvisitordetails(vis);
			
		}
		@AfterMethod 
		public void teardown()
		{
			driver.close();
		}
		

}
