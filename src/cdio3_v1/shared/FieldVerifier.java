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
	public static boolean isValidID(String oprId) {
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
	
	public static boolean newIdIsValid(int oprId)
	{
		return ((oprId > 0) && (oprId < 100000000));	
	
	}
	
	public static boolean checkCprID(String cpr) 
	{ 

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
			return false;
		}

	}
	
	public static boolean isPasswordValid(String pw){
		if(pw.equals(null)){
			return false;
		}
		else if(pw.length() == 0){
			return false;
		}
		return pw.length() >= 6;
	}
	
}
