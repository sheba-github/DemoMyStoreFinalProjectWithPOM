package roughtestcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import roughpageclasses.LandingPage;
import roughpageclasses.LoginPage;
import roughpageclasses.MyAccountPage;
import roughpageclasses.RegisterPage;

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
		logpage.setNewUserEmailAddress("reachautotest8000@gmail.com");
		test.log(LogStatus.INFO, "Clicked on Created a new account in Login Page");

		regpage = new RegisterPage(driver);
		regpage.validateRegister("Adam", "Marth", "test8000", "Adam", "Marth", "8000 HomeWood", "Moline", 
				"13", "61276","21", "6475645022", "8000 SpringValley");
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Registered a new customer in Registration Page");

//Assertions		
		acctpage = new MyAccountPage(driver);
		String exp_Title = "My account - My Store";
		String act_Title = acctpage.validatePageTitle();
		System.out.println("Page title of Registration Page:"+ act_Title);
		asrt = new SoftAssert();
		asrt.assertEquals(act_Title, exp_Title);
		test.log(LogStatus.INFO, "Asserted page Title Successfully after Registration");
		
		String exp_name = "Adam Marth";
		String act_name = acctpage.validateRegisteredCustomerName();
		System.out.println("Registered Customer name: " + act_name);
		asrt.assertEquals(act_name, exp_name);
		test.log(LogStatus.INFO, "Asserted Customer Name Successfully after Registration");
		asrt.assertAll();

	}

}
