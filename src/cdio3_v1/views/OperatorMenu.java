package cdio3_v1.views;

import cdio3_v1.client.Main;
import cdio3_v1.client.controller.MainController;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class OperatorMenu extends Composite{

	VerticalPanel vPanel;


	/*
	 * use weight, log out, change password, 
	 */
	
	public OperatorMenu(final MainController mc){
		vPanel = new VerticalPanel();
		initWidget(vPanel);
		
		Anchor useWeight = new Anchor("Benyt Vægten");
		vPanel.add(useWeight);
		useWeight.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				mc.loadWeightView();
				
			}
		});
		
		Anchor changePassword = new Anchor("Ændr Password");
		vPanel.add(changePassword);
		changePassword.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Label lb = new Label("Der skal laves en Operatør update!!!!");
				lb.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
				vPanel.add(lb);
				mc.loadUpdateView(); 
				
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

	}
