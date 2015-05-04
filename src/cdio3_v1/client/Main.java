package cdio3_v1.client;


import cdio3_v1.client.controller.MainView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {


	public void onModuleLoad() {

	new MainView().run();
	}
	
	
}
