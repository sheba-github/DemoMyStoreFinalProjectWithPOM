package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

//********************* Page Actions************************

//----------New User Section--------

//Email Address for New User
	@FindBy(id = "email_create")
	public WebElement textField_NewUserEmail;

//Create an Account Button

	@FindBy(id = "SubmitCreate")
	public WebElement btn_CreateAnAcct;
	
// Create an account error message
	@FindBy(xpath="//div[@id='create_account_error']/ol/li")
	public WebElement errTxt_CreateAnAcct;	

//-----Registered User Section-----

// Email Address
	@FindBy(id = "email")
	public WebElement txtField_emailAddress;

// Password
	@FindBy(id = "passwd")
	public WebElement txtField_password;

//Submit Button
	@FindBy(css = "button#SubmitLogin")
	public WebElement btn_SignIn;
//*******************Page Actions***********************		
	public void setEmailAddr(String email) {
		textField_NewUserEmail.sendKeys(email);

	}
    public void doClickCreateAnAcctBtn() {
		btn_CreateAnAcct.click();

    }
    
//*******************Page Validations***********************	

    public String validateErrMsgCreateAnAccount() {
    	return errTxt_CreateAnAcct.getText();
    }
    
//Logging In
	public void doLogin(String Uname, String pwd) {

		txtField_emailAddress.sendKeys(Uname);
		txtField_password.sendKeys(pwd);
		btn_SignIn.click();
	}

//New Account Creation	
	public void setNewUserEmailAddress(String email) {

		textField_NewUserEmail.sendKeys(email);
		btn_CreateAnAcct.click();

	}
	

}
