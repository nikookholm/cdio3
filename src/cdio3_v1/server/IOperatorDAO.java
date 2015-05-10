package cdio3_v1.server;


import java.util.ArrayList;

import cdio3_v1.shared.DALException;
import cdio3_v1.shared.OperatorDTO;

public interface IOperatorDAO {
	
	public void createOperator(OperatorDTO opr) throws DALException; 
	public void updateOperator(OperatorDTO opr) throws DALException;	
	public void deleteOperator(int oprId) throws DALException;
	public OperatorDTO getOperator(int oprId) throws DALException;
	public ArrayList<OperatorDTO>getOperatorList() throws DALException;
	
}
