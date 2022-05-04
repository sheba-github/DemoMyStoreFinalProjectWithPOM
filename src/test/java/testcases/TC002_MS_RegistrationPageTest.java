package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pageclasses.LandingPage;
import pageclasses.LoginPage;
import pageclasses.MyAccountPage;
import pageclasses.RegisterPage;

public class TC002_MS_RegistrationPageTest extends BaseClass {

	LandingPage lanpage;
	LoginPage logpage;
	RegisterPage regpage;
	MyAccountPage acctpage;
	SoftAssert asrt;

	@Test
	public void RegisterTest() throws InterruptedException {

		lanpage = new LandingPage(driver);
		lanpage.doClickSignIn();
		test.log(LogStatus.INFO, "Clicked on Sign In Link in Landing Page");

//Clicking on Create an account will happen inside the method itself.
		logpage = new LoginPage(driver);
		logpage.setNewUserEmailAddress("reachautotest1270@gmail.com");
		test.log(LogStatus.INFO, "Clicked on Created a new account in Login Page");

		regpage = new RegisterPage(driver);
		regpage.validateRegister("Jeff", "HartMan", "test1270", "Jeff", "HartMan", "1271 HomeWood", "Moline", 
				"13", "61275","21", "6475645022", "1271 SpringValley");
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Registered a new customer in Registration Page");

//Assertions		
		acctpage = new MyAccountPage(driver);
		String exp_Title = "My account - My Store";
		String act_Title = acctpage.validatePageTitle();
		asrt = new SoftAssert();
		asrt.assertEquals(act_Title, exp_Title);
		test.log(LogStatus.INFO, "Asserted page Title Successfully after Registration");
		
		String exp_name = "Jeff HartMan";
		String act_name = acctpage.validateRegisteredCustomerName();
		System.out.println("Registered Customer name: " + act_name);
		asrt.assertEquals(act_name, exp_name);
		test.log(LogStatus.INFO, "Asserted Customer Name Successfully after Registration");
		asrt.assertAll();

	}

}
