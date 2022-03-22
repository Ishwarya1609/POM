package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Testbase;
import commonutility.Datepicker;
import commonutility.Utilities;

public class VisitorPage extends Testbase{
	//finding the webelements of visitor page
	@FindBy(xpath="//h3[text()='Visitor List']")WebElement vistabletitle;
	@FindBy(css="div.pull-right>a")WebElement addvisitorbutton;
	@FindBy(xpath="//h4[text()=' Add Visitor']")WebElement visscreentitle;
	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement pname;
	@FindBy(css="form#formadd input[name='contact']")WebElement pphone;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement pidproof;
	@FindBy(css="form#formadd input[name='pepples']")WebElement numofperson;
	@FindBy(css="form#formadd input[name='date']")WebElement date;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement upfile;
	@FindBy(css="form#formadd button[type='button']")WebElement closebutton;
	
	//to initialize the above elements in pagefactory using constructor
	public VisitorPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//creating methods using the found elements
	public String getvistabletitle()
	{
		return vistabletitle.getText();
	}
	public void clickonvisbutton()
	{
		addvisitorbutton.click();
	}
	public String getvisscreentitle()
	{
		waitforvisibility(visscreentitle);
		return visscreentitle.getText();
		
	}
	//add visitor details
	public void addvisitordetails(String vd[])
	{
		//purpose dropdown.so use select class
		Select sdrp=new Select(purpose);
		sdrp.selectByVisibleText(vd[0]);
		//name
		pname.sendKeys(vd[1]);
		pphone.sendKeys(vd[2]);
		pidproof.sendKeys(vd[3]);
		numofperson.sendKeys(vd[5]);
		//datepicker
		date.click();
		Datepicker dp=new Datepicker();
		dp.datpicker(vd[4]);
		
		note.sendKeys(vd[6]);
		//upfile
		Utilities.mouseclick(upfile);
		Utilities.fileupload(vd[7]);
		
		
		
		
	}
	
	
	
}
