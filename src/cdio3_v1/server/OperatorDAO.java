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
			
			String password = generateNewPassword();
			operators.add(new OperatorDTO(id, oprName, ini, cpr, password));

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

	public String generateNewPassword()
	{
		String password;
		//Opretter et array og giver det værdierne som ligger imellem A og Z i ASCII rækken
		ArrayList<String> alpha = new ArrayList<String>(26);
		for (char c='A'; c<='Z' ; c++)
		{
			alpha.add(String.valueOf(c));
		}

		//Tilsvarende for a-z
		ArrayList<String> beta = new ArrayList<String>(26);
		for (char c='a'; c<='z' ; c++)
		{
			beta.add(String.valueOf(c));
		}

		//Og tal
		ArrayList<String> num = new ArrayList<String>();
		for (char c='0'; c<='9' ; c++)
		{
			num.add(String.valueOf(c));
		}

		//Laver en ny arrayList, og der udplukkes et tilfældigt antal af tilfældige bogstaver
		Random rAlpha = new Random();
		int noOfAlphas = 2 + rAlpha.nextInt(5); //Det antal som skal udplukkes
		ArrayList<String> alphaSeq = new ArrayList<String>(); //ArrayList til at gemme dem i
		for(int i=0 ; i<noOfAlphas ; i++)
		{
			Random r = new Random();
			alphaSeq.add(alpha.get(r.nextInt(alpha.size()))); //Og her vælges hvilke det skal være
		}
		//En ny arrayList hvor det endelige resultat bliver gemt
		ArrayList<String> psswrd = new ArrayList<String>();
		psswrd.addAll(alphaSeq);

		//Små bogstaver udvælges
		Random rBeta = new Random();
		int noOfBetas = 2 + rBeta.nextInt(5);
		ArrayList<String> betaSeq = new ArrayList<String>();
		for(int i=0 ; i<noOfBetas ; i++)
		{
			Random r = new Random();
			betaSeq.add(beta.get(r.nextInt(beta.size())));
		}
		//De små bogstaver tilføjes til passwordet
		psswrd.addAll(betaSeq);

		//Tal udvælges
		Random rNum = new Random();
		int noOfNums = 2 + rNum.nextInt(5);
		ArrayList<String> numSeq = new ArrayList<String>();
		for(int i=0 ; i<noOfNums ; i++)
		{
			Random r = new Random();
			numSeq.add(num.get(r.nextInt(num.size())));
		}
		//Tal tilføjes passwordet
		psswrd.addAll(numSeq);
		Collections.shuffle(psswrd); //En metode som roder alle værdierne rundt

		//ArrayListen bliver lavet til en String
		StringBuilder sb = new StringBuilder();
		for(String s : psswrd)
		{
			sb.append(s);
		}

		password = sb.toString();
		return password;
	}

	@Override
	public int getSize() throws DALException {
			return operators.size();
		}		
}
	
