package cdio3_v1.client.controller;

import cdio3_v1.client.ClientSideImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.views.MenuAdapter;
import cdio3_v1.views.ViewAdapter;


public class MainController extends Composite {
	ClientSideImpl clientImpl;
	ViewAdapter va;
	MenuAdapter m;

	public MainController() {


		clientImpl = new ClientSideImpl(GWT.getModuleBaseURL() + "greet");


		 m = new MenuAdapter(this);
		RootPanel.get().add(m);


		va = new ViewAdapter(clientImpl);
		RootPanel.get().add(va);	
	}

	public void run() {
		// show welcome panel
		va.loadLogin();	
		m.loadMenuView();
	}

}

