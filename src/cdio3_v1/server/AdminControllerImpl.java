package cdio3_v1.server;

import cdio3_v1.client.AdminController;
import cdio3_v1.shared.*;
import cdio3_v1.views.*;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class AdminControllerImpl extends RemoteServiceServlet implements AdminController{
	
	WeightFunctions weight;
	OperatorDAO db;
	OperatorDTO opr;
	
	public void create(OperatorDTO opr) throws Exception{	
		
		db.createOperator(opr);
	}

	public void update(OperatorDTO opr) throws Exception{
		
		db.createOperator(opr);
	}

	public void delete(int ID) throws Exception{
		
		boolean cond;
		int id = opr.getID();
		
		cond = db.deleteOperator(id);
		
		if(cond == false){
			throw new DALException("Det lykkedes ikke at slette operatøren.");
		}
	}

	public boolean login(String idAndPswd) throws Exception{
		
		boolean cond = false;
		
		int id = Integer.parseInt(idAndPswd.substring(0, idAndPswd.indexOf(","))); 
		String pswd = idAndPswd.substring(idAndPswd.indexOf(",")+1);		
		
		opr = db.getOperator(id);
		
		if(pswd == opr.getPassword()){
			cond = true;
		}
		
		return cond;
	}

	public List<OperatorDTO> read() throws DALException{
		
		List<OperatorDTO> ls = db.getOperatorList();
		
		return ls;
	}

	public void tara() throws Exception {
		weight.tara();
	}

	public String RM20(String msg) {
		
		return weight.sendRM20(msg);
	}

	public void display(String displayMsg) {
		
		weight.sendMessage(displayMsg);
	}

	public double getWeight() {
		
		return weight.getWeight();
	}

}
