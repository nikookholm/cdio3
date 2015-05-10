package cdio3_v1.views;



import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.server.WeightFunctions;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class WeightView  extends Composite{
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();

	Button tara, readWeight, sendMessage, RM20;

	public WeightView(final ClientSideImpl clientImpl){

		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(0);		

		Anchor showWeigthFunction= new Anchor ("Vægt funktioner: vælg og tryk ");
		vPanel.add(showWeigthFunction);

//******************************************tara knappen******************************************************
		tara = new Button("Tara");
		this.vPanel.add(tara);

		tara.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				try {
					clientImpl.service.tara(new AsyncCallback<Void>() {

						@Override
						public void onSuccess(Void result) {
							Window.alert("Person gemt i kartotek");
						}
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl!" + caught.getMessage());
						}				

					});
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
//##############################################################################################################

//******************************************VisInfo knappen***************************************************
		
		readWeight = new Button("VisInfo");
		this.vPanel.add(readWeight);

		readWeight.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				try {
					clientImpl.service.getWeight(new AsyncCallback<Double>() {

						public void onSuccess(Void result) {
							Window.alert("Person gemt i kartotek");
						}
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl!" + caught.getMessage());
						}
						@Override
						public void onSuccess(Double result) {
														
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
		this.vPanel.add(sendMessage);

		sendMessage.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				try {
					clientImpl.service.tara(new AsyncCallback<Void>() {

						@Override
						public void onSuccess(Void result) {
							Window.alert("Person gemt i kartotek");
						}
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl!" + caught.getMessage());
						}				

					});
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
//***********************************************RM20***********************************************************
		RM20= new Button("send besked for at få svar");
		this.vPanel.add(RM20);

		RM20.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				try {
					clientImpl.service.RM20(null, new AsyncCallback<String>() {

						public void onSuccess(Void result) {
							Window.alert("Person gemt i kartotek");
						}
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl!" + caught.getMessage());
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




