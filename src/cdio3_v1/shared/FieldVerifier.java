package cdio3_v1.shared;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is not translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client-side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid for our service.
	 * 
	 * In this example, we only require that the name is at least four
	 * characters. In your application, you can use more complex checks to ensure
	 * that usernames, passwords, email addresses, URLs, and other fields have the
	 * proper syntax.
	 * 
	 * @param name the name to validate
	 * @return true if valid, false if invalid
	 */
	
	public static boolean isNameValid(String name) throws DALException{
		return ((name.length() > 1) && (name.length() < 21));
		
	}
	
	public static boolean isIdValid(String oprId) throws DALException {
		if(oprId.length() == 0){
			return false;
		}
		for(char c : oprId.toCharArray()){
			if(!Character.isDigit(c)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNewIdValid(int oprId) throws DALException
	{
		return ((oprId > 0) && (oprId < 100000000));	
	}
	
	public static boolean isIniValid(String ini) throws DALException
	{
		return ((ini.length() > 1) && (ini.length() < 4));
	}
	
	public static boolean isCprValid(String cpr) throws DALException
	{ 
		String cprFirstPart = cpr.substring(0,6);
		String cprSecdondPart = cpr.substring(6);
		if (cpr.charAt(6) != '-')
		{
			cpr = cprFirstPart + "-" + cprSecdondPart;
		}
		cpr = cpr.replace("-", "");// klipet striben i cprNummer
		try
		{
			long Cpr = Long.parseLong(cpr);// sættes så længe Cpr er: lig cpr og lig med en række af 10 tal.

			if(cpr.length()==10)
			{
				return true; 
			}
			return false;

		}
		catch(Exception e)
		{
			throw new DALException("CPR er ikke gyldigt");
		}

	}
	
	public static boolean isPasswordValid(String password) throws DALException{
		boolean passwordOK = false;
		
		try {
			if((password.length()>6) && (password.length() < 9))
			{
				int smalls = 0;
				int bigs = 0;
				int nos = 0;
				int cha = 0;
				for(int i=0 ; i<password.length() ; i++)
				{
					if(password.charAt(i)>='A' && password.charAt(i)<='Z'){
						bigs ++;
					}
					if(password.charAt(i)>='a' && password.charAt(i)<='z'){
						smalls ++;
					}
					if(password.charAt(i)>='0' && password.charAt(i)<='9'){
						nos ++;
					}
					if(password.charAt(i)>='.' && password.charAt(i)<='='){
						cha ++;
					}
				}

				if((bigs>=1) && (smalls>=1) && (nos>=1) && (cha>=1))
				{
					passwordOK = true;
				}
				
				if(!passwordOK){
					return false;
				}
				if(password.equals(null)){
					return false;
				}
				else if(password.length() == 0){
					return false;
				}
			}
		}
		catch(Exception e)
		{
			throw new DALException("passwordet lever ikke op til standarden");
		}
		return passwordOK;
		
	}
	
}