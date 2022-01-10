package LoginPage;

public class Main 
{

	public static void main(String[] args) 
	{
		
		IDandPASSWORD idandPasswords = new IDandPASSWORD(); // idandPasswords object will access ID & PASSWORD page
		// we send the login info retrieved from ID & PASSWORD page to Login Page 
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
		
	}

}
