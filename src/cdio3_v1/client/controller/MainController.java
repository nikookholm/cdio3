package cdio3_v1.client.controller;



import cdio3_v1.client.ClientSideImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.shared.OperatorDTO;
import cdio3_v1.views.AdminMenu;
import cdio3_v1.views.MainView;
import cdio3_v1.views.OperatorMenu;
import cdio3_v1.views.ViewAdapter;


public class MainController {
	ClientSideImpl     clientImpl;
	ViewAdapter 	   va;
	public MainView    mainView;
	public OperatorDTO LoggedInOperator;

	public MainController() {

		//		MenuView mv = new MenuView(this);
		//		RootPanel.get("nav").add(mv);

		//va = new ViewAdapter(clientImpl);
		
		mainView = new MainView(this);
		RootPanel.get().add(mainView);

//		RootPanel.get("section").add(va);
		//RootPanel.get("section").add(mainView);
	}

	public void run() {
		va.loadLogin();	

	}
}

//	public void loadOperatorMenu(){
//		//RootPanel.get("nav").clear();
//		//AdminMenu om = new AdminMenu();
//		//RootPanel.get("nav").add(om);
//		//RootPanel.get("section").clear();
//
//	}

//	public void loadWeightView(){
//		RootPanel.get("section").clear();
//		va.loadWeightView();
//		RootPanel.get("section").add(va);
//
//	}
//	public void loadReadView() throws Exception{
//		RootPanel.get("section").clear();
//		va.loadReadView();
//		RootPanel.get("section").add(va);
//	}
//
//	public void loadCreateView(){
//		RootPanel.get("section").clear();
//		va.loadCreateView();
//		RootPanel.get("section").add(va);
//	}
//
//	public void loadUpdateView(){
//		RootPanel.get("section").clear();
//		va.loadUpdateView();
//		RootPanel.get("section").add(va);
//	}
//
//	public void loadDeleteView(){
//		RootPanel.get("section").clear();
//		va.loadDeleteView();
//		RootPanel.get("section").add(va);
//
//	}
//}

