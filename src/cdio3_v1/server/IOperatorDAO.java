package cdio3_v1.server;


import java.util.ArrayList;

import cdio3_v1.shared.OperatorDTO;

public interface IOperatorDAO {
	
	public OperatorDTO createOperator(String oprName, String ini, String cpr) throws DALException; 
	public OperatorDTO getOperator(int id, String password) throws DALException;
	public ArrayList<OperatorDTO>getOperatorList();
	public void updateOperator(OperatorDTO operator, String nwPsswrd) throws DALException;
	public boolean deleteOperator(int oprID) throws DALException;
	
	public class DALException extends Exception{	
		
		public DALException(String errorMsg){
			super(errorMsg + " (DAL)");			
		}
		
	}
}
