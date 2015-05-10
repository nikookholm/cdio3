package cdio3_v1.server;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cdio3_v1.shared.DALException;
import cdio3_v1.shared.FieldVerifier;
import cdio3_v1.shared.OperatorDTO;
import cdio3_v1.server.Connector;
import cdio3_v1.server.IOperatorDAO;

import java.sql.ResultSet;


public class OperatorDAO implements IOperatorDAO {
	
	public void createOperator(OperatorDTO opr) throws DALException {
		int newId = 0;
		ResultSet rs = Connector.doQuery("SELECT * FROM operator ORDER BY opr_id LIMIT 1");
		try {
			if(rs.first() == false)
			{
				newId = rs.getInt("opr_id")+1;
			}
		} 
		catch (SQLException e) 
		{
			throw new DALException("SQL-fejl: "+e.getMessage());
		}
		
		String newPassword = generateNewPassword();
		
		//sendt fra view
		if((FieldVerifier.isNewIdValid(newId)) && 
		   (FieldVerifier.isNameValid(opr.getName())) && 
		   (FieldVerifier.isIniValid(opr.getIni())) && 
		   (FieldVerifier.isCprValid(opr.getCpr())) && 
		   (FieldVerifier.isPasswordValid(newPassword)))
		{
		Connector.doUpdate(
				"INSERT INTO operator(opr_id, opr_name, ini, cpr, password) VALUES " + 
				"(" + newId + ", '" + opr.getName() + "', '" + opr.getIni() + "', '" + 
				opr.getCpr() + "', '" + newPassword + "')"
			);
		}
		
	}

	@Override
	public void updateOperator(OperatorDTO opr) throws DALException {
		
		//Sendt fra view
		if((FieldVerifier.isNewIdValid(opr.getID())) && 
		   (FieldVerifier.isNameValid(opr.getName())) && 
		   (FieldVerifier.isIniValid(opr.getIni())) && 
		   (FieldVerifier.isCprValid(opr.getCpr())) && 
		   (FieldVerifier.isPasswordValid(opr.getPassword())))
		{
		Connector.doUpdate(
				"UPDATE operator SET  opr_name = '" + opr.getName() + "', ini =  '" + opr.getIni() + 
				"', cpr = '" + opr.getCpr() + "', password = '" + opr.getPassword() + "' WHERE opr_id = " +
				opr.getID());
		
		}
	
	}
	
	@Override
	public boolean deleteOperator(int oprId) throws DALException {	
		Connector.doUpdate(
				"DELETE FROM operator WHERE id =  '" + oprId);
		return true;
	}
	
	@Override
	public OperatorDTO getOperator(int oprId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM operator WHERE opr_id = " + oprId);
	    try {
	    	if (!rs.first()) throw new DALException("Operator " + oprId + " was not found");
	    	return new OperatorDTO (rs.getInt("opr_id"), rs.getString("opr_name"), 
	    							rs.getString("ini"), rs.getString("cpr"), rs.getString("password"));
	    }
	    catch (SQLException e) 
	    {
	    	throw new DALException(e); 
	    }
		
	}
	
	@Override
	public ArrayList<OperatorDTO> getOperatorList() throws DALException {
		ArrayList<OperatorDTO> list = new ArrayList<OperatorDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM operator");
		try
		{
			while (rs.next()) 
			{
				list.add(new OperatorDTO(rs.getInt("opr_id"), rs.getString("opr_name"), 
										 rs.getString("ini"), rs.getString("cpr"), rs.getString("password")));
			}
		}
		catch (SQLException e) { 
			throw new DALException(e); 
		}
		return list;
	}
	
	//Metoden, der genererer et password ud fra DTU's krav.
	static String generateNewPassword()
	{
		String password;

		ArrayList<String> alpha = new ArrayList<String>(26);
		for (char c='A'; c<='Z' ; c++){
			alpha.add(String.valueOf(c));
		}

		ArrayList<String> beta = new ArrayList<String>(26);
		for (char c='a'; c<='z' ; c++){
			beta.add(String.valueOf(c));
		}

		ArrayList<String> num = new ArrayList<String>();
		for (char c='0'; c<='9' ; c++){
			num.add(String.valueOf(c));
		}

		int noOfAlphas = 2;
		ArrayList<String> alphaSeq = new ArrayList<String>();
		for(int i=0 ; i<noOfAlphas ; i++){
			Random r = new Random();
			alphaSeq.add(alpha.get(r.nextInt(alpha.size())));
		}
		ArrayList<String> psswrd = new ArrayList<String>();
		psswrd.addAll(alphaSeq);

		int noOfBetas = 2;
		ArrayList<String> betaSeq = new ArrayList<String>();
		for(int i=0 ; i<noOfBetas ; i++){
			Random r = new Random();
			betaSeq.add(beta.get(r.nextInt(beta.size())));
		}
		psswrd.addAll(betaSeq);

		int noOfNums = 2;
		ArrayList<String> numSeq = new ArrayList<String>();
		for(int i=0 ; i<noOfNums ; i++){
			Random r = new Random();
			numSeq.add(num.get(r.nextInt(num.size())));
		}
		psswrd.addAll(numSeq);
		
		String spec = ".-_+!?=";
		ArrayList<String> specSeq = new ArrayList<String>();
		Random r = new Random();
		int specRan = r.nextInt(6);
		specSeq.add(spec.substring(specRan, specRan+1));
		
		psswrd.addAll(specSeq);
		
		Collections.shuffle(psswrd);

		StringBuilder sb = new StringBuilder();
		for(String s : psswrd){
			sb.append(s);
		}

		password = sb.toString();
		return password;
	}
	
}
