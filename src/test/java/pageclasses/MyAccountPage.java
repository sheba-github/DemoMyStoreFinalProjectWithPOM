package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
//**************** Page Factory or OR***********************

//My personal information link		
	@FindBy(xpath = "//span[text()='My personal information']")
	public WebElement link_MyPersonalInfo;

//CustomerAccountName
	@FindBy(css = "a.account")
	public WebElement link_RegCustAcctname;
	
//ContactUs link
	@FindBy(xpath ="//a[contains(text(),'Contact us')][1]")
	public WebElement link_ContactUs;

//********************* Page Actions************************	
// personal info
	public void doClickMyPersonalInfo() {
		link_MyPersonalInfo.click();
	}
//Contact Us 
	public void doClickContactUs() {
		link_ContactUs.click();		
	}
  

//*********************Page Validations*********************

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public String validateRegisteredCustomerName() {
		return link_RegCustAcctname.getText();

	}

}
