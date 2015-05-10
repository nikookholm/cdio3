package cdio3_v1.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3_v1.shared.DALException;
import cdio3_v1.shared.OperatorDTO;
import cdio3_v1.views.OperatorMenu;
import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.client.controller.MainController;

public class AdminMenu extends Composite{
	private VerticalPanel vPanel;
	private MainController mc;
	private ClientSideImpl clientImpl = new ClientSideImpl(GWT.getModuleBaseURL() + "greet");
	//private OperatorMenu om;

	// receive reference to MainView for call back
	public AdminMenu(final MainController mc) {

		this.mc = mc;
		vPanel = new VerticalPanel();
		initWidget(this.vPanel);
		
		show();
	}
	
	public void showOperatorFunctions(OperatorDTO opr)
	{

//		if (opr.getID() == 10)
//		{
	
			Anchor create = new Anchor("Opret Operat\u00f8r");
			vPanel.add(create);
			// call back the controller
			create.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event){				
				//mc.loadCreateView();
				}
			});
	
			// use unicode escape sequence \u00F8 for '�'
			Anchor read = new Anchor("List Operat\u00f8rer");
			vPanel.add(read);
			read.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event){				
					try {
						mc.mainView.show(new ReadView(clientImpl));
					} catch (DALException e) {}
				}
			});
	
			Anchor delete = new Anchor("Slet Operat\u00f8rer");
			vPanel.add(delete);
			delete.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event){				
					//mc.loadDeleteView();
				}
			});
			
//		}
		
		Anchor update = new Anchor("Opdater Operat\u00f8r");
		vPanel.add(update);
		update.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
	//			mc.loadUpdateView();
			}
		});
	}
	
	private void showWeightFunctions()
	{
		
		Anchor useWeight = new Anchor("Benyt Vægten");
		vPanel.add(useWeight);
		useWeight.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				mc.mainView.show(new WeightView(clientImpl));
				
			}
		});
		
		Anchor changePassword = new Anchor("Ændr Password");
		vPanel.add(changePassword);
		changePassword.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//Label lb = new Label("Der skal laves en Operatør update!!!!");
				//lb.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
				//vPanel.add(lb);
				//mc.loadUpdateView(); 
				
			}
		});
		Anchor logOut = new Anchor("Log ud");
		vPanel.add(logOut);
		logOut.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				
			}
		});

	}
	
	public void show()
	{
		vPanel.clear();
		showWeightFunctions();
		showOperatorFunctions(mc.LoggedInOperator);
	}
	
}
