package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class IdentityPage extends BasePage {
	Actions action;

	public IdentityPage(WebDriver driver) {
		super(driver);
	}

//**************** Page Factory or OR***********************
//Update Message
	@FindBy(css = "p.alert.alert-success")
	public WebElement text_PersonalInfoUpdate;
//Back To Account button	
	@FindBy(xpath = "//ul[@class='footer_links clearfix']/li[1]")
	public WebElement btn_BackToAcct;
//Home button	
	@FindBy(xpath = "//ul[@class='footer_links clearfix']/li[2]")
	public WebElement btn_Home;
//Logout 
	@FindBy(css = "a.logout")
	public WebElement link_Logout;

// Women Link
	@FindBy(xpath = "//a[@title='Women']")
	public WebElement link_Women;

// T-Shirts Link	
	@FindBy(xpath = "//a[@title='T-shirts'][1]")
	public WebElement link_TShirts;

// Add to Cart for T-Shirts	
	@FindBy(xpath = "//p[@id='add_to_cart']")
	public WebElement btn_AddtoCartTShirts;

//Faded t-shirt link
	@FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	public WebElement link_fadedtshirt;

//Proceed to Checkout 
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	public WebElement btn_ProceedToCheckout;

//********************* Page Actions************************

//Back to Account click	
	public void doClickBackToAcct() {
		btn_BackToAcct.click();
	}

//Home click
	public void doClickHome() {
		btn_Home.click();
	}

//Logout
	public void doClickLogout() {
		link_Logout.click();
	}

//Women Link
	public void doHoverWomenTab() {
		action = new Actions(driver);
		action.moveToElement(link_Women).build().perform();
	}

//*******************Page Validations***********************
//GetMessage
	public String validatePersonalUpdateMessage() {
		return text_PersonalInfoUpdate.getText();
	}

//	Adding a product and clicking on proceed to Checkout
	public void validateAddTShirt() {

		link_TShirts.click();
		link_fadedtshirt.click();
		btn_AddtoCartTShirts.click();
		btn_ProceedToCheckout.click();
	}

}
