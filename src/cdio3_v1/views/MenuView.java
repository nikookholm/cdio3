package cdio3_v1.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import cdio3_v1.client.controller.MainController;

public class MenuView extends Composite {
	private VerticalPanel vPanel; 

	// receive reference to MainView for call back
	public MenuView(final MainController mc) {
		vPanel = new VerticalPanel();
		initWidget(this.vPanel);

		Anchor test1 = new Anchor("test1");
		vPanel.add(test1);
		// call back the controller
		test1.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
			
			}
		});

		// use unicode escape sequence \u00F8 for '�'
		Anchor test2 = new Anchor("test2");
		vPanel.add(test2);
		test2.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
				
			}
		});

		Anchor test3 = new Anchor("test3");
		vPanel.add(test3);
		test3.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){				
			
			}
		});

	
		
	}
}
