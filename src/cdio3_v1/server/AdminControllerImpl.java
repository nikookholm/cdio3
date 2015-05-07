package cdio3_v1.server;

import cdio3_v1.client.AdminController;
import cdio3_v1.shared.*;
import cdio3_v1.views.*;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class AdminControllerImpl extends RemoteServiceServlet implements AdminController{

	private void create(OperatorDTO opr) throws Exception{	
		
		OperatorDAO db;
		db.createOperator(opr);
	}

	private void update(OperatorDTO opr) throws Exception{
		
		OperatorDAO db;
		db.createOperator(opr);
	}

	private void delete(int ID) throws Exception{
		
		boolean cond;
		OperatorDTO opr;
		OperatorDAO db;
		int id = opr.getID();
		
		cond = db.deleteOperator(id);
		
		if(cond == false){
			ErrorView();
		}
	}

	private boolean login(String idAndPswd) throws Exception{
		
		boolean cond = false;
		OperatorDAO db;
		
		int id = Integer.parseInt(idAndPswd.substring(0, idAndPswd.indexOf(","))); 
		String pswd = idAndPswd.substring(idAndPswd.indexOf(",")+1);		
		
		OperatorDTO opr = db.getOperator(id);
		
		if(pswd == opr.getPassword()){
			cond = true;
		}
		
		return cond;
	}

	public List<OperatorDTO> read(){
		
		OperatorDAO db;
		List<OperatorDTO> ls = db.getOperatorList();
		
		return ls;
	}

	public WeightFunctions getWeight(){
		
		WeightFunctions weight;
		
		return weight;
	}

}
