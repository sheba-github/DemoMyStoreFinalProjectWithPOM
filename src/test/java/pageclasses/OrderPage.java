package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class OrderPage extends BasePage {

	public OrderPage(WebDriver driver) {
		super(driver);
	}
	
//**************** Page Factory or OR***********************
		
//Remove icon
	@FindBy(xpath ="//table[@id ='cart_summary']/tbody/tr[3]/td[7]/div/a")
	public WebElement icon_deleteitem;

//Proceed to Checkout
	@FindBy(xpath ="//p[@class='cart_navigation clearfix']/a[1]")
	public WebElement btn_ProceedtoCheckout;

//Email Address
	@FindBy(css = "input#email")
	public WebElement txtField_emailAddress;

//Password
	@FindBy(id = "passwd")
	public WebElement txtField_password;
	
//SignIn
	@FindBy(id="SubmitLogin")
	public WebElement btn_SignIn;
	
//ProceedtoCheckOutAddress
	@FindBy(xpath ="//button[@name='processAddress']")
	public WebElement btn_ProceedtoCheckOutAddress;
	
//I agree checkBox
    @FindBy(xpath ="//div[@id='uniform-cgv']")
    public WebElement chkBox_IAgree;
    
//Proceed To Checkout-carrier
    @FindBy(xpath ="//button[@name='processCarrier']")
    public WebElement link_ProceedtoCheckOutCarrier;
    
//Pay by Check 
    @FindBy(xpath="//a[@title='Pay by check.']")
    public WebElement link_PayByChk;
    
//I Confirm my order
    @FindBy(xpath="//span[text()='I confirm my order']")
    public WebElement btn_confirmmyorder;
    
// Order Confirmation
    @FindBy(css="p.alert.alert-success")
    public WebElement txt_OrderConfirm;
    
//Contact Us
    
    @FindBy(xpath="//a[contains(text(),'Contact us')][1]")
    public WebElement link_ContactUs;
	
//*******************Page Actions***********************

 //Click Remove Item
    public void doClickRemoveIcon() {
	icon_deleteitem.click();
     }
//Click Proceed to Checkout 
    public void doClickProceedToCheckout() {
	
	btn_ProceedtoCheckout.click();
	}
//Click Proceed to Checkout the Address 
    public void doClickProceedToCheckOutAddress() {
	
	btn_ProceedtoCheckOutAddress.click();
    }
//CheckBox I agree click
    public void doClickIAgree()
    {	
	chkBox_IAgree.click();
    }

//Click Proceed to Checkout - ProcessCarrier
    public void doClickProceedToCheckOutCarrier() {
	link_ProceedtoCheckOutCarrier.click();
   }
    
 //Click pay by check link
    public void doClickPayByCheck() {
    	
    	link_PayByChk.click();
    }
//I confirm my order
    public void doClickIConfirmMyOrder() {
    	
    	btn_confirmmyorder.click();
    } 
//Contact us
    public void doClickContactUs() {
    	link_ContactUs.click();
    }
  
    
//*******************Page Validations***********************

public void validateSignIn(String email, String pwd) {
	
	txtField_emailAddress.sendKeys(email);
	txtField_password.sendKeys(pwd);
	btn_SignIn.click();
}

public String validateOrderConfirmText() {
	return txt_OrderConfirm.getText();	
}

public String validateGetTitleOfOrderConfirm() {
	return driver.getTitle();
}

//remove this code in original
public String validateConfirmMyOrderbuttonText() {
	return btn_confirmmyorder.getText();
}

}
