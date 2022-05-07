package roughtestcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import roughpageclasses.ContactUsPage;
//import pageclasses.LandingPage;
//import pageclasses.LoginPage;
//import pageclasses.MyAccountPage;
import roughpageclasses.OrderPage;
import com.relevantcodes.extentreports.LogStatus;


public class TC005_MS_ContactUsPageTest extends BaseClass{
	/*LandingPage lanpage;
	LoginPage logpage;
	MyAccountPage acctpage;*/
	ContactUsPage contuspage;
	OrderPage odrpage;
	SoftAssert asrt;

	@Test
	public void ContactUsPageTest() throws InterruptedException {
		//test= rep.startTest("ContactUsPageTest Started ");
		
		//Clicking on SignIn
		/*lanpage = new LandingPage(driver);
        lanpage.doClickSignIn();
        //Logging SignIn
		logpage=new LoginPage(driver);
		logpage.doLogin("reachautotest2022@gmail.com", "test1235");
		
		acctpage=new MyAccountPage(driver); 
		acctpage.doClickContactUs();*/
		
		odrpage=new OrderPage(driver);
		odrpage.doClickContactUs();
		test.log(LogStatus.INFO, "Clicked on Contact Us link in Order Page");
		
		contuspage= new ContactUsPage(driver);
        contuspage.setsubHeadingPage("2");
        contuspage.doAttachFile();
        contuspage.setMessage("Issue With TShirt");
        contuspage.doClickSend();
		test.log(LogStatus.INFO, "Provided the details in the ContactUs Page");		
		String act_text =contuspage.validateContactUsSentText();
		String exp_text="Your message has been successfully sent to our team.";
		System.out.println("Message displayed after ContactUs Flow: "+act_text);
		asrt=new SoftAssert();
		asrt.assertEquals(act_text, exp_text);
		test.log(LogStatus.INFO, "Asserted the Contact Us sent text successsully");
		asrt.assertAll();		
		contuspage.doClickSignOut();
		System.out.println("Logged Out Successfully");
		test.log(LogStatus.INFO, "Logged Out successsully");
		

	}
	
	
}
