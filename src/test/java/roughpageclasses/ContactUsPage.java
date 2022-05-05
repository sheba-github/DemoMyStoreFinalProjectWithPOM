package roughpageclasses;


//import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class ContactUsPage extends BasePage {
	Select sel;

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
//**************** Page Factory or OR***********************

//Subject Heading
	@FindBy(id = "id_contact")
	public WebElement drpDown_SubjectHeading;

//Order Reference	
	@FindBy(name = "id_order")
	public WebElement drpDown_OrderRef;

//File Upload 
	@FindBy(id = "fileUpload")
	public WebElement FileUpld_AttachFile;
//Message
	@FindBy(id = "message")
	public WebElement txtField_message;

//Send Button
	@FindBy(xpath = "//button[@name ='submitMessage']")
	public WebElement btn_Send;

//Contact Us sent message 
	@FindBy(css = "p.alert.alert-success")
	public WebElement txt_ContactUsSentMsgText;

//Sign Out
	@FindBy(xpath = "//a[@title='Log me out']")
	public WebElement link_SignOut;

//Image
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	public WebElement img_YourLogo;

//********************* Page Actions************************

	public void doAttachFile() {
		FileUpld_AttachFile.sendKeys("C:\\Users\\Saravanan\\eclipse-workspacenewQA\\DemoMyStoreFinalProjectWithPOM\\src\\test\\resources\\screenshots\\TShirt.JPG");
	}

	public void setMessage(String mesg) {
		txtField_message.sendKeys(mesg);
	}

	public void doClickSend() {
		btn_Send.click();

	}

	public void doClickSignOut() {

		link_SignOut.click();
	}

	public void doClickYourLogo() {
		img_YourLogo.click();
	}

//*******************Page Validations***********************

/*	public void validateContactUsPage(String subHeading,String filepath, String mesg) {

		// Select Subject heading
		drpDown_SubjectHeading.click();
		sel = new Select(drpDown_SubjectHeading);
		sel.selectByValue(subHeading);

		// Order Reference
		/*drpDown_OrderRef.click();
		sel = new Select(drpDown_OrderRef);
		List<WebElement> options = sel.getOptions();
		for(WebElement OrNum:options)
		{  String OdrNum =OrNum.getText();
			if (OdrNum.equals(orderNum)) {
				sel.selectByValue(orderNum);
			}
			
		}
		
		FileUpld_AttachFile.sendKeys(filepath);
		txtField_message.sendKeys(mesg);
		btn_Send.click();
	}*/
	
	public void setsubHeadingPage(String subHeading)
	{
		//Select Subject heading
		drpDown_SubjectHeading.click();
		sel = new Select(drpDown_SubjectHeading);
		sel.selectByValue(subHeading);
		
	}	
	
	
	

	public String validateContactUsSentText() {
		return txt_ContactUsSentMsgText.getText();
	}
}
