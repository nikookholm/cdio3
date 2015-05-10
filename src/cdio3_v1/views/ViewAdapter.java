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
//		LoginView login = new LoginView(clientImpl);
	//	adapterPanel.add(login);
	}

	public void clear(){
		adapterPanel.clear();
	}

	public void loadWeightView(){
		adapterPanel.clear();
		WeightView weight= new WeightView();
		adapterPanel.add(weight);
	}

	public void loadDeleteView(){
		adapterPanel.clear();
		//	deleteView dv = new deleteView(clientImpl, opr) // der skal findes en løsning på opr
		//adapterPanel.add(dv);
	}

	public void loadReadView() throws Exception{
		adapterPanel.clear();
	//	readView rv = new readView(clientImpl);
	//	adapterPanel.add(rv);

	}

	public void loadUpdateView(){
		adapterPanel.clear();
		// updateView uv = new updateView(); // Der skal tilføjes clientImpl 
	//	adapterPanel.add(uv);
	}

	public void loadCreateView(){
		adapterPanel.clear();
	//	CreateView dv = new CreateView(clientImpl); // Der skal tilføjes clientImpl 
	//	adapterPanel.add(dv);
	}

}
