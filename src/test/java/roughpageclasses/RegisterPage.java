package roughpageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class RegisterPage extends BasePage {

	Select sel;

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

//**************** Page Factory or OR***********************

//Radio button
	@FindBy(id = "uniform-id_gender2")
	public WebElement radiobtn_gender;

//FirstName
	@FindBy(id = "customer_firstname")
	public WebElement txtField_firstname;

//LastName
	@FindBy(id = "customer_lastname")
	public WebElement txtField_lastname;

//Password
	@FindBy(id = "passwd")
	public WebElement txtField_password;

//Newsletter -CheckBox
	@FindBy(id = "newsletter")
	public WebElement chkBox_newsletter;

//FirstNameInAddress 
	@FindBy(id = "firstname")
	public WebElement txtField_FirstnameInAddress;

//LastNameInAddress 
	@FindBy(id = "lastname")
	public WebElement txtField_LastnameInAddress;

//AddressLine1
	@FindBy(id = "address1")
	public WebElement txtField_AddressLine1;

//City
	@FindBy(id = "city")
	public WebElement txtField_city;

//State
	@FindBy(id = "id_state")
	public WebElement drpDown_state;

//ZipCode
	@FindBy(id = "postcode")
	public WebElement txtField_zipcode;

//Country
	@FindBy(id = "id_country")
	public WebElement drpDown_Country;

//MobilePhone
	@FindBy(id = "phone_mobile")
	public WebElement txtField_MobilePhone;

//Address Alias
	@FindBy(id = "alias")
	public WebElement txtField_addressAlias;

//Register Button
	@FindBy(css = "button#submitAccount")
	public WebElement btn_Register;

//*******************Page Validations****************************	
	public String validateRegisterPageTitleTest() {
		return driver.getTitle();
	}
	public void validateRegister(String fname, String lname, String pwd, String FnameInAddr, String LnameInAddr,
			String addrLine1, String city, String state, String zipcode, String country, String mobileNum,
			String aliasAddr) {

		radiobtn_gender.click();
// name
		txtField_firstname.clear();
		txtField_firstname.sendKeys(fname);
		txtField_lastname.clear();
		txtField_lastname.sendKeys(lname);

// password
		txtField_password.sendKeys(pwd);

//CheckBox
		chkBox_newsletter.click();

// Address Fields
		txtField_FirstnameInAddress.clear();
		txtField_FirstnameInAddress.sendKeys(FnameInAddr);
		txtField_LastnameInAddress.clear();
		txtField_LastnameInAddress.sendKeys(LnameInAddr);
		txtField_AddressLine1.sendKeys(addrLine1);
		txtField_city.sendKeys(city);

// State
		drpDown_state.click();
		sel = new Select(drpDown_state);
		sel.selectByValue(state);
		txtField_zipcode.sendKeys(zipcode);

// Country
		drpDown_Country.click();
		sel = new Select(drpDown_Country);
		sel.selectByValue(country);

// MobileNumber
		txtField_MobilePhone.sendKeys(mobileNum);

// Address alias
		txtField_addressAlias.clear();
		txtField_addressAlias.sendKeys(aliasAddr);

//Click for Register button

		btn_Register.click();
	}

}
