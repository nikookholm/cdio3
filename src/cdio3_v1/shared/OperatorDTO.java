package cdio3_v1.shared;
public class OperatorDTO{
	
	private int oprId;                     
	private String oprName;
	private String ini;                 
	private String cpr;                 
	private String password;

	//alle informationer om operatør findes her.

	public OperatorDTO(int oprId, String oprName, String ini, String cpr, String password) 
	{
		super();
		this.oprId = oprId;
		this.oprName  = oprName;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
	}

	public int getID()
	{
		return oprId;
	}

	public void setID(int oprID)
	{
		this.oprId = oprID;
	}
	
	public String getName()
	{
		return oprName;
	}

	public void setName(String oprName)
	{
		this.oprName = oprName;
	}
	
	public String getIni() 
	{
		return ini;
	}

	public void setIni(String ini)
	{
		this.ini = ini;
	}
	
	public String getCpr() 
	{
		return cpr;
	}

	public void setCpr(String cpr)
	{
		this.cpr = cpr;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword()
	{
		this.password = password;
	}
	public String toString()
	{
		return oprId + "\t" + oprName + "\t" + ini + "\t" + cpr ;
	}
}
