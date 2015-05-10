package cdio3_v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cdio3_v1.shared.*;
import cdio3_v1.server.*;
import cdio3_v1.client.*;
import cdio3_v1.client.controller.*;
import cdio3_v1.views.*;

public class TestOperatorDAO {
	
	IOperatorDAO opDao  = new OperatorDAO();
	
	@Before
	public void connect()
	{
		try {
			new Connector();
		} catch (Exception e) {
		
		}
	}
	
	@Test
	public void testCreateOperator() throws DALException
	{
		ArrayList<OperatorDTO> list = opDao.getOperatorList();
		int currentHighestID  = list.get(list.size()-1).getID();
		
		int expected = opDao.getOperatorList().size()+1;
		opDao.createOperator(new OperatorDTO(currentHighestID, "Hans Hansen", "HH", "010101-1111", "AaBb12?"));
		int actual =  opDao.getOperatorList().size();
			
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetOperator() throws DALException
	{
		OperatorDTO testOperator = null;
		List<OperatorDTO> operatorList = opDao.getOperatorList();
		int ID = operatorList.get(0).getID();
		testOperator = opDao.getOperator(ID);

		OperatorDTO actual = testOperator;
		OperatorDTO expected = operatorList.get(0);

		boolean theSame = true;
		
		if (actual.getID() 	!= expected.getID()) 	   				theSame = false;
		if (!actual.getName().equals(expected.getName())) 			theSame = false;
		if (!actual.getCpr().equals(expected.getCpr())) 			theSame = false;
		if (!actual.getIni().equals(expected.getIni())) 			theSame = false;
		if (!actual.getPassword().equals(expected.getPassword())) 	theSame = false;

		assertTrue(theSame);
	}
	
	@Test
	public void testGetOperatorList() throws DALException
	{
		List<OperatorDTO> list = opDao.getOperatorList();
		
		assertTrue(list.size()>1);
	}
	
	@Test
	public void updateOperator() throws DALException {
		OperatorDTO opDto = null;
		String expected = "Jens Jensen";
		
		try {
			opDto = opDao.getOperatorList().get(0);
			opDto.setName(expected);
			opDao.updateOperator(opDto);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = opDto.getName();
		assertEquals(expected, actual);
	}

}
