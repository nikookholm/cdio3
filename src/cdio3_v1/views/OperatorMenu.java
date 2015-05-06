package cdio3_v1.views;

import cdio3_v1.client.Main;
import cdio3_v1.client.controller.MainController;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class OperatorMenu extends Composite{

	VerticalPanel vPanel;


	
	public OperatorMenu(final MainController mc){
		vPanel = new VerticalPanel();
		initWidget(vPanel);
		Anchor anc = new Anchor("123");
		vPanel.add(anc);
		anc.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				mc.clear();
				
			}
		});
		


		}

	}
