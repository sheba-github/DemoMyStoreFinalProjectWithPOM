package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import base.BaseClass;
import pageclasses.LandingPage;
import pageclasses.LoginPage;

public class TC006_MS_CreateAnAccountFailedTest extends BaseClass {
	LandingPage lanpage;
	LoginPage logpage;
	SoftAssert asrt;
	
	
	@Test
	public void CreateAnAccountTest() throws InterruptedException {
		
		lanpage= new LandingPage(driver);
        lanpage.doClickSignIn();
        test.log(LogStatus.INFO,"Clicked on Sign In link on Landing page");
        
        logpage=new LoginPage(driver);
        logpage.setEmailAddr("reachautotest2022@gmail.com");
        test.log(LogStatus.INFO,"Entered an Email Address");

        logpage.doClickCreateAnAcctBtn();
        test.log(LogStatus.INFO,"Clicked on Create an Account Button");
        
        String act_errText=logpage.validateErrMsgCreateAnAccount();
        Thread.sleep(2000);
        System.out.println("Actual Error Text: "+act_errText);
        String exp_errText="An account using this email address has already been registered. Please enter a valid password or request a new one";
       
        asrt= new SoftAssert();
        asrt.assertEquals(act_errText,exp_errText);    
        asrt.assertAll();
        
		
	}
	
	

}
