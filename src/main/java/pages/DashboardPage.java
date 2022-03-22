package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class DashboardPage extends Testbase{
	
	//Finding the WebElements
	@FindBy(css="ul.sidebar-menu>li")WebElement frontoffice;
	//creating constructor to declare pagefactory
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	//methods using the WebElements found
	public FrontofficePage clickonfrontoffice()
	{
		frontoffice.click();
		return new FrontofficePage();
	}
	
	

}
