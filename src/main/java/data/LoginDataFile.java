package data;

import utilities.Xls_Reader;

public class LoginDataFile {

	Xls_Reader data = new Xls_Reader("C:\\Selenium Learning\\testing\\SauceLoginUsersTestData.xlsx");
	
	public String lockoutUsername = data.getCellData("LoginUsers", "Username", 2);
	public String lockoutUserPass = data.getCellData("LoginUsers", "Password", 2);
	public String lockoutUserErrMsg = data.getCellData("LoginUsers", "ErrorMessage", 2);
	
	public String InvalidUsername = data.getCellData("LoginUsers", "Username", 3);
	public String InvalidUserPass = data.getCellData("LoginUsers", "Password", 3);
	public String InvalidUserErrMsg = data.getCellData("LoginUsers", "ErrorMessage", 3);
}
