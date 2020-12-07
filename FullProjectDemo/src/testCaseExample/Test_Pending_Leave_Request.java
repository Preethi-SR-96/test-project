package testCaseExample;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonFunctionExample.CommonFunc;
import pageObjectExample.Dashboard_Page_Objects;
import pageObjectExample.Login_Page_Objects;

public class Test_Pending_Leave_Request extends CommonFunc {
	String actualMessage = null;
	static Logger logger = Logger.getLogger(Test_Pending_Leave_Request.class);
	
	public void login() {
		PageFactory.initElements(driver,Login_Page_Objects.class);
		
		Login_Page_Objects.userName.sendKeys(properties.getProperty("username"));
		Login_Page_Objects.passWord.sendKeys(properties.getProperty("password"));
		Login_Page_Objects.submitButton.click();	
	}	
	
	public void getPendingLeaveRequestData() {
		PageFactory.initElements(driver,Dashboard_Page_Objects.class);
		
		actualMessage = Dashboard_Page_Objects.pendingLeaveRequests.getText();
		System.out.println(actualMessage);
	}
	
	@Test
	public void verifyPendingLeaveRequest () {
		
		logger.info("Logging into the application");
		login(); //call the method here
		
		logger.info("Getting the Pending Leave Request user details");
		getPendingLeaveRequestData();
		
		logger.info("Verification");
		Assert.assertEquals(actualMessage, "01. Linda Anderson 2020-08-04");
		logger.info("End of Test_Pending_Leave_Request test case");
	}
	
	

}
