package roughtestcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import roughpageclasses.IdentityPage;
import roughpageclasses.OrderPage;

public class TC004_MS_OrderPageTest extends BaseClass {
	IdentityPage idpage;
	OrderPage odrpage;
	SoftAssert asrt;
	
	
	@Test
	public void AddProductsToCartTest() throws InterruptedException
	{   
        //Navigating to Women tab
		idpage=new IdentityPage(driver);
		idpage.doHoverWomenTab();
		test.log(LogStatus.INFO, "Hovered on Women tab on Identity Page");
		idpage.validateAddTShirt();
		test.log(LogStatus.INFO, "Added TShirt and clicked on proceed to checkout");			
		
		//Order Page Proceed to checkout
		odrpage=new OrderPage(driver);		
     	odrpage.doClickProceedToCheckout();
     	test.log(LogStatus.INFO, "Clicked on proceed to checkout in Order Page");
		odrpage.doClickProceedToCheckOutAddress();
        test.log(LogStatus.INFO, "Clicked on Proceed to checkout to process address in Order Page");
        odrpage.doClickIAgree();
        test.log(LogStatus.INFO, "Clicked on I agree Checkbox in Order Page");
        odrpage.doClickProceedToCheckOutCarrier();
        test.log(LogStatus.INFO, "Clicked on proceed to checkout carrier in Order Page");
        odrpage.doClickPayByCheck();
        test.log(LogStatus.INFO, "Clicked on Pay By check payment method in Order Page");               
        odrpage.doClickIConfirmMyOrder();
        test.log(LogStatus.INFO, "Clicked on I confirm my order");

                  
        //Assertions in Order confirmation Page
        asrt=new SoftAssert();
        String exp_title="Order confirmation - My Store";
        String act_title=odrpage.validateGetTitleOfOrderConfirm();
        asrt.assertEquals(act_title, exp_title);   
        test.log(LogStatus.INFO, "Assertion on Order Confirmation title completed");
        String exp_mesg="Your order on My Store is complete.";
        String act_mesg=odrpage.validateOrderConfirmText();
        asrt.assertEquals(act_mesg, exp_mesg);   
        test.log(LogStatus.INFO, "Assertion on Order Confirmation message completed");
        asrt.assertAll();
        
		
	}
	

}
