package pageclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LandingPage extends BasePage {
	Actions action;

	public LandingPage(WebDriver driver) {
		super(driver);
	}

//**************** Page Factory or OR********************

// ContactUs link
	@FindBy(id = "contact-link")
	public WebElement link_ContactUs;

// SignIn link
	@FindBy(xpath = "//a[@class='login']")
	public WebElement link_SignIn;

// Cart link
	@FindBy(xpath = "//a[@title='View my shopping cart']")
	public WebElement link_Cart;

// FollowUs link-FaceBook
	@FindBy(css = "li.facebook")
	public WebElement link_Facebook;

// FollowUs link- Twitter
	@FindBy(css = "li.twitter")
	public WebElement link_Twitter;

// FollowUs link-YouTube
	@FindBy(css = "li.youtube")
	public WebElement link_YouTube;

// FollowUs link-GooglePlus
	@FindBy(css = "li.google-plus")
	public WebElement link_GooglePlus;

//-------Products---------------------------------------------

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

//Continue Shopping button
	@FindBy(xpath = "//span[@title='Continue shopping']")
	public WebElement btn_ContinueShopping;

//Proceed to Checkout 
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	public WebElement btn_ProceedToCheckout;

//********************* Page Actions************************

//Contact Us Link Click
	public void doClickContactUs() {
		link_ContactUs.click();
	}

//SignInButton Click
	public void doClickSignIn() {
		link_SignIn.click();
	}

	public void doHoverWomenTab() {
		action = new Actions(driver);
		action.moveToElement(link_Women).build().perform();
	}

//*******************Page Validations************************

//Clicking on Women->Add Blouse,a casual Dress and T shirt

	public void validateAddTShirt() {

		link_TShirts.click();
		link_fadedtshirt.click();
		btn_AddtoCartTShirts.click();
		btn_ProceedToCheckout.click();
	}

//PageTitle
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

// GetText of Cart before adding any products
	public String validateGetTextOfCart() {
		return link_Cart.getText();
	}

// FollowUs link Validation

	public void validateFollowUsLinks() throws InterruptedException {

		link_Facebook.click();
		link_Twitter.click();
		link_YouTube.click();
		link_GooglePlus.click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		List<String> windowIDsList = new ArrayList<String>(allWindowHandles);
		System.out.println("The windowTitles are: ");
		System.out.println();
		for (String ID : windowIDsList) {
			String windowTitle = driver.switchTo().window(ID).getTitle();
			System.out.println(windowTitle);
			// Closing just the child windows
			if ((windowTitle.equals("Sign in - Google Accounts"))
					|| (windowTitle.equals("Selenium Framework - YouTube"))
					|| (windowTitle.equals("Selenium Framework (@seleniumfrmwrk) / Twitter"))
					|| (windowTitle.equals("Selenium Framework | Facebook"))) {
				Thread.sleep(1000);
				driver.close();
			}

		}

	}

}
