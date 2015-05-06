package cdio3_v1.views;

import cdio3_v1.client.ClientSideImpl;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import cdio3_v1.*;


public class ViewAdapter extends Composite {

	private ClientSideImpl clientImpl;
	VerticalPanel adapterPanel;



	public ViewAdapter(ClientSideImpl clientImpl) {
		this.clientImpl = clientImpl;
		adapterPanel = new VerticalPanel();
		initWidget(this.adapterPanel);
	}

	public void loadLogin(){
		adapterPanel.clear();
		LoginView login = new LoginView(clientImpl);
		adapterPanel.add(login);
	}
	
	public void clear(){
		adapterPanel.clear();
	}
}
