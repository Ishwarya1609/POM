package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class LoginPage extends Testbase {
	//identify the webelements for sign in
	@FindBy(tagName="img")WebElement logo;
	@FindBy(css="h3.bolds")WebElement logintxt;
	@FindBy(css="input.form-username")WebElement username;
	@FindBy(css="input.form-password")WebElement password;
	@FindBy(tagName="button")WebElement signin;
	
	//identify the webelements for logout
	@FindBy(css="img.topuser-image")WebElement profile;
	@FindBy(xpath="//h5[text()='Super Admin']")WebElement profiletxt;
	@FindBy(css="div.sspass>a:nth-child(3)")WebElement logout;

//Need to declare it as page factory using constructor[page factory initialization]
public LoginPage()
{
	PageFactory.initElements(driver, this);
}
//Script to get page title
public String getpagetitle()
{
	return driver.getTitle();
}
//script to check the logo is displayed
public boolean Islogodisplayed()
{
	return logo.isDisplayed();
	
}
//Script to get the login text
public String getlogintxt()
{
	return logintxt.getText();
	
}
//Script to login
public DashboardPage adminlogin(String uname,String upass)
{
	username.sendKeys(uname);
	password.sendKeys(upass);
	signin.click();
	return new DashboardPage();

}
//Script to click on profile image
public void clickonprofile() 
{
	profile.click();
	}
//Script to get username
public String getusername()
{
	waitforvisibility(profiletxt);
	return profiletxt.getText();
}
//Script to logout
public void applogout()
{
	logout.click();
}


}
