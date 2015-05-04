package cdio3_v1.server;
import cdio3_v1.server.IOperatorDAO;
import cdio3_v1.server.IOperatorDAO.DALException;
import cdio3_v1.shared.*;

import java.util.*;
import java.io.*;

public class OperatorDAO implements IOperatorDAO {

	private ArrayList<OperatorDTO> operators = new ArrayList<OperatorDTO>();
	
	@Override
	public OperatorDTO createOperator(String oprName, String ini, String cpr) throws DALException {
		int id = 0;
		boolean idAvaliable;
		for (int i = 99999999 ; i>1 ; i--){
			idAvaliable = true;
			for(OperatorDTO operator : operators){
				if(operator.getID() == i){
					idAvaliable = false;
				}
			}
			if (idAvaliable == true){
				id = i;

			}
		}
		if (id== 0) {
			throw new DALException("Der findes ikke flere id'er");
		}
		if (!checkCprID(cpr)){
			throw new DALException("Cpr nummeret skal indeholde 10 cifre, \"-\" er valgfrit");
		}
		else if(oprName.length() > 20){
			throw new DALException("Det indtastede operatørnavn indeholder over 20 tegn");
		}
		else{
			String cprFirstPart = cpr.substring(0,6);
			String cprSecdondPart = cpr.substring(6);
			if (cpr.charAt(6) != '-')
			{
				cpr = cprFirstPart + "-" + cprSecdondPart;
			}
			
			//String password = generateNewPassword();
			//operators.add(new OperatorDTO(id, oprName, ini, cpr, password));

			OperatorDTO result = null;
			for (OperatorDTO operator : operators)
			{
				if (operator.getID() == id)
				{
					result = operator;
				}
			}
			return result;
		}
	}

	@Override
	public OperatorDTO getOperator(int id, String password) throws DALException {
		OperatorDTO getOperator = null;
		for (int i = 0; i < operators.size(); i++)
		{
			if ((operators.get(i).getID() == id) && (operators.get(i).getPassword().equals(password)))
			{
				getOperator = operators.get(i);
			}
		}

		if (getOperator == null)
		{
			throw new DALException("Operatøren findes ikke!");
		} else
			return getOperator;
	}

	@Override
	public ArrayList<OperatorDTO> getOperatorList() {
		return operators;
	}

	@Override
	public void updateOperator(OperatorDTO operator, String newPassword) throws DALException {
		boolean passwordOK = false;

		if(newPassword.length()>=6)
		{
			int smalls = 0;
			int bigs = 0;
			int nos = 0;
			for(int i=0 ; i<newPassword.length() ; i++)
			{
				if(newPassword.charAt(i)>='A' && newPassword.charAt(i)<='Z'){
					bigs ++;
				}
				if(newPassword.charAt(i)>='a' && newPassword.charAt(i)<='z'){
					smalls ++;
				}
				if(newPassword.charAt(i)>='0' && newPassword.charAt(i)<='9'){
					nos ++;
				}
			}

			if((bigs>=1) && (smalls>=1) && (nos>=1))
			{
				passwordOK = true;

				OperatorDTO newOperator = new OperatorDTO(operator.getID(), operator.getName(), operator.getIni(), operator.getCpr(), newPassword);
				operators.remove(operators.indexOf(operator));
				operators.add(newOperator);
			}
		}

		if(!passwordOK){
			throw new DALException("Dit kodeord lever ikke op til de givne standarder.");
		}	
	}

	@Override
	public boolean deleteOperator(int oprID) throws DALException {
		OperatorDTO deleteOperator = null;
		for (OperatorDTO operator : operators)
		{
			if ((operator.getID() == oprID))
			{
				deleteOperator = operator;
			}
		}

		if (deleteOperator == null)
		{
			throw new DALException("Ugyldigt operatør ID");
		}
		else
		{
			operators.remove(deleteOperator);
		}

		return (deleteOperator != null);
	}

	private boolean checkCprID(String cpr) 
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

	
}
