package cdio3_v1.shared;

import java.io.Serializable;

public class OperatorDTO implements Serializable{
	
	private int oprId;                     
	private String oprName;
	private String ini;                 
	private String cpr;                 
	private String password;

	//alle informationer om operatør findes her.

	public OperatorDTO(){}
	
	public OperatorDTO(int oprId, String oprName, String ini, String cpr, String password) 
	{
		super();
		this.oprId = oprId;
		this.oprName  = oprName;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
	}

	public OperatorDTO(OperatorDTO opr) //konstruktøren som sender alle variablerne med 
	    {
	    	super();
			this.oprId = opr.getID();
	    	this.oprName = opr.getName();
	    	this.ini = opr.getIni();
	    	this.cpr = opr.getCpr();
	    	this.password = opr.getPassword();
	    }
	public int getID()
	{
		return oprId;
	}

	public void setID(int oprId)
	{
		this.oprId = oprId;
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
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String toString()
	{
		return oprId + "\t" + oprName + "\t" + ini + "\t" + cpr ;
	}
}
