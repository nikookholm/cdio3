package cdio3_v1.client;


import cdio3_v1.client.controller.MainController;


import com.google.gwt.core.client.EntryPoint;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint {


	public void onModuleLoad() {

		new MainController();
	}
	
	
}
