package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class MypersonalInformationPage extends BasePage {

	public MypersonalInformationPage(WebDriver driver) {
		super(driver);
	}

//**************** Page Factory or OR**********************		
//Current Password
	@FindBy(xpath = "//input[@name='old_passwd']")
	public WebElement txtField_CurrentPwd;

//New Password
	@FindBy(id = "passwd")
	public WebElement txtField_NewPwd;

//Confirmation
	@FindBy(id = "confirmation")
	public WebElement txtField_confirmation;

//CheckBox 1 - Newsletter 
	@FindBy(id = "newsletter")
	public WebElement chkBox_newsletter;

//CheckBox 2- Special Offers
	@FindBy(id = "optin")
	public WebElement chkBox_optin;

//Save button
	@FindBy(xpath = "//button[@name='submitIdentity']")
	public WebElement btn_Save;

//********************* Page Actions************************		

//Current password
	public void setCurrentPwd(String Curpwd) {
		txtField_CurrentPwd.sendKeys(Curpwd);
	}

//New password
	public void setNewPwd(String Newpwd) {
		txtField_NewPwd.sendKeys(Newpwd);
	}

//Confirm Password
	public void Confirmation(String confirmpwd) {
		txtField_confirmation.sendKeys(confirmpwd);
	}

//Checking NewsLetter
	public void doClickNewsletter() {
		chkBox_newsletter.click();
	}

//*******************Page Validations*************************

//Change Password Validation
	public void validateChangePassword(String curpwd, String newpwd, String confirmpwd) {
		txtField_CurrentPwd.sendKeys(curpwd);
		txtField_NewPwd.sendKeys(newpwd);
		txtField_confirmation.sendKeys(confirmpwd);
		chkBox_newsletter.click();
		btn_Save.click();
	}

}
