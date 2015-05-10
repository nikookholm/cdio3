package cdio3_v1.views;



import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.server.WeightFunctions;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;


public class WeightView  extends Composite{
	private VerticalPanel vPanel       = new VerticalPanel();
	private HorizontalPanel hPanel     = new HorizontalPanel();
	private HorizontalPanel contentPanel = new HorizontalPanel();

	Button tara, readWeight, sendMessage, RM20;
	Label  visInfoText;
	TextBox taraInfo;
	TextBox sendBesked, RM20Besked; 

	public WeightView(final ClientSideImpl clientImpl){

		initWidget(this.hPanel);
		this.hPanel.setBorderWidth(1);
		this.hPanel.add(vPanel);
		this.vPanel.add(contentPanel);
	
//******************************************tara knappen******************************************************
		tara = new Button("Tara");
		this.hPanel.add(tara);

		tara.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				hPanel.clear();
			    hPanel.add(vPanel);
				hPanel.add(contentPanel);
				
				
				
				try {
					clientImpl.service.tara(new AsyncCallback<Void>() {

						@Override
						public void onSuccess(Void result) {
							taraInfo = new TextBox();
							
					
						}
						@Override
						public void onFailure(Throwable caught) {
						}				

					});
				} catch (Exception e) {
					e.printStackTrace();
				}
				contentPanel.add(taraInfo);

			}
		});
//##############################################################################################################

//******************************************VisInfo knappen***************************************************
		
		readWeight = new Button("Vis Info");
		this.hPanel.add(readWeight);
		
		
		readWeight.addClickHandler(new ClickHandler(){
			
			public void onClick(ClickEvent event){
				vPanel.clear();
				vPanel.add(visInfoText);
				
				visInfoText = new Label();
				
				
				try {
					clientImpl.service.getWeight(new AsyncCallback<Double>() {
						
						@Override
						public void onSuccess(Double result) {
							visInfoText.setText(result + "");
														
						}				
						
						@Override
						public void onFailure(Throwable caught) {
//							Window.alert("Server fejl!" + caught.getMessage());
						}
						
					});
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

//############################################################################################################

//**************************************************send besked***********************************************
		
		sendMessage = new Button("sendBesked");
		this.hPanel.add(sendMessage);

		sendMessage.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				vPanel.clear();
				vPanel.add(sendBesked);
				
				try {
					clientImpl.service.tara(new AsyncCallback<Void>() {

						@Override
						public void onSuccess(Void result) {
//							Window.alert("Person gemt i kartotek");
						}
						@Override
						public void onFailure(Throwable caught) {
//							Window.alert("Server fejl!" + caught.getMessage());
						}				

					});
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
//***********************************************RM20***********************************************************
		RM20= new Button("send besked for at få svar");
		this.hPanel.add(RM20);

		RM20.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				vPanel.clear();
				vPanel.add(RM20Besked);
				try {
					clientImpl.service.RM20(null, new AsyncCallback<String>() {

						public void onSuccess(Void result) {
//							Window.alert("Person gemt i kartotek");
						}
						@Override
						public void onFailure(Throwable caught) {
//							Window.alert("Server fejl!" + caught.getMessage());
						}
						@Override
						public void onSuccess(String result) {
							// TODO Auto-generated method stub
							
						}				

					});
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
//##############################################################################################################
		
	}
	
	
}




