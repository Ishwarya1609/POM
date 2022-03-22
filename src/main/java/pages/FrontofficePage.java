package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class FrontofficePage extends Testbase{
	//Inspecting WebElements of frontoffice module
	@FindBy(xpath="//h3[text()='Appointment Details']")WebElement fofftitle;
	@FindBy(css="div.box-tools>a:nth-child(2)")WebElement visitorbook;
	
	//declaring pagefactory using constructor
	public FrontofficePage()
	{
		PageFactory.initElements(driver, this);
	}
	//create methods for the elements identified
	public String gettabletitle()
	{
		return fofftitle.getText();
		
	}
	public VisitorPage clickonvisitorbook()
	{
		visitorbook.click();
		return new VisitorPage();
	}
	

}
