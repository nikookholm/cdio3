package cdio3_v1.server;

import cdio3_v1.client.AdminController;
import cdio3_v1.shared.*;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import divvie.OperatorDTO;

@SuppressWarnings("serial")
public class AdminControllerImpl extends RemoteServiceServlet implements AdminController{

	IOperatorDAO iOpr;
	OperatorDTO opr;

	private void showCreate() throws Exception{	
	}

	private void showRead(List<OperatorDTO> lsO) throws Exception{
	}

	private void showUpdate(OperatorDTO opr) throws Exception{
	}

	private void showDelete(OperatorDTO opr) throws Exception{
	}

	//check for om den ønskede bruger indeholder de rigtige informationer
	//hvis den fejler skal der raises en ecxeption
	//hvis korrekt sendes videre sendes videre til databasen
	private void create(OperatorDTO opr) throws Exception{	

		int id 		= opr.getID();
		String name = opr.getName();
		String ini 	= opr.getIni();
		String cpr 	= opr.getCpr();
		String pswd = opr.getPassword();
		boolean cnd = checkOperatorInfo(id, name, ini, cpr, pswd);

		if(cnd == true){
			OperatorDAO_db.createOperator(opr);
		}


	}

	private void update(OperatorDTO oprD) throws Exception{

	}

	private void delete(int ID) throws Exception{

	}

//	private boolean login(loginData lgD) throws Exception{
//	}

	private boolean checkOperatorInfo(int id, String name, String ini, String cpr, String pswd){
		boolean cond 	= true;
		int idC			= id;
		String nameC 	= name;
		String iniC 	= ini;
		String cprC 	= cpr;
		String pswdC 	= pswd;

		if( ((idC>=2) && (idC<=99999999)) == false ){
			throw new IllegalArgumentException("OperatorID must be between 2 and 99999999!");
			cond = false;
		}

		if( ((nameC.length()>=2) && (nameC.length()<=20)) == false ){
			throw new IllegalArgumentException("OperatorName must be between 2 and 20 characters of length!");
			cond = false;
		}

		if( ((iniC.length()>=2) && (iniC.length()<=3)) == false ){
			throw new IllegalArgumentException("OperatorInitials must be between 2 and 3 characters of length!");
			cond = false;
		}

		if( (cprC.length()==10) == false ){
			throw new IllegalArgumentException("OperatorCPRnr must be 10 characters of length!");
			cond = false;
		}

		if( ((pswdC.length()>=7) && (pswdC.length()<=8)) == false ){
			throw new IllegalArgumentException("OperatorPassword must be between 7 and 8 characters of length!");
			cond = false;
		}

		return cond;
	}

}
