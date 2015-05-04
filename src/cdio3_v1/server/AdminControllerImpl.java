package cdio3_v1.server;

import cdio3_v1.client.AdminController;
import cdio3_v1.shared.*;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class AdminControllerImpl extends RemoteServiceServlet implements AdminController{
	
	IOperatorDAO iOpr;
	OperatorDTO opr;
	
	//
	private void showCreate() throws Exception{	
		
	}
	
	//
	private void showRead(List<OperatorDTO> lsO) throws Exception{
		
	}
	
	//
	private void showUpdate(OperatorDTO opr) throws Exception{
		
	}
	
	//
	private void showDelete(OperatorDTO opr) throws Exception{
		
	}
	
	
	//check for om den ønskede bruger indeholder de rigtige informationer
	//hvis den fejler skal der raises en ecxeption
	//hvis korrekt sendes videre sendes videre til databasen
	private void create(OperatorDTO opr) throws Exception{	
//		iOpr.createOperator(oprName, ini, cpr);
		
		int id 		= opr.getID();
		String name = opr.getName();
		String ini 	= opr.getIni();
		String cpr 	= opr.getCpr();
		String pswd = opr.getPassword();
		boolean cnd = true;
		
		if( ((id>=2) && (id<=99999999)) == false ){
			throw new IllegalArgumentException("OperatorID must be between 2 and 99999999!");
			cnd = false;
		}
		
		if( ((name.length()>=2) && (name.length()<=20)) == false ){
			throw new IllegalArgumentException("OperatorName must be between 2 and 20 characters of length!");
			cnd = false;
		}
		
		if( ((ini.length()>=2) && (ini.length()<=3)) == false ){
			throw new IllegalArgumentException("OperatorInitials must be between 2 and 3 characters of length!");
			cnd = false;
		}
		
		if( (cpr.length()==10) == false ){
			throw new IllegalArgumentException("OperatorCPRnr must be 10 characters of length!");
			cnd = false;
		}
		
		if( ((pswd.length()>=7) && (pswd.length()<=8)) == false ){
			throw new IllegalArgumentException("OperatorPassword must be between 7 and 8 characters of length!");
			cnd = false;
		}
		
		if(cnd == true){
			
		}
		
		
	}
	
	//
	private void update(OperatorDTO oprD) throws Exception{
		
	}
	
	//
	private void delete(int ID) throws Exception{
		
	}
	
	//
	private boolean login(loginData lgD) throws Exception{
		
	}
}
