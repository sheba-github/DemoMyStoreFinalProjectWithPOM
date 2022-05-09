package roughtestcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import roughpageclasses.IdentityPage;
import roughpageclasses.LoginPage;
import roughpageclasses.MyAccountPage;
import roughpageclasses.MypersonalInformationPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC003_MS_MyPersonalInfoPageTest extends BaseClass {
	LoginPage logpage;
	MyAccountPage acctpage;
	MypersonalInformationPage perinfopage;
	IdentityPage idpage;
	SoftAssert asrt;

	@Test
	public void ChangePasswordTest() {

		acctpage = new MyAccountPage(driver);
		acctpage.doClickMyPersonalInfo();
		test.log(LogStatus.INFO, "Clicked on My Personal Information Link on My Account Page");

//Here updating password and clicking on save
		perinfopage = new MypersonalInformationPage(driver);
		perinfopage.validateChangePassword("test8000", "test8001", "test8001");
		test.log(LogStatus.INFO, "Changed the password with new Passwords in MyPersonalInfo Page");
//Assertions
		idpage = new IdentityPage(driver);
		String exp_mesg = "Your personal information has been successfully updated.";
		String act_mesg = idpage.validatePersonalUpdateMessage();
		System.out.println("Message displayed after Password change: "+act_mesg);
		asrt = new SoftAssert();
		asrt.assertEquals(act_mesg, exp_mesg);
		test.log(LogStatus.INFO, "Asserted update personal Info message in IdentityPage");
		System.out.println("Personal information update message displayed properly");
//Logout 
		idpage.doClickLogout();
		test.log(LogStatus.INFO, "Clicked on Logout in Identity Page");
		asrt.assertAll();

	}

	@Test(dependsOnMethods = "ChangePasswordTest")

	public void ReLoginWithChangedPasswordTest()

	{
//Relogin again with changed Password and Assertion of page Title
		logpage = new LoginPage(driver);
		logpage.doLogin("reachautotest8000@gmail.com", "test8001");
		acctpage = new MyAccountPage(driver);
		String act_title = acctpage.validatePageTitle();
		String exp_title = "My account - My Store";
		System.out.println("Page Title after ReLogin using Changed Password: "+act_title);
		asrt = new SoftAssert();
		asrt.assertEquals(act_title, exp_title);
		test.log(LogStatus.INFO, "Logged in with changed password and personal Info got updated Succesfully");
		System.out.println("Relogin Successful with changed Password");
		asrt.assertAll();

	}

}
