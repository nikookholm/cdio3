package cdio3_v1.views;

import cdio3_v1.client.ClientSideImpl;
import cdio3_v1.client.Main;
import cdio3_v1.client.controller.MainController;
import cdio3_v1.client.*;
import cdio3_v1.server.IOperatorDAO;
import cdio3_v1.server.OperatorDAO;
import cdio3_v1.shared.DALException;
import cdio3_v1.shared.FieldVerifier;
import cdio3_v1.shared.OperatorDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginView extends Composite {

	VerticalPanel vPanel;
	Label userLabel;
	Label passwordLabel;
	TextBox userBox;
	TextBox passwordBox;
	Button okBtn;
	ClientSideImpl clientImpl;
	MainController mc;

	// Flag der skal afgøre om ok knappen skal gøres tilgænglig
	boolean pwBox = false; 
	boolean uBox  = false;

	//midlertidig variabel til at kontrollere om views hænger sammen.
	//MainController mc = new MainController();

	public LoginView(final MainController mc){

		this.mc = mc;
		clientImpl  = new ClientSideImpl(GWT.getModuleBaseURL() + "greet");
		this.vPanel = new VerticalPanel();
		initWidget(vPanel);

		userLabel = new Label("Operatør ID");
		passwordLabel = new Label("Password");

		userBox = new TextBox();
		passwordBox = new PasswordTextBox();

		okBtn = new Button("Ok");
		okBtn.setEnabled(false);

		vPanel.add(userLabel);
		vPanel.add(userBox);
		vPanel.add(passwordLabel);
		vPanel.add(passwordBox);
		vPanel.add(okBtn);

		// Skal registrere om der er indtastet et integer i feltet, og rejse et flag, ok knappen kan aktiveres
		userBox.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				try {
					if(FieldVerifier.isIdValid(userBox.getText())){
						uBox = true;
					}
					else{
						uBox = false;
					}
				} catch (DALException e) {
					e.printStackTrace();
				}
				//okButtonEnabler();
			}
		});
		// Skal registrerer om der er indtastet minimum 6 tegn i feltet, og rejse et flag, så ok knappen kan aktiveres
		passwordBox.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				try {
					if(FieldVerifier.isPasswordValid(passwordBox.getText())){
						pwBox = true;
					}
					else{
						pwBox = false;
					}
				} catch (DALException e) {
				}
				//okButtonEnabler();

			}
		});

		//		this.clientImpl.service.getOperatorList(new AsyncCallback<List<OperatorDTO>>() {
		//
		//			@Override
		//			public void onFailure(Throwable caught) {
		//				// TODO Auto-generated method stub
		//				
		//			}
		//
		//			@Override
		//			public void onSuccess(List<OperatorDTO> result) {
		//				
		//				
		//			}
		//		});

		//Skal sende login dataen videre så den kan behandles, og operatøren eller admin kan registreres
		okBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//Skal have fat i den respektive callback, så brugeren kan valideres.
				//Herefter skal der komme en menu, altefter om det er en admin eller en operatør der er logget ind
				//Admin skal kunne bruge vægten samt have adgang til CRUD funktionerne.
				String loginData = userBox.getText() + "," + passwordBox.getText();

				try {
					clientImpl.service.login(loginData, new AsyncCallback<Boolean>() {

						public void onSuccess(Boolean result) {
							mc.mainView.show(new AdminMenu(mc));
							try {
								clientImpl.service.getOperator(Integer.parseInt(userBox.getText()),new AsyncCallback<OperatorDTO>() {

									public void onFailure(Throwable caught) {
										Window.alert("Hov - den operatør fandtes ikke" + caught.getMessage());

									}

									public void onSuccess(OperatorDTO result) {
										mc.LoggedInOperator = result;

									}
								});
							} catch (NumberFormatException e) {
								e.printStackTrace();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

						public void onFailure(Throwable caught) {
							Window.alert("Du loggede desværre ikke ind - prøv igen" + caught.getMessage());


						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


			private void okButtonEnabler(){
				if(pwBox && uBox){
					okBtn.setEnabled(true);
				}
				else{
					okBtn.setEnabled(false);
				};
			}
		});
	}
}








