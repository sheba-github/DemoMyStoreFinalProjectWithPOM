package roughtestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import roughpageclasses.LoginPage;
//import roughpageclasses.ContactUsPage;
import roughpageclasses.LandingPage;
import com.relevantcodes.extentreports.LogStatus;

/*
 * Landing Page Validations -PageTitle,Multiple Windows,GetText
 * 
 */
public class TC001_MS_LandingPageTest extends BaseClass {

	LandingPage lanpage;
	LoginPage logpage;
	SoftAssert asrt;

//Landing Page Title Test

	@Test(priority = 1)
	public void LandingPageTitleTest() {

	    logpage = new LoginPage(driver);
		logpage.doClickLogo();
		
		test.log(LogStatus.INFO, "Clicked on YourLogo in the LoginPage");
		lanpage = new LandingPage(driver);
		String LP_expTitle = "My Store";
		String LP_actTitle = lanpage.validateLoginPageTitle();
		asrt = new SoftAssert();
		System.out.println("Actual Title:" + LP_actTitle);
		asrt.assertEquals(LP_actTitle, LP_expTitle);
		test.log(LogStatus.INFO, "Asserted the Landing Page Title Successfully");

	}

//FollowUsLinks - Multiple Windows

	@Test(priority = 3)
	public void FollowUsLinksTest() throws InterruptedException {
		lanpage = new LandingPage(driver);
		lanpage.validateFollowUsLinks();
		test.log(LogStatus.INFO, "Clicked on FollowUsLinks in Landing Page and closed only child windows");
		System.out.println("Validated Multiple Windows");
	}

//Text of Cart before adding any items

	@Test(priority = 2)
	public void CartTextTest() {
		lanpage = new LandingPage(driver);
		String LP_actText = lanpage.validateGetTextOfCart();
		System.out.println("Actual text of Cart before adding products : " + LP_actText);
		String LP_expText = "Cart (empty)";
		Assert.assertEquals(LP_actText, LP_expText);
		test.log(LogStatus.INFO, "Asserted the Cart text before adding product");

	}

}
