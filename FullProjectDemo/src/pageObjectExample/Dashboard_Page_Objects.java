package pageObjectExample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_Page_Objects {
	
	@FindBy(xpath="//*[@id=\"panel_resizable_1_2\"]//following::td[1]//a")
	public static WebElement pendingLeaveRequests;

}
