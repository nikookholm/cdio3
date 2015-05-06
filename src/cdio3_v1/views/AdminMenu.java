package cdio3_v1.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3_v1.client.controller.MainController;

public class AdminMenu extends OperatorMenu {
	private VerticalPanel vPanel; 

	// receive reference to MainView for call back
	public AdminMenu(final MainController mc) {
		super(mc);
		vPanel = new VerticalPanel();
		initWidget(this.vPanel);

		Anchor create = new Anchor("Opret operat\u00f8r");
		vPanel.add(create);
		// call back the controller
		create.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
			
			}
		});

		// use unicode escape sequence \u00F8 for '�'
		Anchor read = new Anchor("List operat\u00f8rer");
		vPanel.add(read);
		read.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
				
			}
		});

		Anchor update = new Anchor("Opdater operat\u00f8");
		vPanel.add(update);
		update.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
			
			}
		});

		Anchor delete = new Anchor("Slet Operat\u00f8rer");
		vPanel.add(delete);
		delete.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
			
			}
		});
		
	}
}
