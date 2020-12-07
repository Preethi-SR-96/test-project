package pageObjectExample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Role_Page_Objects {
	
	
	@FindBy(id="menu_admin_viewAdminModule")
	public static WebElement adminMenu;
	
	@FindBy(id="menu_admin_UserManagement")
	public static WebElement userManagement;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	public static WebElement user;
	
	@FindBy(id="searchSystemUser_userType")
	public static WebElement userRole;
	
	@FindBy(id="searchSystemUser_status")
	public static WebElement userStatus;
	
	@FindBy(id="searchBtn")
	public static WebElement searchButton;
	
	@FindBy(xpath="//tr/td[3]")
	public static WebElement userRoleTableValue;
	
	@FindBy(xpath="//tr/td[5]")
	public static WebElement statusTableValue;


}
