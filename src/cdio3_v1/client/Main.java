package cdio3_v1.client;


import cdio3_v1.views.LoginView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {


	public void onModuleLoad() {

		LoginView lv = new LoginView();
		
		Label lb = new Label("123");
		RootPanel.get().add(lv);
	}
	
	
}
