package LoginPage;

import java.util.HashMap;

public class IDandPASSWORD 
{
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPASSWORD() // Declaring predefined ID & PASSWORD 
	{
		logininfo.put("Dan" , "kan");
		logininfo.put("Jon" , "1234");
		logininfo.put("Lee" , "Ho123");
		logininfo.put("Put" , "HRETUS");
	}
	
	protected HashMap getLoginInfo()
	{
		return logininfo;  // it will send info to Main which will further send it to Login Page to compare the values
	}

}
