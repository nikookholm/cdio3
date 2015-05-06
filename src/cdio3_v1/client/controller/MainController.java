package cdio3_v1.client.controller;



import cdio3_v1.client.ClientSideImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.views.MenuView;
import cdio3_v1.views.OperatorMenu;
import cdio3_v1.views.ViewAdapter;


public class MainController {
	ClientSideImpl clientImpl;
	ViewAdapter va;


	public MainController() {


		clientImpl = new ClientSideImpl(GWT.getModuleBaseURL() + "greet");


	
//		MenuView mv = new MenuView(this);
//		RootPanel.get("nav").add(mv);


		va = new ViewAdapter(clientImpl);
		RootPanel.get("section").add(va);	
	}

	public void run() {
	    va.loadLogin();	

	}
	
	public void loadOperatorMenu(){
		RootPanel.get("nav").clear();
		OperatorMenu om = new OperatorMenu(this);
		RootPanel.get("nav").add(om);
	}

}

