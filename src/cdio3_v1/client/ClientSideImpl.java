package cdio3_v1.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import cdio3_v1.client.AdminControllerAsync;;;

public class ClientSideImpl {

	public AdminControllerAsync service;
	
	public ClientSideImpl(String url){
		this.service = GWT.create(AdminController.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
	}
}
