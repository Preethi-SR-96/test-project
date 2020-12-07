package testCaseExample;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonFunctionExample.CommonFunc;
import pageObjectExample.User_Role_Page_Objects;

public class Test_User_Role extends CommonFunc{
	
	static Logger logger = Logger.getLogger(Test_User_Role.class);
	
	public void moveToUsersPage() { //This is one method
		
		Actions actions = new Actions(driver); // Here Actions is a class and actions is a object
		actions.moveToElement(User_Role_Page_Objects.adminMenu);
		actions.moveToElement(User_Role_Page_Objects.userManagement);
		actions.moveToElement(User_Role_Page_Objects.user);
		actions.click().build().perform();
	}
	
	public void selectUserRole() {
		
		Select selectRole = new Select(User_Role_Page_Objects.userRole);
		selectRole.selectByIndex(1);
	}
	
	public void selectStatus() {
		Select selectRole = new Select(User_Role_Page_Objects.userStatus);
		selectRole.selectByIndex(1);
	}
	
	@Test
	public void verifyUserRole() {   
		
		PageFactory.initElements(driver, User_Role_Page_Objects.class);
		
		logger.info("Navigating to users page");
		moveToUsersPage(); // call the method here
		
		logger.info("Selecting the user role");
		selectUserRole();
		
		logger.info("Selecting the status");
		selectStatus();
		
		User_Role_Page_Objects.searchButton.click();
		
		String actualRole = User_Role_Page_Objects.userRoleTableValue.getText();
		String actualStatus = User_Role_Page_Objects.statusTableValue.getText();
		
		logger.info("Verifying the results");
		Assert.assertEquals(actualRole, "Admin");
		Assert.assertEquals(actualStatus, "Enabled");
		
		logger.info("End of Test_User_Role test case");
	}

}
