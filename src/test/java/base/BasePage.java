package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//Initializing the WebDriver object
public class BasePage {
	
	protected WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
