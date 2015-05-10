package cdio3_v1.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3_v1.shared.OperatorDTO;
import cdio3_v1.views.OperatorMenu;
import cdio3_v1.client.controller.MainController;

public class AdminMenu extends Composite{
	private VerticalPanel vPanel;
	private MainController mc;
	//private OperatorMenu om;

	// receive reference to MainView for call back
	public AdminMenu(final MainController mc) {

		this.mc = mc;
		vPanel = new VerticalPanel();
		initWidget(this.vPanel);
		
		show();
	}
	
	public void showNormalFunctions()
	{
		//om = new OperatorMenu(mc);
		//vPanel.add(om);

		Anchor create = new Anchor("Opret Operat\u00f8r");
		vPanel.add(create);
		// call back the controller
		create.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
				//	mc.loadCreateView();
			}
		});

		// use unicode escape sequence \u00F8 for '�'
		Anchor read = new Anchor("List Operat\u00f8rer");
		vPanel.add(read);
		read.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
				//mc.loadReadView();
			}
		});

		Anchor update = new Anchor("Opdater Operat\u00f8r");
		vPanel.add(update);
		update.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
	//			mc.loadUpdateView();
			}
		});

		Anchor delete = new Anchor("Slet Operat\u00f8rer");
		vPanel.add(delete);
		delete.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
				//mc.loadDeleteView();
			}
		});		
	}
	
	private void showAdminFunctions(OperatorDTO opr)
	{
		
	}
	
	public void show()
	{
		vPanel.clear();
		showAdminFunctions(mc.LoggedInOperator);
		showNormalFunctions();
	}
	
}
